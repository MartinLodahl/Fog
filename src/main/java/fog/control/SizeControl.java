package fog.control;

import fog.data.Connector;
import fog.data.MaterialMapper;
import fog.data.OrderMapper;
import fog.data.UserMapper;
import fog.domain.Material;
import fog.domain.Order;
import fog.domain.OrderItem;
import fog.domain.User;
import java.io.IOException;
import java.io.PrintWriter;
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
            Connector connector = new Connector();
            OrderMapper mapper = new OrderMapper(connector);
            System.out.println("create order");
            int orderID = mapper.createOrder(order);
             System.out.println("end create order");
            MaterialMapper mm = new MaterialMapper(connector);
            ArrayList<Material> list = mm.CreateMaterialList(length, width, skur, height);
            mm.CreateOrderItems(list, orderID);
            
            //Sends the materiallist to the frontend
            ArrayList<OrderItem> orderItems = mapper.getOrderItems(orderID);
            request.setAttribute("orderItems", orderItems);
            double total = mapper.getOrderTotal(orderID);
            request.setAttribute("total", total);

            request.getRequestDispatcher("bestil.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SizeControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
