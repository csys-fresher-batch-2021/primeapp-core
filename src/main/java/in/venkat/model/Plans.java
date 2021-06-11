package in.venkat.model;

public class Plans {
	private int id;
	private int primePlans;
	private String liveShows;
	private String multiplexScreens;
	private String dubbedMovies;
	private String advertisement;
	private int movieScreens;
	private String videoQuality;
	private String audioQuality;

	public Plans(int id, int plans, String liveShows, String multiplexScreens, String dubbed, String advertisement,
			int screens, String videoQuality, String audioQuality) {
		super();
		this.id = id;
		this.primePlans = plans;
		this.liveShows = liveShows;
		this.multiplexScreens = multiplexScreens;
		dubbedMovies = dubbed;
		this.advertisement = advertisement;
		movieScreens = screens;
		this.videoQuality = videoQuality;
		this.audioQuality = audioQuality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlans() {
		return primePlans;
	}

	public void setPlans(int plans) {
		this.primePlans = plans;
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

	public String getDubbed() {
		return dubbedMovies;
	}

	public void setDubbed(String dubbed) {
		dubbedMovies = dubbed;
	}

	public String getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	public int getScreens() {
		return movieScreens;
	}

	public void setScreens(int screens) {
		movieScreens = screens;
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

	@Override
	public String toString() {
		return "PrimePlans [id=" + id + ", plans=" + primePlans + ", liveShows=" + liveShows + ", multiplexScreens="
				+ multiplexScreens + ", Dubbed=" + dubbedMovies + ", advertisement=" + advertisement + ", Screens=" + movieScreens
				+ ", videoQuality=" + videoQuality + ", audioQuality=" + audioQuality + "]";
	}

}
