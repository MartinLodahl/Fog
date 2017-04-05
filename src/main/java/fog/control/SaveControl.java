/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.control;

import fog.data.Connector;
import fog.data.OrderMapper;
import fog.domain.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "SaveControl", urlPatterns =
{
    "/save"
})
public class SaveControl extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            throws ServletException, IOException
    {
        processRequest(request, response);
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
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        // Checks if user is logged in
        if(session.getAttribute("username")==null){
            response.sendRedirect("./login");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        String orderDone = request.getParameter("orderDone");
        
        Connector connector = new Connector();
        OrderMapper mapper = new OrderMapper(connector);
        
       try
        {
           Order order = mapper.getOrderById(id);
            if(orderDone!=null){
                order.setIsFinished(true);
                mapper.updateOrder(order);
                //(response.sendRedirect(request.getRequestURI());
                request.getRequestDispatcher("order.jsp").forward(request, response);
            }
            else{
               mapper.updateOrder(order); 
               //response.sendRedirect(request.getRequestURI());
               request.getRequestDispatcher("order.jsp").forward(request, response);
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(SaveControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
