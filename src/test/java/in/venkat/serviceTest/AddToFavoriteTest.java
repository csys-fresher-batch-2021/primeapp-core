package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidMovieIdException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class AddToFavoriteTest {

	public static void main(String[] args) {
		String userId = "radha8767898790";
		int movieId = 63;
		addToFavoriteTest(userId, movieId);

	}

	private static void addToFavoriteTest(String userId, int movieId) {
		try {
			boolean isAdded = ShowService.addToFavorites(userId, movieId);

			if (isAdded) {
				Logger.log("succesfully added to favorite");
			}
		} catch (DbException | InvalidUserIdException | InvalidMovieIdException e) {
			Logger.exception(e);
		}
	}

}
