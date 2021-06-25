package in.venkat.serviceTest;

import java.util.List;

import in.venkat.exceptions.DbException;
import in.venkat.model.Show;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class TrendingMoviesTest {
	public static void main(String[] args) {
		try {
			List<Show> trendingMovie = ShowService.getTrendingMovies();
			Logger.log(trendingMovie);
		} catch (DbException e) {
			Logger.exception(e);
		}
	}
}
