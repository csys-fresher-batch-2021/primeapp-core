package in.venkat.searchServiceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.PlanNotExpiredException;
import in.venkat.service.PrimeTopupService;
import in.venkat.util.Logger;

public class TopupTest {

	public static void main(String[] args) {

		try {
			String userId = "venkat9790430272";
			int choice = 1;
			boolean isConfirm = true;
			PrimeTopupService.primeTopup(choice, isConfirm, userId);

		} catch (DbException | InvalidUserIdException | PlanNotExpiredException e) {
			Logger.exception(e);
		}

	}
}
