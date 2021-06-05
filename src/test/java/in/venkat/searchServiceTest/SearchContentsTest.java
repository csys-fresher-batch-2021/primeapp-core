package in.venkat.searchServiceTest;

import java.sql.SQLException;
import java.util.List;

import in.venkat.model.Show;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;
import in.venkat.validator.ValidateSearchDetails;

public class SearchContentsTest {

	public static void main(String[] args) throws SQLException, Exception {

		/**
		 * Display all movies
		 */
		String category = "movie";
		boolean categoryValid = ValidateSearchDetails.validateDetails(category);
		if (categoryValid) {
			ShowService.displayAllMovies(category);
		} else {
			Logger.log("Category does not exists");
		}

		/**
		 * Searching movies by Genre and Language
		 */
		List<Show> search = ShowService.searchContents("action", "english");
		Logger.log(search);
		/**
		 * Searching movies by Language
		 */
		String language = "english";
		boolean languageValid = ValidateSearchDetails.validateDetails(language);
		if (languageValid) {
			ShowService.searchMoviesByLanguage(language);
		} else {
			Logger.log("Invalid Language");
		}
		/**
		 * Searching movies by membership
		 */
		String membership = "non prime";
		boolean membershipValid = ValidateSearchDetails.validateDetails(membership);
		if (membershipValid) {
			ShowService.searchMoviesByMembership(membership);
		} else {
			Logger.log("Invalid membership");
		}
		/**
		 * Searching movies by year // non prime
		 */
		int year = 2019;
		if (year > 1950 && year <= 2021) {
			ShowService.searchMoviesByYear(year);
		} else {
			Logger.log("Invalid year or no shows available in year");
		}

	}
}
