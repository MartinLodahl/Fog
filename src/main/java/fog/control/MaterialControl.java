package fog.control;

import fog.business.BusinessFacadeMapper;
import fog.data.CustomException;
import fog.data.FacadeMapper;
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
            
            String name = request.getParameter("materialname");
            String type  = request.getParameter("select");
            int size = Integer.parseInt(request.getParameter("size"));
            int price = Integer.parseInt(request.getParameter("price"));
            Material material = new Material (name,type,size,price);
            
            
            BusinessFacadeMapper bFacadeMapper = new BusinessFacadeMapper();
            bFacadeMapper.insertMatrial(material);
            
            response.sendRedirect("index.html");
        } catch (CustomException ex) {
            Logger.getLogger(MaterialControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
