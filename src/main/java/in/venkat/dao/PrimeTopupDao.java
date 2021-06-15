package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import in.venkat.exceptions.DbException;
import in.venkat.model.PrimeTopup;
import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class PrimeTopupDao {
	private PrimeTopupDao() {
		/**
		 * Adding a private constructor
		 */
	}

	/**
	 * This method is used to store the topup details
	 * 
	 * @param primeTopup
	 * @throws DbException
	 */
	public static void saveTopupDetails(PrimeTopup primeTopup) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into prime_topup (user_id,plan,recharge_on,validity,expires_on) values(?,?,?,?,?)";
			pst = connection.prepareStatement(sql);

			pst.setString(1, primeTopup.getUserId());
			pst.setDouble(2, primeTopup.getCost());
			pst.setObject(3, primeTopup.getRechargeDate());
			pst.setInt(4, primeTopup.getValidity());
			pst.setObject(5, primeTopup.getExpiryDate());

			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to dataBase");

		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}

	}

	/**
	 * This method is used to get the expire date from the table
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<PrimeTopup> getExpiryDate() throws DbException {
		List<PrimeTopup> validTopupDate = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select user_id,expires_on from prime_topup";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String userId = rs.getString("user_id");
				LocalDate expiryDate = LocalDate.parse(rs.getString("expires_on"));
				validTopupDate.add(new PrimeTopup(userId, expiryDate));
			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to database");
		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}

		return validTopupDate;

	}

}
