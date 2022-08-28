package page.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebServlet(name = "UserIndex", urlPatterns = { "/user/" })
public class UserIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jsp = "/views/user/index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			User user = (User) request.getSession().getAttribute("auth_user");
			if (user.id > 0) {
				request.setAttribute("user", user);
				request.getRequestDispatcher(jsp).forward(request, response);
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/login/");
		}
	}

}
