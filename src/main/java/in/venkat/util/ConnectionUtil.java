package in.venkat.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	private ConnectionUtil() {
		/**
		 * Default constructor
		 */
	}

	private static String driverClass = System.getenv("spring.datasource.driver-class-name");
	private static String url = System.getenv("spring.datasource.url");
	private static String username = System.getenv("spring.datasource.username");
	private static String password = System.getenv("spring.datasource.password");

	/**
	 * This method creates a database connection.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			Logger.log(e.getMessage());
		}

		return DriverManager.getConnection(url, username, password);

	}

	/**
	 * This method is used to close the connection of ResultSet connection and
	 * prepared statement Method overloading
	 * 
	 * @param con
	 */
	public static void close(ResultSet rs, Statement statement, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * This method closes the connections for statement and connection.
	 * 
	 * @param statement
	 * @param con
	 */
	public static void close(Statement statement, Connection con) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}