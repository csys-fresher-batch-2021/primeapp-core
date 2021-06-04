package in.venkat.service;

import java.sql.SQLException;
import java.util.List;

import in.venkat.dao.ShowListDao;
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
	 * @throws Exception
	 */
	public static boolean searchContents(String filmGenre, String filmLanguage) throws Exception {
		boolean isValid = ValidateSearchDetails.validateDetails(filmGenre, filmLanguage);
		boolean search = false;
		if (isValid) {
			search = searchMoviesByLanguage(filmGenre, filmLanguage);

		}
		return search;
	}

	/**
	 * 
	 * @param filmGenre
	 * @param filmLanguage
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchMoviesByLanguage(String filmGenre, String filmLanguage) throws Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieGenre().equalsIgnoreCase(filmGenre.trim())
					&& show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim())) {
				Logger.log(MOVIE_GENRE + filmGenre + MOVIE_LANGUAGE + filmLanguage);
				Logger.log(show);
				searchDone = true;

			}

		}
		return searchDone;
	}

	/**
	 * This method is used to search movies by membership
	 * 
	 * @param membership
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchMoviesByMembership(String membership) throws ClassNotFoundException, SQLException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMembership().equalsIgnoreCase(membership.trim())) {
				Logger.log(MEMBERSHIP + membership);
				Logger.log(show);
				searchDone = true;

			}
		}
		return searchDone;
	}

	/**
	 * This method is used to search movies by the released year
	 * 
	 * @param year
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchMoviesByYear(int year) throws ClassNotFoundException, SQLException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchByYear = false;
		for (Show show : primeMovieList) {
			if (show.getMovieYear() == year) {
				Logger.log(MOVIE_YEAR + year);
				Logger.log(show);
				searchByYear = true;

			}
		}
		return searchByYear;
	}

	/**
	 * This method is used to search movies by language
	 * 
	 * @param filmLanguage
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchMoviesByLanguage(String filmLanguage) throws ClassNotFoundException, SQLException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim())) {
				Logger.log(MOVIE_LANGUAGE + filmLanguage);
				Logger.log(show);
				searchDone = true;

			}
		}
		return searchDone;
	}

	/**
	 * This method is used to display all movies
	 * 
	 * @param filmCategory
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean displayAllMovies(String filmCategory) throws ClassNotFoundException, SQLException {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieCategory().equalsIgnoreCase(filmCategory.trim())) {
				Logger.log(CATEGORY + filmCategory);
				Logger.log(show);
				searchDone = true;

			}
		}
		return searchDone;
	}
}
