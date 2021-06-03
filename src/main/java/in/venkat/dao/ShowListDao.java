package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.venkat.model.Show;
import in.venkat.util.ConnectionUtil;

public class ShowListDao {
	/**
	 * This method is used to get the details from the table
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static List<Show> getShowDetails() throws Exception, SQLException {
		List<Show> movieList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedSt = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select * from categories ";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);

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
			throw new RuntimeException("unable to search");

		} finally {
			ConnectionUtil.close(preparedSt, connection);

		}
		return movieList;
	}

}
