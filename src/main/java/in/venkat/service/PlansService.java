package in.venkat.service;

import java.util.List;

import in.venkat.dao.PlansDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.model.Plans;
import in.venkat.util.Logger;
import in.venkat.validator.ValidateUserDetails;

public class PlansService {
	private PlansService() {
		/**
		 * Adding private constructor
		 */
	}

	/**
	 * This method is used to display the plan details
	 * 
	 * @return
	 * @throws DbException
	 */
	public static List<Plans> getPlans() throws DbException {
		List<Plans> plans = PlansDao.getPrimePlans();
		Logger.log(plans);
		return plans;

	}

	/**
	 * This method is used to check the userId and then displays the plan
	 * 
	 * @param userId
	 * @throws DbException
	 * @throws InvalidUserIdException
	 */
	public static void displayPlans(String userId) throws DbException, InvalidUserIdException {

		boolean isExists = ValidateUserDetails.checkUserId(userId);
		if (isExists) {
			getPlans();

		} else {
			throw new InvalidUserIdException("User Id not found");
		}

	}

}
