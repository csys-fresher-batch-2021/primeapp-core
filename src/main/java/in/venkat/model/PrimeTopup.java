package in.venkat.model;

import java.time.LocalDate;

public class PrimeTopup {
	private int topupId;
	private String userId;
	private double cost;
	private LocalDate rechargeDate;
	private int validity;
	private int screen;

	public PrimeTopup(String userId, double cost, LocalDate rechargeDate, int validity, int screen,
			LocalDate expiryDate) {
		super();
		this.userId = userId;
		this.cost = cost;
		this.rechargeDate = rechargeDate;
		this.validity = validity;
		this.screen = screen;
		this.expiryDate = expiryDate;
	}

	public int getTopupId() {
		return topupId;
	}

	public void setTopupId(int topupId) {
		this.topupId = topupId;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	private LocalDate expiryDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public LocalDate getRechargeDate() {
		return rechargeDate;
	}

	public void setRechargeDate(LocalDate rechargeDate) {
		this.rechargeDate = rechargeDate;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public PrimeTopup(String userId) {
		super();
		this.userId = userId;
	}

	public PrimeTopup(int topupId, String userId, int plan, LocalDate expiryDate, int screen) {
		super();
		this.topupId = topupId;
		this.userId = userId;
		this.cost =plan;
		this.expiryDate = expiryDate;
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "PrimeTopup [topupId=" + topupId + ", userId=" + userId + ", cost=" + cost + ", rechargeDate="
				+ rechargeDate + ", validity=" + validity + ", screen=" + screen + ", expiryDate=" + expiryDate + "]";
	}

}
