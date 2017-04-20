package fog.control;

import fog.data.Connector;
import fog.data.OrderMapper;
import fog.data.UserMapper;
import fog.domain.Order;
import fog.domain.User;
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

@WebServlet(name = "DeleteControl", urlPatterns = {"/delete"})
public class DeleteControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Connector connector = new Connector();
            OrderMapper mapper = new OrderMapper(connector);
            mapper.deleteOrderById(id);
            response.sendRedirect("./search");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
