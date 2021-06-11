package in.venkat.model;

public class Plans {
	private int id;
	private int plans;
	private String liveShows;
	private String multiplexScreens;
	private String Dubbed;
	private String advertisement;
	private int Screens;
	private String videoQuality;
	private String audioQuality;

	public Plans(int id, int plans, String liveShows, String multiplexScreens, String dubbed, String advertisement,
			int screens, String videoQuality, String audioQuality) {
		super();
		this.id = id;
		this.plans = plans;
		this.liveShows = liveShows;
		this.multiplexScreens = multiplexScreens;
		Dubbed = dubbed;
		this.advertisement = advertisement;
		Screens = screens;
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
		return plans;
	}

	public void setPlans(int plans) {
		this.plans = plans;
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
		return Dubbed;
	}

	public void setDubbed(String dubbed) {
		Dubbed = dubbed;
	}

	public String getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	public int getScreens() {
		return Screens;
	}

	public void setScreens(int screens) {
		Screens = screens;
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
		return "PrimePlans [id=" + id + ", plans=" + plans + ", liveShows=" + liveShows + ", multiplexScreens="
				+ multiplexScreens + ", Dubbed=" + Dubbed + ", advertisement=" + advertisement + ", Screens=" + Screens
				+ ", videoQuality=" + videoQuality + ", audioQuality=" + audioQuality + "]";
	}

}
