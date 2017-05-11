package fog.control;

import fog.business.BusinessFacadeMapper;
import fog.business.BusinessException;
import fog.domain.Material;
import fog.domain.Order;
import fog.domain.OrderItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {
    "/createOrder"
})
public class CreateOrderControl extends HttpServlet {
    BusinessFacadeMapper bFacadeMapper = new BusinessFacadeMapper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            HttpSession session = request.getSession();
           
            ArrayList<String> callDates = bFacadeMapper.getBookedDates();
            session.setAttribute("calldate", callDates);
            
            request.getRequestDispatcher("createOrder.jsp").forward(request, response);
        } catch (BusinessException ex)
        {
            Logger.getLogger(CreateOrderControl.class.getName()).log(Level.SEVERE, null, ex);
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

            Order order = new Order(0, name, email, phone, false, width, length, height, skur, build, false, callDate);
            
            request.setAttribute("order", order);
            
            int orderID = bFacadeMapper.createOrder(order);
            

            ArrayList<Material> list = bFacadeMapper.createMaterialList(length, width, skur, height);
            bFacadeMapper.createOrderItems(list, orderID);

            //Sends the materiallist to the frontend
            ArrayList<OrderItem> orderItems = bFacadeMapper.getOrderItems(orderID);
            request.setAttribute("orderItems", orderItems);
            double total = bFacadeMapper.getOrderTotal(orderID);
            request.setAttribute("total", total);

            request.getRequestDispatcher("bestil.jsp").forward(request, response);
        } catch (BusinessException ex) {
            Logger.getLogger(CreateOrderControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

// How to update an order??!
// Get orderID -> Delete orderItems -> Update orderNumbers -> Create new orderItems 
