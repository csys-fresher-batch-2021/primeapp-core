package in.venkat.validator;

import java.time.LocalDate;

import in.venkat.exceptions.MovieAlreadyExistsException;

public class DownloadValidator {
	/**
	 * This method is used to check whether the movie is expired or not
	 * 
	 * @param expiryDate
	 * @return
	 * @throws MovieAlreadyExistsException
	 */
	public static boolean isDownloadedMoviesExpired(LocalDate expiryDate) throws MovieAlreadyExistsException {
		boolean valid = false;
		if (LocalDate.now().isAfter(expiryDate)) {
			valid = true;
		} else {
			throw new MovieAlreadyExistsException("movie already added or not expired");
		}
		return valid;
	}

}
