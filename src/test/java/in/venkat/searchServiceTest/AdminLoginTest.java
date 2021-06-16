package in.venkat.searchServiceTest;

import in.venkat.exceptions.AdminNamePasswordMismatchException;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.exceptions.InvalidPasswordException;
import in.venkat.service.AdminService;
import in.venkat.util.Logger;

public class AdminLoginTest {

	public static void main(String[] args) {

		String adminName = "venkatesh";
		String password = "Venkat@19";
		adminLoginTest(adminName, password);
	}

	private static void adminLoginTest(String adminName, String password) {

		try {
			if (AdminService.adminLogin(adminName, password)) {
				Logger.log("succesfully LoggedIn");
			} else {
				Logger.log("invalid credentials");
			}
		} catch (DbException | AdminNamePasswordMismatchException | InvalidNameException | EmptyFieldException
				| InvalidPasswordException e) {
			Logger.exception(e);
		}

	}

}
