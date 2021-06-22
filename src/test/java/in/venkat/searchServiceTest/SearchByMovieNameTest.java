package in.venkat.searchServiceTest;

import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.model.Show;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class SearchByMovieNameTest {

	public static void main(String[] args) {

		String movieName = "d";
		findByMovieName(movieName);
	}

	public static void findByMovieName(String movieName) {
		List<Show> movieList;
		try {
			movieList = ShowService.searchByMovieName(movieName);
			if (!movieList.isEmpty()) {
				Logger.log(movieList);
			} else {
				throw new EmptyFieldException("no movies with this name");
			}

		} catch (DbException | EmptyFieldException | InvalidNameException e) {
			Logger.exception(e);
		}

	}
}
