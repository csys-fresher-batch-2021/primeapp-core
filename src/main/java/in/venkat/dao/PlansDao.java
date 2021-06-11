package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.model.Plans;
import in.venkat.model.Show;
import in.venkat.util.ConnectionUtil;

public class PlansDao {
	private PlansDao() {
		/**
		 * Adding private constructor
		 */
	}

	public static  List<Plans> getPrimePlans() throws DbException {
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
				String Dubbed = rs.getString("dubbed_original");
				String advertisement = rs.getString("advertisement");
				int noOfScreens = rs.getInt("screens");
				String videoQuality = rs.getString("video_quality");
				String audioQuality = rs.getString("audio_quality");
				plans.add(new Plans(planid, primePlan, liveShows, multiplexScreens, Dubbed, advertisement,
						noOfScreens, videoQuality, audioQuality));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e, "unable to connect to dataBase");

		} finally {
			ConnectionUtil.close(rs, preparedSt, connection);

		}
		return plans;
	}

}