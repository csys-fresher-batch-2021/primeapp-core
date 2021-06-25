package in.venkat.serviceTest;

import in.venkat.service.UserService;
import in.venkat.util.Logger;

public class UserLoginTest {

	public static void main(String[] args) {

		String userId = "ragul7092621076";
		String userPassword = "Venkatesh#1";

		userLoginTest(userId, userPassword);

	}

	private static void userLoginTest(String userId, String userPassword) {
		try {
			if (UserService.validateUserLogin(userId, userPassword)) {
				Logger.log("succesfully LoggedIn");
			} else {
				Logger.log("invalid credentials");
			}

		} catch (Exception e) {
			Logger.exception(e);
		}

	}
}
