package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.model.Show;
import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class ShowListDao {
	private ShowListDao() {
		/**
		 * Adding private constructor
		 */
	}

	/**
	 * This method is used to get the details from the table shows
	 * 
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<Show> getShowDetails() throws DbException {
		List<Show> movieList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedSt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select id,genre,name,year,language,category,membership,grade from shows";
			preparedSt = connection.prepareStatement(sql);
			rs = preparedSt.executeQuery();

			while (rs.next()) {
				int movieId = rs.getInt("id");
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
			throw new DbException(e, "unable to connect to dataBase");

		} finally {
			ConnectionUtil.close(rs, preparedSt, connection);

		}
		return movieList;
	}

	/**
	 * This method is used to add movies
	 * 
	 * @param show
	 * @throws DbException
	 */
	public static void addMovies(Show show) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO shows (genre,name,year,language,category,membership,grade ) values (?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, show.getMovieGenre());
			pst.setString(2, show.getMovieName());
			pst.setInt(3, show.getMovieYear());
			pst.setString(4, show.getMovieLanguage());
			pst.setString(5, show.getMovieCategory());
			pst.setString(6, show.getMembership());
			pst.setString(7, show.getMovieGrade());

			pst.executeUpdate();
		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, "unable to connect to database");
		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

}
