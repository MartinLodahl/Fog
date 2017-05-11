package fog.control;

import fog.business.BusinessFacadeMapper;
import fog.data.CustomException;
import fog.data.FacadeMapper;
import fog.domain.Order;
import fog.helper.MapperHelp;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns =
{
    "/activeOrders",
    "/archivedOrders"
})
public class SearchControl extends HttpServlet
{
   private MapperHelp mapperHelp = new MapperHelp();
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
        
        
        HttpSession session = request.getSession();
        
        // Checks if user is logged in
        if(session.getAttribute("username")==null){
            response.sendRedirect("./login");
            return;
        }
        BusinessFacadeMapper bFacadeMapper = new BusinessFacadeMapper();
        System.out.println(bFacadeMapper);
        mapperHelp.setImapper(bFacadeMapper);
        try
        {
            List<Order> newOrders = mapperHelp.getImapper().getAllActiveOrders(true);
            List<Order> arkiveretOrders = mapperHelp.getImapper().getAllActiveOrders(false);
            request.setAttribute("newOrders", newOrders);
            request.setAttribute("arkiveretOrders", arkiveretOrders);
            
            switch (request.getServletPath()) {
                case "/activeOrders":
                    request.getRequestDispatcher("activeOrders.jsp").forward(request, response);
                    break;
                case "/archivedOrders":
                    request.getRequestDispatcher("archivedOrders.jsp").forward(request, response);
                    break;
            }
        } catch (CustomException ex)
        {
            Logger.getLogger(SearchControl.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException
    {
         
    }
}
