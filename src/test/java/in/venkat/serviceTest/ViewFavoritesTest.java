package in.venkat.serviceTest;

import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.model.Show;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class ViewFavoritesTest {

	public static void main(String[] args) {
		String userId = "venkat9790430272";

		viewFavoriteMovies(userId);

	}

	private static void viewFavoriteMovies(String userId) {

		try {
			List<Show> favorites = ShowService.viewFavoriteMovies(userId);
			Logger.log(favorites);

		} catch (DbException | InvalidUserIdException e) {
			Logger.exception(e);
		}

	}

}
