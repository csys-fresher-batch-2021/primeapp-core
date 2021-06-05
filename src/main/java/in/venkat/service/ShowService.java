package in.venkat.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.venkat.dao.ShowListDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.model.Show;
import in.venkat.util.Logger;
import in.venkat.validator.ValidateSearchDetails;

public class ShowService {
	private ShowService() {
		/**
		 * Adding private constructor
		 */
	}

	private static final String MOVIE_GENRE = " MOVIE GENRE :";
	private static final String MOVIE_YEAR = " MOVIE YEAR :";
	private static final String MOVIE_LANGUAGE = " MOVIE LANGUAGE :";
	private static final String CATEGORY = " CATEGORY :";
	private static final String MEMBERSHIP = " MEMBERSHIP :";

	/**
	 * This method is used to search movies by giving genre and language details
	 * 
	 * @param filmGenre
	 * @param filmLanguage
	 * @return
	 * @throws SQLException
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 * @throws DbException
	 * @throws Exception
	 */
	public static List<Show> searchContents(String filmGenre, String filmLanguage)
			throws SQLException, EmptyFieldException, InvalidNameException, InvalidDetailsException, DbException {
		boolean isValid = ValidateSearchDetails.validateDetails(filmGenre, filmLanguage);
		List<Show> search = null;
		if (isValid) {
			search = searchMoviesByLanguageAndGenre(filmGenre, filmLanguage);

		}
		return search;
	}

	/**
	 * 
	 * @param filmGenre
	 * @param filmLanguage
	 * @return
	 * @throws SQLException
	 * @throws DbException
	 * @throws Exception
	 */
	public static List<Show> searchMoviesByLanguageAndGenre(String filmGenre, String filmLanguage)
			throws SQLException, DbException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		List<Show> filteredMovieList = new ArrayList<>();
		filteredMovieList.removeAll(filteredMovieList);
		for (Show show : primeMovieList) {
			if (show.getMovieGenre().equalsIgnoreCase(filmGenre.trim())
					&& show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim()))
				filteredMovieList.add(show);
//				Logger.log(MOVIE_GENRE + filmGenre + MOVIE_LANGUAGE + filmLanguage);
//				Logger.log(show);
//				searchDone = true;

		}
		return filteredMovieList;

	}

	/**
	 * This method is used to search movies by membership
	 * 
	 * @param membership
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DbException
	 * @throws Exception
	 */
	public static List<Show> searchMoviesByMembership(String membership) throws SQLException, DbException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		List<Show> filteredMovieList = new ArrayList<>();
		filteredMovieList.removeAll(filteredMovieList);
		for (Show show : primeMovieList) {
			if (show.getMembership().equalsIgnoreCase(membership.trim())) {
				filteredMovieList.add(show);
				Logger.log(show);
			}
		}
		return filteredMovieList;
	}

	/**
	 * This method is used to search movies by the released year
	 * 
	 * @param year
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DbException
	 * @throws Exception
	 */
	public static List<Show> searchMoviesByYear(int year) throws SQLException, DbException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		List<Show> filteredMovieList = new ArrayList<>();
		filteredMovieList.removeAll(filteredMovieList);
		for (Show show : primeMovieList) {
			if (show.getMovieYear() == year) {
				filteredMovieList.add(show);
				Logger.log(show);

			}
		}
		return filteredMovieList;
	}

	/**
	 * This method is used to search movies by language
	 * 
	 * @param filmLanguage
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DbException
	 * @throws Exception
	 */
	public static List<Show> searchMoviesByLanguage(String filmLanguage) throws SQLException, DbException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		List<Show> filteredMovieList = new ArrayList<>();
		filteredMovieList.removeAll(filteredMovieList);
		for (Show show : primeMovieList) {
			if (show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim())) {
				filteredMovieList.add(show);
				Logger.log(show);

			}
		}
		return filteredMovieList;
	}

	/**
	 * This method is used to display all movies
	 * 
	 * @param filmCategory
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DbException
	 * @throws Exception
	 */
	public static List<Show> displayAllMovies(String filmCategory) throws SQLException, DbException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		List<Show> filteredMovieList = new ArrayList<>();
		filteredMovieList.removeAll(filteredMovieList);
		for (Show show : primeMovieList) {
			if (show.getMovieCategory().equalsIgnoreCase(filmCategory.trim())) {
				filteredMovieList.add(show);
				Logger.log(show);
			}
		}
		return filteredMovieList;
	}
}
