package in.venkat.model;

import java.time.LocalDate;

public class PrimeTopup {

	private String userId;
	private double cost;
	private LocalDate rechargeDate;
	private int validity;
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

	public PrimeTopup(String userId, double cost, LocalDate rechargeDate, int validity, LocalDate expiryDate) {
		super();
		this.userId = userId;
		this.cost = cost;
		this.rechargeDate = rechargeDate;
		this.validity = validity;
		this.expiryDate = expiryDate;
	}

	public PrimeTopup(String userId) {
		super();
		this.userId = userId;
	}

	public PrimeTopup(String userId, LocalDate expiryDate) {
		super();
		this.userId = userId;
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "PrimeTopup [userId=" + userId + ", cost=" + cost + ", rechargeDate=" + rechargeDate + ", validity="
				+ validity + ", expiryDate=" + expiryDate + "]";
	}

}
