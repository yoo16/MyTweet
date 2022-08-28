package database.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBSetting;

@WebServlet(name = "TestDBConnect", urlPatterns = { "/test_db_connect" })
public class TestDBConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println(DBSetting.NAME);
		out.println(DBSetting.USER);
		out.println(DBSetting.PASS);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(DBSetting.NAME, DBSetting.USER, DBSetting.PASS);
			out.println("success!!");
		} catch (SQLException e) {
			out.println("SQL Error!!");
		} catch (ClassNotFoundException e) {
			out.println("Class Error!!");
		}

	}

}
