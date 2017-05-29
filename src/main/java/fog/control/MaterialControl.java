package fog.control;

import fog.business.BusinessException;
import fog.business.BusinessFacadeMapper;
import fog.domain.Material;
import java.io.IOException;
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
    "/addMaterial"
})
public class MaterialControl extends HttpServlet
{
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

        request.getRequestDispatcher("addMaterial.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            HttpSession session = request.getSession();
            
            // Checks if user is logged in
            if(session.getAttribute("username")==null){
                response.sendRedirect("./login");
                return;
            }
            
            // request parameters, from addmaterial site.
            String name = request.getParameter("materialname");
            String type  = request.getParameter("select");
            //parse the parameters to Integers.
            int size = Integer.parseInt(request.getParameter("size"));
            int price = Integer.parseInt(request.getParameter("price"));
            Material material = new Material (name,type,size,price);
            
            // create Business facademapper, so we can acesse the database.
            BusinessFacadeMapper bFacadeMapper = new BusinessFacadeMapper();
            //insert the material
            bFacadeMapper.insertMatrial(material);
            
            // redirects to the index page.
            response.sendRedirect("index.html");
        } catch (BusinessException ex) {
            Logger.getLogger(MaterialControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
