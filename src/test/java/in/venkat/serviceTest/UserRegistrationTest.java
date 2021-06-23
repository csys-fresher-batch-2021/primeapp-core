package in.venkat.serviceTest;

import in.venkat.service.UserService;
import in.venkat.util.Logger;

public class UserRegistrationTest {

	public static void main(String[] args) {
		String name = "venkatesh";
		long phoneNumber = 7092621018L;
		/**
		 * password must contain at least one upper case letter ,one lower case
		 * letter,one number and one special character
		 */
		String userPasscode = "Venkatesh#1";
		String reEnteredPasscode = "Venkatesh#1";

		userRegistrationTest(name, phoneNumber, userPasscode, reEnteredPasscode);
	}

	public static void userRegistrationTest(String name, long mobileNumber, String userPasscode,
			String reEnteredPasscode) {
		try {
			UserService.registerUser(name, mobileNumber, userPasscode, reEnteredPasscode);

		} catch (Exception e) {
			Logger.exception(e);
		}
	}

}
