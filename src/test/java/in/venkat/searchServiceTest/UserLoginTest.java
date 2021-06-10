package in.venkat.searchServiceTest;

import in.venkat.service.UserService;
import in.venkat.util.Logger;

public class UserLoginTest {

	public static void main(String[] args) {

		String userId = "9790430272";
		String userPassword = "Venkat@19";

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
