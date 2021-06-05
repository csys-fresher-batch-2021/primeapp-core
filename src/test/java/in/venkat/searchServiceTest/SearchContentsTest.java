package in.venkat.searchServiceTest;

import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.model.Show;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class SearchContentsTest {

	public static void main(String[] args) {
		/**
		 * To display all movies
		 */
		String category = "movie";
		displayAllMoviesTest(category);
		/**
		 * To filter by genre and language
		 */
		String genre = "action";
		String language1 = "english";
		searchMoviesByGenreAndLanguageTest(genre, language1);
		/**
		 * To filter by language
		 */
		String language = "english";
		searchMoviesByLanguageTest(language);
		/**
		 * To filter by membership
		 */
		String membership = "prime";
		searchMoviesByMembershipTest(membership);
		/**
		 * To filter by year
		 */
		int year = 2019;
		searchMoviesByYearTest(year);

	}

	/**
	 * This method is used to display all movies
	 * 
	 * @param category
	 */
	public static void displayAllMoviesTest(String category) {

		try {

			ShowService.displayAllMovies(category);

		} catch (Exception e) {
			Logger.exception(e);
		}
	}

	/**
	 * This method is used to filter movie by genre and language
	 * 
	 * @param genre
	 * @param language
	 */
	public static void searchMoviesByGenreAndLanguageTest(String genre, String language) {
		try {
			List<Show> search = ShowService.searchContents(genre, language);
			Logger.log(search);
		} catch (Exception e) {
			Logger.exception(e);
		}
	}

	/**
	 * This method is used to filter movie by language
	 * 
	 * @param language
	 */
	public static void searchMoviesByLanguageTest(String language) {
		try {

			ShowService.searchMoviesByLanguage(language);

		} catch (EmptyFieldException | InvalidNameException | InvalidDetailsException | DbException e) {
			Logger.exception(e);
		}
	}

	/**
	 * This method is used to filter movie by membership
	 * 
	 * @param membership
	 */

	public static void searchMoviesByMembershipTest(String membership) {
		try

		{
			ShowService.searchMoviesByMembership(membership);

		} catch (EmptyFieldException | InvalidNameException | InvalidDetailsException | DbException e) {
			Logger.exception(e);
		}
	}

	/**
	 * This method is used to filter movie by released year
	 * 
	 * @param year
	 */
	public static void searchMoviesByYearTest(int year) {

		try {
			ShowService.searchMoviesByYear(year);

		} catch (Exception e) {
			Logger.exception(e);
		}
	}
}
