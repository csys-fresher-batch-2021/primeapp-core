package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.venkat.model.Show;
import in.venkat.util.ConnectionUtil;

public class ShowListDao {
	private ShowListDao() {
		/**
		 *Adding private constructor
		 */
	}
	/**
	 * This method is used to get the details from the  table shows
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static List<Show> getShowDetails() throws SQLException, Exception  {
		List<Show> movieList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedSt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql =" select id,genre,name,year,language,category,membership,grade from shows ";
			preparedSt = connection.prepareStatement(sql);
			rs = preparedSt.executeQuery();

			while (rs.next()) {
				String movieId = rs.getString("id");
				String movieGenre = rs.getString("genre");
				String movieName = rs.getString("name");
				int movieYear = rs.getInt("year");
				String movieLanguage = rs.getString("language");
				String movieCategory = rs.getString("category");
				String membership = rs.getString("membership");
				String movieGrade = rs.getString("grade");
				movieList.add(new Show(movieId, movieGenre, movieName, movieYear, movieLanguage, movieCategory,
						membership, movieGrade));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(preparedSt, connection);

		}
		return movieList;
	}

}
