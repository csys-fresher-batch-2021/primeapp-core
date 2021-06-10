package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.model.User;
import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class UserDao {
	private UserDao() {
		/**
		 * adding a private constructor
		 */

	}

	/**
	 * This method is used to store the registered user details
	 * 
	 * @param register
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DbException
	 */
	public static void register(User register) throws SQLException, DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "insert into users (user_id,name,phone_number,password,joined_on)  values(?,?,?,?,now());";

			pst = connection.prepareStatement(sql);
			pst.setString(1, register.getUserId());
			pst.setString(2, register.getUserName());
			pst.setLong(3, register.getPhoneNumber());
			pst.setString(4, register.getPassword());

			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException("unable to add user");

		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

	/**
	 * This method is used to get the userId and Password from the users table
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<User> getUserDetailsByUserId() throws DbException {
		List<User> userLogin = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select user_id,password from users";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("user_id");
				String userPassword = rs.getString("password");
				userLogin.add(new User(userId, userPassword));

			}
		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to dataBase");

		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}
		return userLogin;
	}

	/**
	 * This method is used to get the Phone number and password from the users table
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<User> getUserDetailsByPhoneNumber() throws DbException {
		List<User> userLogin = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select phone_number,password from users";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				long phoneNumber = rs.getLong("phone_number");
				String userPassword = rs.getString("password");
				userLogin.add(new User(phoneNumber, userPassword));

			}
		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to dataBase");

		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}
		return userLogin;
	}
}
