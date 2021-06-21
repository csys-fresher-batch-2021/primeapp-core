package in.venkat.searchServiceTest;

import java.util.ArrayList;
import java.util.List;
import in.venkat.dao.ShowListDao;
import in.venkat.exceptions.DbException;
import in.venkat.model.Show;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class TrendingMoviesTest {
	public static void main(String[] args) {
		try {
			List<Show> trendingMovie = ShowListDao.getTrendingMovies();
			trendingMoviesTest(trendingMovie);

		} catch (DbException e) {
			Logger.exception(e);
		}

	}

	public static void trendingMoviesTest(List<Show> trendingMovie) {
		List<Show> trendingMovies = new ArrayList<>();
		try {
			for (Show trending : trendingMovie) {
				trendingMovies = ShowService.getTrendingMovies(trending.getId());
				Logger.log(trendingMovies);

			}

		} catch (DbException e) {
			Logger.exception(e);
		}

	}
}
