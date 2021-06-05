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
	public static List<Show> searchContents(String filmGenre, String filmLanguage) {
		boolean isValid;
		List<Show> search = null;

		try {
			isValid = ValidateSearchDetails.validateDetails(filmGenre, filmLanguage);
			if (isValid) {
				search = searchMoviesByLanguageAndGenre(filmGenre, filmLanguage);
			}
		} catch (EmptyFieldException | InvalidNameException | InvalidDetailsException e1) {
			Logger.log(e1.getMessage());
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
	public static List<Show> searchMoviesByLanguageAndGenre(String filmGenre, String filmLanguage) {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();

		try {
			primeMovieList = ShowListDao.getShowDetails();
			filteredMovieList.removeAll(filteredMovieList);
			for (Show show : primeMovieList) {
				if (show.getMovieGenre().equalsIgnoreCase(filmGenre.trim())
						&& show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim()))
					filteredMovieList.add(show);
			}
		}

		catch (DbException e) {
			Logger.log(e.getMessage());
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
	public static List<Show> searchMoviesByMembership(String membership) {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		try {
			primeMovieList = ShowListDao.getShowDetails();
			filteredMovieList.removeAll(filteredMovieList);
			for (Show show : primeMovieList) {
				if (show.getMembership().equalsIgnoreCase(membership.trim())) {
					filteredMovieList.add(show);
					Logger.log(show);
				}
			}
		} catch (DbException e) {
			Logger.log(e.getMessage());
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
	public static List<Show> searchMoviesByYear(int year) {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();

		try {
			primeMovieList = ShowListDao.getShowDetails();
			filteredMovieList.removeAll(filteredMovieList);
			for (Show show : primeMovieList) {
				if (show.getMovieYear() == year) {
					filteredMovieList.add(show);
					Logger.log(show);

				}

			}
		} catch (DbException e) {
			Logger.log(e.getMessage());
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
	public static List<Show> searchMoviesByLanguage(String filmLanguage) {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		try {
			primeMovieList = ShowListDao.getShowDetails();
			filteredMovieList.removeAll(filteredMovieList);
			for (Show show : primeMovieList) {
				if (show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim())) {
					filteredMovieList.add(show);
					Logger.log(show);

				}
			}
		} catch (DbException e) {
			Logger.log(e.getMessage());
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
	public static List<Show> displayAllMovies(String filmCategory) {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();

		try {
			primeMovieList = ShowListDao.getShowDetails();
			filteredMovieList.removeAll(filteredMovieList);
			for (Show show : primeMovieList) {
				if (show.getMovieCategory().equalsIgnoreCase(filmCategory.trim())) {
					filteredMovieList.add(show);
					Logger.log(show);
				}
			}
		} catch (DbException e) {
			Logger.log(e.getMessage());
		}

		return filteredMovieList;
	}
}
