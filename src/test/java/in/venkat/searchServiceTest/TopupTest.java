package in.venkat.searchServiceTest;

import java.sql.SQLException;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidChoiceException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.PlanNotExpiredException;
import in.venkat.service.PrimeTopupService;
import in.venkat.util.Logger;

public class TopupTest {

	public static void main(String[] args) {

		try {
			String userId = "kumar8767898770";
			int choice = 2;
			PrimeTopupService.primeTopup(choice, userId);
		} catch (DbException | InvalidUserIdException | PlanNotExpiredException | SQLException
				| InvalidChoiceException e) {
			Logger.exception(e);
		}

	}
}
