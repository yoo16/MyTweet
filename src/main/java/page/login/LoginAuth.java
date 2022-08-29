package page.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet(name = "LoginAuth", urlPatterns = { "/login/auth" })
public class LoginAuth extends HttpServlet {
	final static String USER_EMAIL = "alice@test.com";
	final static String USER_PASS = "pass1111";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession(true);

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String uri = "";
		User user = new User();
		User authUser = user.auth(email, password);
		if (authUser != null && authUser.id > 0) {
			session.setAttribute("auth_user", authUser);
			session.setAttribute("email", "");
			session.setAttribute("errors", "");
			uri = request.getContextPath() + "/tweet/";
		} else {
			session.setAttribute("email", email);
			session.setAttribute("errors", "Emailまたはパスワードが間違っています。");
			uri = request.getContextPath() + "/login/";
		}
		response.sendRedirect(uri);
	}

}