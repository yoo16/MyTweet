package page.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginIndex", urlPatterns = { "/login/" })
public class LoginIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jsp = "/views/login/index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String errors = (String) session.getAttribute("errors");

		email = (email != null) ? email : "";
		errors = (errors != null) ? errors : "";
		
		request.setAttribute("email", email);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher(jsp).forward(request, response); 
	}

}
