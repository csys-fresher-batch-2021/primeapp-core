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
	 * @param flimGenre
	 * @param flimLanguage
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean searchContents(String flimGenre, String flimLanguage) throws SQLException, Exception {
		boolean isvalid = ValidateSearchDetails.validateDetails(flimGenre, flimLanguage);
		boolean search = false;
		if (isvalid) {
			search = printSearchMovies(flimGenre, flimLanguage);

		}
		return search;
	}

	/**
	 * 
	 * @param flimGenre
	 * @param flimLanguage
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean printSearchMovies(String flimGenre, String flimLanguage) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieGenre().equalsIgnoreCase(flimGenre.trim())
					&& show.getMovieLanguage().equalsIgnoreCase(flimLanguage.trim())) {
				System.out.println("GENRE : " + flimGenre + "LANGUAGE : " + flimLanguage);
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
	public static boolean printSearchMoviesByMembership(String membership) throws SQLException, Exception {
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
	public static boolean searchByYear(int year) throws SQLException, Exception {
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
	 * @param flimLanguage
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean printSearchMoviesByLanguage(String flimLanguage) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieLanguage().equalsIgnoreCase(flimLanguage.trim())) {
				System.out.println("LANGUAGE : " + flimLanguage);
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
	 * @param flimCategory
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean displayAllMovies(String flimCategory) throws SQLException, Exception {
		List<Show> primeMovieList = ShowListDao.getShowDetails();
		boolean searchDone = false;
		for (Show show : primeMovieList) {
			if (show.getMovieCategory().equalsIgnoreCase(flimCategory.trim())) {
				System.out.println("CATEGORY : " + flimCategory);
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
