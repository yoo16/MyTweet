package database.test;

import java.io.IOException;
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

@WebServlet(name = "TestDeleteTweet", urlPatterns = { "/test_delete_tweet" })
public class TestDeleteTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection;
	public PreparedStatement stmt;
	public ResultSet result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "DELETE FROM tweets";
			connection = DriverManager.getConnection(DBSetting.NAME, DBSetting.USER, DBSetting.PASS);
			stmt = connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			connection.close();
			
			String uri = request.getContextPath() + "/db_sample.html";
			response.sendRedirect(uri);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
