package in.venkat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidMovieIdException;
import in.venkat.model.Show;
import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class ShowListDao {
	private ShowListDao() {
		/**
		 * Adding private constructor
		 */
	}

	private static final String DB_ERROR_STATUS = "unable to connect to data base";
	private static final String YEAR = "year";
	private static final String ID = "id";
	private static final String GENRE = "genre";
	private static final String NAME = "name";
	private static final String LANGUAGE = "language";
	private static final String CATEGORY = "category";
	private static final String MEMBERSHIP = "membership";
	private static final String GRADE = "grade";
	private static final String STATUS = "status";

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

			String sql = "select id,genre,name,year,language,category,membership,grade,status from shows ";
			preparedSt = connection.prepareStatement(sql);
			rs = preparedSt.executeQuery();

			while (rs.next()) {
				int movieId = rs.getInt(ID);
				String movieGenre = rs.getString(GENRE);
				String movieName = rs.getString(NAME);
				int movieYear = rs.getInt(YEAR);
				String movieLanguage = rs.getString(LANGUAGE);
				String movieCategory = rs.getString(CATEGORY);
				String membership = rs.getString(MEMBERSHIP);
				String movieGrade = rs.getString(GRADE);
				String movieStatus = rs.getString(STATUS);
				movieList.add(new Show(movieId, movieGenre, movieName, movieYear, movieLanguage, movieCategory,
						membership, movieGrade, movieStatus));

			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);

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
			String sql = "INSERT INTO shows (genre,name,year,language,category,membership,grade,status,likes) values (?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, show.getMovieGenre());
			pst.setString(2, show.getMovieName());
			pst.setInt(3, show.getMovieYear());
			pst.setString(4, show.getMovieLanguage());
			pst.setString(5, show.getMovieCategory());
			pst.setString(6, show.getMembership());
			pst.setString(7, show.getMovieGrade());
			pst.setString(8, show.getStatus());
			pst.setInt(9, show.getLikes());

			pst.executeUpdate();
		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);
		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

	/**
	 * This method is used to delete the movie by movie Id
	 * 
	 * @param movieId
	 * @throws DbException
	 * @throws InvalidDetailsException
	 * @throws InvalidMovieIdException
	 */
	public static void deleteMovies(int movieId) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM shows WHERE id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, movieId);

			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method id used to update the movie to prime and non prime
	 * 
	 * @param movieId
	 * @param membership
	 * @throws InvalidMovieIdException
	 * @throws DbException
	 */
	public static void updatePrimeStatus(int movieId, String membership) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update shows set membership = ? where id = ? ";
			pst = connection.prepareStatement(sql);
			pst.setString(1, membership);
			pst.setInt(2, movieId);

			pst.executeUpdate();

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is used to get favorite movie list
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static List<Show> getFavoriteMovie(String userId) throws DbException {
		List<Show> favorite = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedSt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select user_id,movie_id,genre,name,year,language,category,membership,grade,status from favorites where user_id=? ";
			preparedSt = connection.prepareStatement(sql);
			preparedSt.setString(1, userId);
			rs = preparedSt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("user_id");
				int movieId = rs.getInt("movie_id");
				String movieGenre = rs.getString(GENRE);
				String movieName = rs.getString(NAME);
				int movieYear = rs.getInt(YEAR);
				String movieLanguage = rs.getString(LANGUAGE);
				String movieCategory = rs.getString(CATEGORY);
				String membership = rs.getString(MEMBERSHIP);
				String movieGrade = rs.getString(GRADE);
				String movieStatus = rs.getString(STATUS);
				favorite.add(new Show(id, movieId, movieGenre, movieName, movieYear, movieLanguage, movieCategory,
						membership, movieGrade, movieStatus));

			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);

		} finally {
			ConnectionUtil.close(rs, preparedSt, connection);

		}
		return favorite;
	}

	/**
	 * This method is used to add favorite movies
	 * 
	 * @param show
	 * @throws DbException
	 */
	public static void addFavoriteMovies(Show show) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO favorites (user_id,movie_id,genre,name,year,language,category,membership,grade,status) values (?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, show.getUserId());
			pst.setInt(2, show.getId());
			pst.setString(3, show.getMovieGenre());
			pst.setString(4, show.getMovieName());
			pst.setInt(5, show.getMovieYear());
			pst.setString(6, show.getMovieLanguage());
			pst.setString(7, show.getMovieCategory());
			pst.setString(8, show.getMembership());
			pst.setString(9, show.getMovieGrade());
			pst.setString(10, show.getStatus());

			pst.executeUpdate();
		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);
		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

	/**
	 * This method is used to get the trending movies
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<Show> getTrendingMovies() throws DbException {
		List<Show> trending = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,genre,name,year,language,category,membership,grade,status,likes FROM shows ORDER BY likes DESC";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int movieId = rs.getInt(ID);
				String genre = rs.getString(GENRE);
				String name = rs.getString(NAME);
				int year = rs.getInt(YEAR);
				String language = rs.getString(LANGUAGE);
				String category = rs.getString(CATEGORY);
				String membership = rs.getString(MEMBERSHIP);
				String grade = rs.getString(GRADE);
				String status = rs.getString(STATUS);
				int likes = rs.getInt("likes");

				trending.add(
						new Show(movieId, genre, name, year, language, category, membership, grade, status, likes));

			}

		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);

		} finally {
			ConnectionUtil.close(rs, pst, connection);

		}
		return trending;

	}

	public static void updateLikes(int movieId) throws DbException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update shows set likes = likes+1 where id = ?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, movieId);
			pst.executeUpdate();
		} catch (SQLException e) {
			Logger.exception(e);
			throw new DbException(e, DB_ERROR_STATUS);

		} finally {
			ConnectionUtil.close(pst, connection);

		}
	}

}
