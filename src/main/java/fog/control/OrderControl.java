/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.control;

import fog.data.FacadeMapper;
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

/**
 *
 * @author Pravien
 */
@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private FacadeMapper facadeMapper;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        facadeMapper = new FacadeMapper();
        int orderId = Integer.parseInt(request.getParameter("orderid"));

        HttpSession session = request.getSession();
        //Checks if user is logged in, else redirect them to the login page
        if (session.getAttribute("username") == null) {
            response.sendRedirect("./login");
        } else {
            try {
                Order order = facadeMapper.getOrderById(orderId);
                ArrayList<OrderItem> orderItems = facadeMapper.getOrderItems(orderId);
                double total = facadeMapper.getOrderTotal(orderId);
                if (order == null) {

                    request.getRequestDispatcher("/searchError.jsp").forward(request, response);

                } else {

                    request.setAttribute("order", order);
                    request.setAttribute("orderItems", orderItems);
                    request.setAttribute("total", total);

                    request.getRequestDispatcher("order.jsp").forward(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OrderControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Checks if user is logged in
        if (session.getAttribute("username") == null) {
            response.sendRedirect("./login");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String orderDone = request.getParameter("orderDone");

        

        try {
            Order order = facadeMapper.getOrderById(id);

            order.setStatus(orderDone != null);
            facadeMapper.updateOrder(order);
            response.sendRedirect("order?orderid=" + id);
            //request.getRequestDispatcher("order.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(OrderControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
