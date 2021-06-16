package in.venkat.model;

public class Plans {
	private int planId;
	private int primePlans;
	private int planValidity;
	private String liveShows;
	private String multiplexScreens;
	private String dubbedMovies;
	private String advertisement;
	private int movieScreens;
	private String videoQuality;
	private String audioQuality;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int id) {
		this.planId = id;
	}

	public int getPrimePlans() {
		return primePlans;
	}

	public void setPrimePlans(int primePlans) {
		this.primePlans = primePlans;
	}

	public int getPlanValidity() {
		return planValidity;
	}

	public void setPlanValidity(int planValidity) {
		this.planValidity = planValidity;
	}

	public String getLiveShows() {
		return liveShows;
	}

	public void setLiveShows(String liveShows) {
		this.liveShows = liveShows;
	}

	public String getMultiplexScreens() {
		return multiplexScreens;
	}

	public void setMultiplexScreens(String multiplexScreens) {
		this.multiplexScreens = multiplexScreens;
	}

	public String getDubbedMovies() {
		return dubbedMovies;
	}

	public void setDubbedMovies(String dubbedMovies) {
		this.dubbedMovies = dubbedMovies;
	}

	public String getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	public int getMovieScreens() {
		return movieScreens;
	}

	public void setMovieScreens(int movieScreens) {
		this.movieScreens = movieScreens;
	}

	public String getVideoQuality() {
		return videoQuality;
	}

	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}

	public String getAudioQuality() {
		return audioQuality;
	}

	public void setAudioQuality(String audioQuality) {
		this.audioQuality = audioQuality;
	}

	public Plans(int id, int primePlans, int planValidity, String liveShows, String multiplexScreens,
			String dubbedMovies, String advertisement, int movieScreens, String videoQuality, String audioQuality) {
		super();
		this.planId = id;
		this.primePlans = primePlans;
		this.planValidity = planValidity;
		this.liveShows = liveShows;
		this.multiplexScreens = multiplexScreens;
		this.dubbedMovies = dubbedMovies;
		this.advertisement = advertisement;
		this.movieScreens = movieScreens;
		this.videoQuality = videoQuality;
		this.audioQuality = audioQuality;
	}

	@Override
	public String toString() {
		return "Plans [planId=" + planId + ", primePlans=" + primePlans + ", planValidity=" + planValidity
				+ ", liveShows=" + liveShows + ", multiplexScreens=" + multiplexScreens + ", dubbedMovies="
				+ dubbedMovies + ", advertisement=" + advertisement + ", movieScreens=" + movieScreens
				+ ", videoQuality=" + videoQuality + ", audioQuality=" + audioQuality + "]";
	}

}
