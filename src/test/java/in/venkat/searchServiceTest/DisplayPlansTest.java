package in.venkat.searchServiceTest;

import in.venkat.exceptions.DbException;
import in.venkat.service.PlansService;
import in.venkat.util.Logger;

public class DisplayPlansTest {

	public static void main(String[] args) {
		try {
			PlansService.getPlans();
		} catch (DbException e) {
			Logger.exception(e);
		}
	}

}
