package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.service.PlansService;
import in.venkat.util.Logger;

public class ValidityTest {

	public static void main(String[] args) {
		String userId = "venkat9790430272";

		displayPlanValidity(userId);
	}

	public static void displayPlanValidity(String userId) {
		try {

			PlansService.getValidDays(userId);

		} catch (DbException | InvalidUserIdException e) {
			Logger.exception(e);
		}

	}

}
