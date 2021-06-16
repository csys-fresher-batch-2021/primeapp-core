package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.venkat.exceptions.DbException;
import in.venkat.model.Admin;
import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class AdminDao {
	private AdminDao() {
		/**
		 * Adding a private constructor
		 */
	}
	/**
	 * This method is used to get admin details from the database
	 * @return
	 * @throws DbException
	 */
	public static List<Admin> getAdminDetails() throws DbException {
		List<Admin> adminDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select admin_name,admin_password from admin";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String adminName = rs.getString("admin_name");
				String adminPassword = rs.getString("admin_password");
				adminDetails.add(new Admin(adminName, adminPassword));
			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to database");
		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}

		return adminDetails;

	}

}
