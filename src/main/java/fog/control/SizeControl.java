package fog.control;

import fog.data.Connector;
import fog.data.FacadeMapper;
import fog.data.OrderMapper;
import fog.domain.Material;
import fog.domain.Order;
import fog.domain.OrderItem;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SizeControl", urlPatterns = {
    "/createOrder"
})
public class SizeControl extends HttpServlet {
    FacadeMapper fm;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
             HttpSession session = request.getSession();
            Connector connector = new Connector();
            OrderMapper om = new OrderMapper(connector);
            System.out.println("test"+om.getBookedDates().size());
            ArrayList<String> callDates = om.getBookedDates();
            session.setAttribute("calldate", callDates);
            System.out.println("test");
            //request.getRequestDispatcher("size.jsp").forward(request, response);
        } catch (SQLException ex)
        {
            Logger.getLogger(SizeControl.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            int width = Integer.parseInt(request.getParameter("width"));
            int length = Integer.parseInt(request.getParameter("length"));
            int height = Integer.parseInt(request.getParameter("height"));
            boolean skur = request.getParameter("skur") != null;
            boolean build = request.getParameter("build") != null;
            String callDate = request.getParameter("callDate");
            System.out.println(callDate);
            /*
mm/dd/yyyy
måned/dag/år
dd-mm-yyyy
dag-måned-år

             */
            
            String tempDay = callDate.substring(3, 5);
            String tempMonth = callDate.substring(0,2);
            String tempYear = callDate.substring(6);
            
            StringBuilder SBcallDate = new StringBuilder();
            
            SBcallDate.append(tempDay + "-" + tempMonth + "-" + tempYear);
            callDate = SBcallDate.toString();
            System.out.println(callDate);

            Order order = new Order(0, name, email, phone, false, width, length, height, skur, build, false, callDate);
            fm = new FacadeMapper();
            request.setAttribute("order", order);
            System.out.println("create order");
            int orderID = fm.createOrder(order);
            System.out.println("end create order");

            ArrayList<Material> list = fm.CreateMaterialList(length, width, skur, height);
            fm.CreateOrderItems(list, orderID);

            //Sends the materiallist to the frontend
            ArrayList<OrderItem> orderItems = fm.getOrderItems(orderID);
            request.setAttribute("orderItems", orderItems);
            double total = fm.getOrderTotal(orderID);
            request.setAttribute("total", total);

            request.getRequestDispatcher("createOrder.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SizeControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
