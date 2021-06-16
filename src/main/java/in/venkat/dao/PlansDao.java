package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.model.Plans;
import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class PlansDao {
	private PlansDao() {
		/**
		 * Adding private constructor
		 */
	}

	/**
	 * This method is used to get the prime plan details
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<Plans> getPrimePlans() throws DbException {
		List<Plans> plans = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedSt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select plan_id,plans,validity,live_shows,multiplex_Indian,dubbed_original,advertisement,screens,video_quality,audio_quality from prime_plans";
			preparedSt = connection.prepareStatement(sql);
			rs = preparedSt.executeQuery();

			while (rs.next()) {
				int planid = rs.getInt("plan_id");
				int primePlan = rs.getInt("plans");
				int validity = rs.getInt("validity");
				String liveShows = rs.getString("live_shows");
				String multiplexScreens = rs.getString("multiplex_Indian");
				String dubbed = rs.getString("dubbed_original");
				String advertisement = rs.getString("advertisement");
				int noOfScreens = rs.getInt("screens");
				String videoQuality = rs.getString("video_quality");
				String audioQuality = rs.getString("audio_quality");
				plans.add(new Plans(planid, primePlan, validity, liveShows, multiplexScreens, dubbed, advertisement,
						noOfScreens, videoQuality, audioQuality));

			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to dataBase");

		} finally {
			ConnectionUtil.close(rs, preparedSt, connection);

		}
		return plans;
	}

	/**
	 * This method is used to count the number of plans
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int totalPlans() throws SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select count(*) from prime_plans";

			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			Logger.exception(e);
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}

		return count;
	}
}