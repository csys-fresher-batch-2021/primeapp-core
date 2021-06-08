package in.venkat.searchServiceTest;

import in.venkat.service.UserRegistrationService;
import in.venkat.util.Logger;

public class UserRegistrationTest {

	public static void main(String[] args) {
		String name = "ronaldo";
		long phoneNumber = 9600900509L;
		/**
		 * password must contain at least one upper case letter ,one lower case
		 * letter,one number and one special character
		 */
		String userPasscode = "Ronaldo@19";
		String reEnteredPasscode = "Ronaldo@19";

		userRegistrationTest(name, phoneNumber, userPasscode, reEnteredPasscode);

	}

	public static void userRegistrationTest(String name, long mobileNumber, String userPasscode,
			String reEnteredPasscode) {
		try {
			UserRegistrationService.registerUser(name, mobileNumber, userPasscode, reEnteredPasscode);

		} catch (Exception e) {
			Logger.exception(e);
		}
	}

}
