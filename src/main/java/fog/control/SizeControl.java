package fog.control;

import fog.data.FacadeMapper;
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


@WebServlet(name = "SizeControl", urlPatterns = {"/size"})
public class SizeControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("size.jsp").forward(request, response);
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

            Order order = new Order(0, name, email, phone, false, width, length, height, skur, build, false);
            FacadeMapper fm = new FacadeMapper();
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

            request.getRequestDispatcher("bestil.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SizeControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
