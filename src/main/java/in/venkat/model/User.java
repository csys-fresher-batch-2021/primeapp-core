package in.venkat.model;

public class User {
	private String userId;
	private String userName;
	private long phoneNumber;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String userId, String userName, long phoneNumber, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public User(String userId, String userPassword) {
		super();
		this.userId = userId;
		this.password = userPassword;
	}

	public User(long phoneNumber, String userPassword) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = userPassword;
	}

	@Override
	public String toString() {
		return "UserRegistration [userId=" + userId + ", userName=" + userName + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + "]";
	}

}