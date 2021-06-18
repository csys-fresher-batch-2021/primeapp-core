package in.venkat.searchServiceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidMovieIdException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class DeleteMoviesTest {

	public static void main(String[] args) {
		int movieId = 65;

		deleteMoviesTest(movieId);
	}

	private static void deleteMoviesTest(int movieId) {
		try {
			boolean isDeleted = ShowService.deleteMovie(movieId);
			if (isDeleted) {
				Logger.log("succesfully deleted");
			}
		} catch (DbException | InvalidMovieIdException | EmptyFieldException e) {
			Logger.exception(e);
		}

	}

}
