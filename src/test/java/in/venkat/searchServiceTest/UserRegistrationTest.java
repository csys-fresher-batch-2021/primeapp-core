package in.venkat.searchServiceTest;

import in.venkat.service.UserRegistrationService;
import in.venkat.util.Logger;

public class UserRegistrationTest {

	public static void main(String[] args) {
		String name = "radha";
		long phoneNumber = 8767898790L;
		/**
		 * password must contain at least one upper case letter ,one lower case
		 * letter,one number and one special character
		 */
		String userPasscode = "Ragul@19";
		String reEnteredPasscode = "Ragul@19";

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
