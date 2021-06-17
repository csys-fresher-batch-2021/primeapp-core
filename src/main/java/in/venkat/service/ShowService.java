package in.venkat.service;

import java.util.ArrayList;
import java.util.List;

import in.venkat.dao.ShowListDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.exceptions.MovieAlreadyExistsException;
import in.venkat.model.Show;
import in.venkat.util.Logger;
import in.venkat.util.NameValidationUtil;
import in.venkat.util.ShowDetailsValidationUtil;
import in.venkat.validator.ValidateSearchDetails;

public class ShowService {
	private ShowService() {
		/**
		 * Adding private constructor
		 */
	}

	/**
	 * This method is used to search movies by giving genre and language
	 * 
	 * @param filmGenre
	 * @param filmLanguage
	 * @return
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 * @throws DbException
	 */
	public static List<Show> searchContents(String filmGenre, String filmLanguage)
			throws EmptyFieldException, InvalidNameException, InvalidDetailsException, DbException {
		boolean isValid;
		List<Show> search = null;

		isValid = ValidateSearchDetails.validateDetails(filmGenre, filmLanguage);
		if (isValid) {
			search = searchMoviesByLanguageAndGenre(filmGenre, filmLanguage);
		}

		return search;
	}

	public static List<Show> searchMoviesByLanguageAndGenre(String filmGenre, String filmLanguage) throws DbException {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		primeMovieList = ShowListDao.getShowDetails();
		for (Show show : primeMovieList) {
			if (show.getMovieGenre().equalsIgnoreCase(filmGenre.trim())
					&& show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim()))
				filteredMovieList.add(show);
		}

		return filteredMovieList;

	}

	/**
	 * This method is used to search movies by membership
	 * 
	 * @param membership
	 * @return
	 * @throws DbException
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 * 
	 */
	public static List<Show> searchMoviesByMembership(String membership)
			throws DbException, EmptyFieldException, InvalidNameException, InvalidDetailsException {
		ValidateSearchDetails.validateDetails(membership);
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		primeMovieList = ShowListDao.getShowDetails();
		for (Show show : primeMovieList) {
			if (show.getMembership().equalsIgnoreCase(membership.trim())) {
				filteredMovieList.add(show);
				Logger.log(show);
			}
		}

		return filteredMovieList;

	}

	/**
	 * This method is used to search movies by the released year
	 * 
	 * @param year
	 * @return
	 * @throws DbException
	 */
	public static List<Show> searchMoviesByYear(int year) throws DbException {
		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();
		if (year > 1950 && year <= 2021) {
			primeMovieList = ShowListDao.getShowDetails();
			for (Show show : primeMovieList) {
				if (show.getMovieYear() == year) {
					filteredMovieList.add(show);
					Logger.log(show);
				}

			}
		}
		return filteredMovieList;
	}

	/**
	 * This method is used to search movies by language
	 * 
	 * @param filmLanguage
	 * @return
	 * @throws DbException
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 */
	public static List<Show> searchMoviesByLanguage(String filmLanguage)
			throws DbException, EmptyFieldException, InvalidNameException, InvalidDetailsException {
		ValidateSearchDetails.validateDetails(filmLanguage);

		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();

		primeMovieList = ShowListDao.getShowDetails();
		for (Show show : primeMovieList) {
			if (show.getMovieLanguage().equalsIgnoreCase(filmLanguage.trim())) {
				filteredMovieList.add(show);
				Logger.log(show);

			}
		}
		return filteredMovieList;

	}

	/**
	 * This method is used to display all movies
	 * 
	 * @param filmCategory
	 * @return
	 * @throws DbException
	 * @throws InvalidDetailsException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 */
	public static List<Show> displayAllMovies(String filmCategory)
			throws DbException, EmptyFieldException, InvalidNameException, InvalidDetailsException {
		ValidateSearchDetails.validateDetails(filmCategory);

		List<Show> primeMovieList;
		List<Show> filteredMovieList = new ArrayList<>();

		primeMovieList = ShowListDao.getShowDetails();
		for (Show show : primeMovieList) {
			if (show.getMovieCategory().equalsIgnoreCase(filmCategory.trim())) {
				filteredMovieList.add(show);
				Logger.log(show);
			}
		}

		return filteredMovieList;
	}

	/**
	 * This method is used to add movies or shows
	 * 
	 * @param genre
	 * @param name
	 * @param year
	 * @param language
	 * @param category
	 * @param membership
	 * @param grade
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidNameException
	 * @throws InvalidDetailsException
	 * @throws DbException
	 * @throws MovieAlreadyExistsException
	 */
	public static boolean addShows(String genre, String name, int year, String language, String category,
			String membership, String grade, String status) throws EmptyFieldException, InvalidNameException,
			InvalidDetailsException, DbException, MovieAlreadyExistsException {
		boolean added = false;
		boolean genreValid = NameValidationUtil.validateName(genre);
		boolean nameValid = NameValidationUtil.validateName(name);
		boolean yearValid = ShowDetailsValidationUtil.isYearValid(year);
		boolean languagevalid = NameValidationUtil.validateName(language);
		boolean categoryValid = NameValidationUtil.validateName(category);
		boolean memberShipValid = ShowDetailsValidationUtil.validateMembership(membership);
		boolean gradeValid = ShowDetailsValidationUtil.gradeValidation(grade);
		boolean statusValid = ShowDetailsValidationUtil.statusValidation(status);
		boolean isMoviePresent = isMoviePresent(name, year, language);
		if (genreValid && nameValid && yearValid && languagevalid && categoryValid && memberShipValid && gradeValid
				&& statusValid && !isMoviePresent) {
			Show show = new Show(genre, name, year, language, category, membership, grade, status);
			ShowListDao.addMovies(show);
			added = true;
		} else {
			throw new MovieAlreadyExistsException("movie already exists");
		}

		return added;

	}

	/**
	 * This method checks whether the movie is already present
	 */
	public static boolean isMoviePresent(String name, int year, String language) throws DbException {
		boolean present = false;
		List<Show> showDetails = ShowListDao.getShowDetails();
		for (Show show : showDetails) {
			if (show.getMovieName().equals(name) && show.getMovieYear() == year
					&& show.getMovieLanguage().equalsIgnoreCase(language.trim())) {

				present = true;

			}
		}

		return present;

	}

	/**
	 * This method delete the movie from shows
	 * 
	 * @param movieName
	 * @param year
	 * @param language
	 * @return
	 * @throws EmptyFieldException
	 * @throws InvalidNameException
	 * @throws InvalidDetailsException
	 * @throws DbException
	 */
	public static boolean deleteMovie(String movieName, int year, String language)
			throws EmptyFieldException, InvalidNameException, InvalidDetailsException, DbException {
		boolean deleted = false;
		boolean nameValid = NameValidationUtil.validateName(movieName);
		boolean yearValid = ShowDetailsValidationUtil.isYearValid(year);
		boolean languageValid = NameValidationUtil.validateName(language);

		if (nameValid && yearValid && languageValid) {
			deleted = ShowListDao.deleteMovies(movieName, year, language);

		}
		return deleted;
	}

}
