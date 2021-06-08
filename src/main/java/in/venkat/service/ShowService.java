package in.venkat.service;

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
	 * This method is used to search movies by giving genre and language 
	 * 
	 * @param filmGenre
	 * @param filmLanguage
	 * @return
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 * @throws DbException
	 */

	public static List<Show> searchContents(String filmGenre, String filmLanguage)
			throws EmptyFieldException, InvalidNameException, InvalidDetailsException, DbException {
		boolean isValid;
		List<Show> search = null;

		isValid = ValidateSearchDetails.validateDetails(filmGenre, filmLanguage);
		if (isValid) {
			search = searchMoviesByLanguageAndGenre(filmGenre, filmLanguage);
		}

		return search;
	}

	public static List<Show> searchMoviesByLanguageAndGenre(String filmGenre, String filmLanguage) throws DbException {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		primeMovieList = ShowListDao.getShowDetails();
		for (Show show : primeMovieList) {
			if (show.getMovieGenre().equalsIgnoreCase(filmGenre.trim())
					&& show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim()))
				filteredMovieList.add(show);
		}

		return filteredMovieList;

	}

	/**
	 * This method is used to search movies by membership
	 * 
	 * @param membership
	 * @return
	 * @throws DbException
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 * 
	 */
	public static List<Show> searchMoviesByMembership(String membership)
			throws DbException, EmptyFieldException, InvalidNameException, InvalidDetailsException {
		ValidateSearchDetails.validateDetails(membership);
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		primeMovieList = ShowListDao.getShowDetails();
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
	 * @throws DbException
	 */
	public static List<Show> searchMoviesByYear(int year) throws DbException {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		if (year > 1950 && year <= 2021) {
			primeMovieList = ShowListDao.getShowDetails();
			for (Show show : primeMovieList) {
				if (show.getMovieYear() == year) {
					filteredMovieList.add(show);
					Logger.log(show);
				}

			}
		}
		return filteredMovieList;
	}

	/**
	 * This method is used to search movies by language
	 * 
	 * @param filmLanguage
	 * @return
	 * @throws DbException
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 */
	public static List<Show> searchMoviesByLanguage(String filmLanguage)
			throws DbException, EmptyFieldException, InvalidNameException, InvalidDetailsException {
		ValidateSearchDetails.validateDetails(filmLanguage);

		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();

		primeMovieList = ShowListDao.getShowDetails();
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
	 * @throws DbException
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 */
	public static List<Show> displayAllMovies(String filmCategory)
			throws DbException, EmptyFieldException, InvalidNameException, InvalidDetailsException {
		ValidateSearchDetails.validateDetails(filmCategory);

		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();

		primeMovieList = ShowListDao.getShowDetails();
		for (Show show : primeMovieList) {
			if (show.getMovieCategory().equalsIgnoreCase(filmCategory.trim())) {
				filteredMovieList.add(show);
				Logger.log(show);
			}
		}

		return filteredMovieList;
	}
}
