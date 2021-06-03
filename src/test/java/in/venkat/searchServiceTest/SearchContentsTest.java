package in.venkat.searchServiceTest;

import java.sql.SQLException;

import in.venkat.service.ShowService;
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
			System.out.println("Category does not exists");
		}

		/**
		 * Searching movies by Genre and Language
		 */
		boolean search = ShowService.searchContents("action", "english");
		System.out.println(search);
		/**
		 * Searching movies by Language
		 */
		String language = "tamil";
		boolean languageValid = ValidateSearchDetails.validateDetails(language);
		if (languageValid) {
			ShowService.searchMoviesByLanguage(language);
		} else {
			System.out.println("Invalid Language");
		}
		/**
		 * Searching movies by membership
		 */
		String membership = "prime";
		boolean membershipValid = ValidateSearchDetails.validateDetails(membership);
		if (membershipValid) {
			ShowService.searchMoviesByMembership(membership);
		} else {
			System.out.println("Invalid membership");
		}
		/**
		 * Searching movies by year
		 */
		int year = 2019;
		if (year > 1950 && year <= 2021) {
			ShowService.searchMoviesByYear(year);
		} else {
			System.out.println("Invalid year");
		}

		
	}
}
