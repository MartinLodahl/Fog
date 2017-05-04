package fog.control;

import fog.data.FacadeMapper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteControl", urlPatterns = {"/delete"})
public class DeleteControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            FacadeMapper fm = new FacadeMapper();
            fm.deleteOrderById(id);
            response.sendRedirect("./search");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
