package in.venkat.searchServiceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.exceptions.MovieAlreadyExistsException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class AddMoviesTest {

	public static void main(String[] args) {
		String genre = "action";
		String name = "ted";
		int year = 2016;
		String language = "english";
		String category = "movie";
		String membership = "prime";
		String grade = "A";
		String status = "inactive";

		addMovies(genre, name, year, language, category, membership, grade, status);
	}

	private static void addMovies(String genre, String name, int year, String language, String category,
			String membership, String grade, String status) {
		try {
			boolean added = ShowService.addShows(genre, name, year, language, category, membership, grade, status);
			if (added) {
				Logger.log("succesfully added");
			}
		} catch (EmptyFieldException | InvalidNameException | InvalidDetailsException | DbException
				| MovieAlreadyExistsException e) {
			Logger.exception(e);
		}

	}

}
