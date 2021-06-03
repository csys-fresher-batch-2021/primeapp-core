package in.venkat.service;

import java.sql.SQLException;
import java.util.List;

import in.venkat.dao.ShowListDao;
import in.venkat.model.Show;
import in.venkat.validator.ValidateSearchDetails;

public class ShowService {

	/**
	 * This method is used to search movies by giving genre and language details
	 * 
	 * @param filmGenre
	 * @param filmLanguage
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchContents(String filmGenre, String filmLanguage) throws SQLException, Exception {
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
	public static boolean searchMoviesByLanguage(String filmGenre, String filmLanguage) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieGenre().equalsIgnoreCase(filmGenre.trim())
					&& show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim())) {
				System.out.println("GENRE : " + filmGenre + "LANGUAGE : " + filmLanguage);
				System.out.println("MOVIE ID : " + show.getId() + " GENRE : " + show.getMovieGenre() + " MOVIE NAME : "
						+ show.getMovieName() + " MOVIE YEAR : " + show.getMovieYear() + " MOVIE LANGUAGE :"
						+ show.getMovieLanguage() + " CATEGORY : " + show.getMovieCategory() + " MEMBERSHIP : "
						+ show.getMembership() + " GRADE : " + show.getMovieGrade());
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
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchMoviesByMembership(String membership) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMembership().equalsIgnoreCase(membership.trim())) {
				System.out.println("MEMBERSHIP : " + membership);
				System.out.println("MOVIE ID : " + show.getId() + " GENRE : " + show.getMovieGenre() + " MOVIE NAME : "
						+ show.getMovieName() + " MOVIE YEAR : " + show.getMovieYear() + " MOVIE LANGUAGE :"
						+ show.getMovieLanguage() + " CATEGORY : " + show.getMovieCategory() + " MEMBERSHIP : "
						+ show.getMembership() + " GRADE : " + show.getMovieGrade());
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
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchMoviesByYear(int year) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchByYear = false;
		for (Show show : primeMovieList) {
			if (show.getMovieYear() == year) {
				System.out.println("YEAR : " + year);
				System.out.println("MOVIE ID : " + show.getId() + " GENRE : " + show.getMovieGenre() + " MOVIE NAME : "
						+ show.getMovieName() + " MOVIE YEAR : " + show.getMovieYear() + " MOVIE LANGUAGE :"
						+ show.getMovieLanguage() + " CATEGORY : " + show.getMovieCategory() + " MEMBERSHIP : "
						+ show.getMembership() + " GRADE : " + show.getMovieGrade());
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
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchMoviesByLanguage(String filmLanguage) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim())) {
				System.out.println("LANGUAGE : " + filmLanguage);
				System.out.println("MOVIE ID : " + show.getId() + " GENRE : " + show.getMovieGenre() + " MOVIE NAME : "
						+ show.getMovieName() + " MOVIE YEAR : " + show.getMovieYear() + " MOVIE LANGUAGE :"
						+ show.getMovieLanguage() + " CATEGORY : " + show.getMovieCategory() + " MEMBERSHIP : "
						+ show.getMembership() + " GRADE : " + show.getMovieGrade());
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
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean displayAllMovies(String filmCategory) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieCategory().equalsIgnoreCase(filmCategory.trim())) {
				System.out.println("CATEGORY : " + filmCategory);
				System.out.println("MOVIE ID : " + show.getId() + " GENRE : " + show.getMovieGenre() + " MOVIE NAME : "
						+ show.getMovieName() + " MOVIE YEAR : " + show.getMovieYear() + " MOVIE LANGUAGE :"
						+ show.getMovieLanguage() + " CATEGORY : " + show.getMovieCategory() + " MEMBERSHIP : "
						+ show.getMembership() + " GRADE : " + show.getMovieGrade());
				searchDone = true;

			}
		}
		return searchDone;
	}
}
