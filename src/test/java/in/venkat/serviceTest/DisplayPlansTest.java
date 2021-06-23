package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.service.PlansService;
import in.venkat.util.Logger;

public class DisplayPlansTest {

	public static void main(String[] args) {

		try {
			String userId = "venkat9790430272";
			PlansService.displayPlans(userId);
		} catch (DbException | InvalidUserIdException e) {
			Logger.exception(e);
		}

	}
}
