package in.venkat.model;

public class Show {
	private String userId;
	private int id;
	private String movieGenre;
	private String movieName;
	private int movieYear;
	private String movieLanguage;
	private String movieCategory;
	private String membership;
	private String movieGrade;
	private String status;
	private int likes;

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Show(int movieId, String movieGenre, String movieName, int movieYear, String movieLanguage,
			String movieCategory, String membership, String movieGrade, String status) {
		super();
		this.id = movieId;
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.movieLanguage = movieLanguage;
		this.movieCategory = movieCategory;
		this.membership = membership;
		this.movieGrade = movieGrade;
		this.status = status;

	}

	public Show(int movieId, String movieGenre, String movieName, int movieYear, String movieLanguage,
			String movieCategory, String membership, String movieGrade, String movieStatus, int movieLikes) {
		super();
		this.id = movieId;
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.movieLanguage = movieLanguage;
		this.movieCategory = movieCategory;
		this.membership = membership;
		this.movieGrade = movieGrade;
		this.status = movieStatus;
		this.likes = movieLikes;
	}

	public Show(String userId, int id, String movieGenre, String movieName, int movieYear, String movieLanguage,
			String movieCategory, String membership, String movieGrade, String status) {
		super();
		this.userId = userId;
		this.id = id;
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.movieLanguage = movieLanguage;
		this.movieCategory = movieCategory;
		this.membership = membership;
		this.movieGrade = movieGrade;
		this.status = status;
	}

	public Show(String genre, String name, int year, String language, String category, String membership, String grade,
			String status, int likes) {
		this.movieGenre = genre;
		this.movieName = name;
		this.movieYear = year;
		this.movieLanguage = language;
		this.movieCategory = category;
		this.membership = membership;
		this.movieGrade = grade;
		this.status = status;
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", movieGenre=" + movieGenre + ", movieName=" + movieName + ", movieYear=" + movieYear
				+ ", movieLanguage=" + movieLanguage + ", movieCategory=" + movieCategory + ", membership=" + membership
				+ ", movieGrade=" + movieGrade + ", status=" + status + "]";
	}

}
