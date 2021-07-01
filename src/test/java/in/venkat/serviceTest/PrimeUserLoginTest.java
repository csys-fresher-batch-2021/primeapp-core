package in.venkat.serviceTest;

import in.venkat.service.PrimeTopupService;
import in.venkat.util.Logger;

public class PrimeUserLoginTest {

	public static void main(String[] args) {
		try {
			String userId = "venkat8767898760";
			PrimeTopupService.loginService(userId);
		} catch (Exception E) {
			Logger.exception(E);
		}
	}
}
