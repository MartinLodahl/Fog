package fog.control;

import fog.business.BusinessFacadeMapper;
import fog.data.CustomException;
import fog.domain.User;
import fog.helper.PasswordAuthentication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
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

            BusinessFacadeMapper bFacadeMapper = new BusinessFacadeMapper();
            HttpSession session = request.getSession();
            if (request.getParameter("logOut") != null) {
                session.removeAttribute("username");
                response.sendRedirect("login");
                return;
            }

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = bFacadeMapper.getUserByUsername(username);

            PasswordAuthentication auth = new PasswordAuthentication();
            if (user != null && auth.authenticate(password.toCharArray(), user.getPassword())) {
                session.setAttribute("username", username);
                response.sendRedirect("./activeOrders");
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (CustomException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
