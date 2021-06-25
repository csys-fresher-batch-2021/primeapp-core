package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidMovieIdException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class UpdatePrimeStatusTest {

	public static void main(String[] args) {
		int movieId = 70;

		primeStatusUpdate(movieId);

	}

	private static void primeStatusUpdate(int movieId) {
		try {
			boolean updated = ShowService.primeStatusUpdate(movieId);
			if (updated) {
				Logger.log("succesfully updated");

			}
		} catch (DbException | InvalidMovieIdException | NullPointerException e) {
			Logger.exception(e);
		}

	}

}
