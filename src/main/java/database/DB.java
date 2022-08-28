package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	public static final String NAME = "jdbc:mysql://localhost:3306/mynews";
	public static final String USER = "root";
	public static final String PASS = "";

	public Connection connection;
	public PreparedStatement stmt;
	public ResultSet result;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(NAME, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("DB Connected!!");
		}
	}

	public void query(String sql) {
		System.out.println(sql);
		try {
			stmt = connection.prepareStatement(sql);
			stmt.execute();
			result = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			result.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
