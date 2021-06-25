package in.venkat.serviceTest;

import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyListException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.model.Show;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class ViewFavoritesTest {

	public static void main(String[] args) {
		String userId = "ragul7092621076";

		viewFavoriteMovies(userId);

	}

	private static void viewFavoriteMovies(String userId) {

		try {
			List<Show> favorites = ShowService.viewFavoriteMovies(userId);
			if (!favorites.isEmpty()) {
				Logger.log(favorites);
			} else {
				throw new EmptyListException(" you didn't add any movies in favorites");
			}

		} catch (DbException | InvalidUserIdException | EmptyListException e) {
			Logger.exception(e);
		}

	}

}
