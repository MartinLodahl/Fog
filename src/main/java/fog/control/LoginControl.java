package fog.control;

import fog.data.FacadeMapper;
import fog.domain.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            FacadeMapper fm = new FacadeMapper();
            HttpSession session = request.getSession();
            if (request.getParameter("logOut") != null) {
                session.removeAttribute("username");
                response.sendRedirect("login");
                return;
            }

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = fm.getUserByUsername(username);

            if (user != null && password.equals(user.getPassword())) {
                session.setAttribute("username", username);
                response.sendRedirect("./mainpage.jsp");
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
