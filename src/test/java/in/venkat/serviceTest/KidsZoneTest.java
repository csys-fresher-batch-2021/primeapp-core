package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;

public class KidsZoneTest {

	public static void main(String[] args) {
		String userId = "venkat9790430272";
		String zone = "kids";

		switchToKidsZone(userId, zone);

	}

	private static void switchToKidsZone(String userId, String zone) {

		try {
			ShowService.switchToKidsZone(userId, zone);
		} catch (DbException | InvalidUserIdException | InvalidDetailsException e) {
			Logger.exception(e);
		}

	}

}
