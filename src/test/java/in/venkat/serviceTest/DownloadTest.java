package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidMovieIdException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.MovieAlreadyExistsException;
import in.venkat.exceptions.PlanNotExpiredException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class DownloadTest {
	public static void main(String[] args) {
		String userId = "venkat9790430272";
		int movieId = 78;
		addToDownloads(userId, movieId);
	}

	private static void addToDownloads(String userId, int movieId) {
		try {
			ShowService.addToDownloads(userId, movieId);
			Logger.log("succesfully downloaded");
		} catch (DbException | InvalidUserIdException | InvalidMovieIdException | MovieAlreadyExistsException e) {
			Logger.exception(e);
		}
	}

}
