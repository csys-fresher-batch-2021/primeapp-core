package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.model.Plans;
import in.venkat.model.PrimeTopup;
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

			String sql = "select id,plans,live_shows,multiplex_Indian,dubbed_original,advertisement,screens,video_quality,audio_quality from prime_plans";
			preparedSt = connection.prepareStatement(sql);
			rs = preparedSt.executeQuery();

			while (rs.next()) {
				int planid = rs.getInt("id");
				int primePlan = rs.getInt("plans");
				String liveShows = rs.getString("live_shows");
				String multiplexScreens = rs.getString("multiplex_Indian");
				String dubbed = rs.getString("dubbed_original");
				String advertisement = rs.getString("advertisement");
				int noOfScreens = rs.getInt("screens");
				String videoQuality = rs.getString("video_quality");
				String audioQuality = rs.getString("audio_quality");
				plans.add(new Plans(planid, primePlan, liveShows, multiplexScreens, dubbed, advertisement, noOfScreens,
						videoQuality, audioQuality));

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
	 * This method is used to get the registered users details
	 * 
	 * @return
	 * @throws DbException
	 * @throws InvalidUserIdException
	 */
	public static List<PrimeTopup> getPrimeUserIdDetails() throws DbException {
		List<PrimeTopup> primeUser = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select user_id from users";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String userId = rs.getString("user_id");
				primeUser.add(new PrimeTopup(userId));
			}
		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to dataBase");

		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}
		return primeUser;
	}

}