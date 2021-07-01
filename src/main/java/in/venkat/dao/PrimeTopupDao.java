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

	private static final String DB_ERROR_STATUS = "unable to connect to data base";

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
			String sql = "insert into prime_topup (user_id,plan,recharge_on,validity,screen,expires_on) values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, primeTopup.getUserId());
			pst.setDouble(2, primeTopup.getCost());
			pst.setObject(3, primeTopup.getRechargeDate());
			pst.setInt(4, primeTopup.getValidity());
			pst.setInt(5, primeTopup.getScreen());
			pst.setObject(6, primeTopup.getExpiryDate());

			int row = pst.executeUpdate();
			if (row == 1) {
				Logger.log("succesfully recharged");
			} else {
				Logger.log("can't recharge ,try again");
			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);

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
	public static List<PrimeTopup> getTopupDetails() throws DbException {
		List<PrimeTopup> validTopupDate = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select topup_id,user_id,plan,expires_on,screen from prime_topup";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int topupId = rs.getInt("topup_id");
				String userId = rs.getString("user_id");
				int plan = rs.getInt("plan");
				LocalDate expiryDate = LocalDate.parse(rs.getString("expires_on"));
				int screen = rs.getInt("screen");
				validTopupDate.add(new PrimeTopup(topupId, userId, plan, expiryDate, screen));
			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);
		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}

		return validTopupDate;
	}

	/**
	 * This method is used to update the screen status
	 * 
	 * @param topupId
	 * @param count
	 * @throws DbException
	 */
	public static void updateScreenStatus(int topupId, int count) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update  prime_topup  set  screen=? where topup_id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, count);
			pst.setInt(2, topupId);
			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
}
