package in.venkat.model;

public class Show {

	private String id;
	private String movieGenre;
	private String movieName;
	private int movieYear;
	private String movieLanguage;
	private String movieCategory;
	private String membership;
	private String movieGrade;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieCategory() {
		return movieCategory;
	}

	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getMovieGrade() {
		return movieGrade;
	}

	public void setMovieGrade(String movieGrade) {
		this.movieGrade = movieGrade;
	}

	public Show(String id, String movieGenre, String movieName, int movieYear, String movieLanguage,
			String movieCategory, String membership, String movieGrade) {
		super();
		this.id = id;
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.movieLanguage = movieLanguage;
		this.movieCategory = movieCategory;
		this.membership = membership;
		this.movieGrade = movieGrade;
	}

	@Override
	public String toString() {
		return "PrimeMoviesCategory [id=" + id + ", movieGenre=" + movieGenre + ", movieName=" + movieName
				+ ", movieYear=" + movieYear + ", movieLanguage=" + movieLanguage + ", movieCategory=" + movieCategory
				+ ", membership=" + membership + ", movieGrade=" + movieGrade + "]";
	}

}
