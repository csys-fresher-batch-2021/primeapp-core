package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidPlanException;
import in.venkat.service.PrimeTopupService;
import in.venkat.util.Logger;

public class PrimeUserLogoutTest {

	public static void main(String[] args) {
		try {
			String userId = "venkat8767898760";
			PrimeTopupService.logoutService(userId);
		} catch (DbException | InvalidPlanException e) {
			Logger.exception(e);
		}
	}

}
