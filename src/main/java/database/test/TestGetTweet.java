package database.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBSetting;

@WebServlet(name = "TestGetTweet", urlPatterns = { "/test_get_tweet" })
public class TestGetTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM tweets";
			Connection connection = DriverManager.getConnection(DBSetting.NAME, DBSetting.USER, DBSetting.PASS);
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				PrintWriter out = response.getWriter();
				out.println(result.getString("id"));
				out.println(result.getInt("user_id"));
				out.println(result.getString("message"));
				out.println("<br>");
			}
			result.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
