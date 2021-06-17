package in.venkat.searchServiceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class DeleteMoviesTest {

	public static void main(String[] args) {
		String movieName = "sivaji";
		int year = 2012;
		String language = "tamil";

		deleteMoviesTest(movieName, year, language);
	}

	private static void deleteMoviesTest(String movieName, int year, String language) {
		try {
			boolean isDeleted = ShowService.deleteMovie(movieName, year, language);
			if (isDeleted) {
				Logger.log("succesfully deleted");
			}
		} catch (EmptyFieldException | InvalidNameException | InvalidDetailsException | DbException e) {
			Logger.log("failed to delete");
			Logger.exception(e);
		}

	}

}
