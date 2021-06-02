package in.venkat.test;

import java.sql.SQLException;

import in.venkat.service.ShowService;
import in.venkat.validator.validateSearchDetails;

public class SearchContentsTest {

	public static void main(String[] args) throws SQLException, Exception {

		boolean search = ShowService.searchContents("action", "english");
		System.out.println(search);
		String language = "tamil";
		boolean languageValid = validateSearchDetails.validateDetails(language);
		if (languageValid) {
			ShowService.printSearchMoviesByLanguage(language);
		} else {
			System.out.println("Invalid Language");
		}
		String membership = "prime";
		boolean membershipValid = validateSearchDetails.validateDetails(membership);
		if (membershipValid) {
			ShowService.printSearchMoviesByMembership(membership);
		} else {
			System.out.println("Invalid membership");
		}

		int year = 2019;

		if (year > 1950 && year <= 2021) {
			ShowService.searchByYear(year);
		} else {
			System.out.println("Invalid year");
		}
	}
}
