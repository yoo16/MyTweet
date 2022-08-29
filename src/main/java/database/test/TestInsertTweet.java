package database.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBSetting;

@WebServlet(name = "TestInsertTweet", urlPatterns = { "/test_insert_tweet" })
public class TestInsertTweet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String message = request.getParameter("message");
		System.out.println(message);

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// user_id をランダムで設定
			Random rand = new Random();
			int userId = rand.nextInt(100) - 1;

			Connection connection = DriverManager.getConnection(DBSetting.NAME, DBSetting.USER, DBSetting.PASS);

			// INSERT
			String sql = "INSERT INTO tweets SET message = ?, user_id = ?;";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, message);
			stmt.setInt(2, userId);
			stmt.execute();

			stmt.close();
			connection.close();

			response.sendRedirect(request.getContextPath() + "/test_db_index");
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

}
