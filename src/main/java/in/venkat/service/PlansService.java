package in.venkat.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import in.venkat.dao.PlansDao;
import in.venkat.dao.PrimeTopupDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.model.Plans;
import in.venkat.model.PrimeTopup;
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

	/**
	 * This method is used to get the plan expire date of the user by user id
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 * @throws InvalidUserIdException
	 */
	public static LocalDate getExpiryDateById(String userId) throws DbException, InvalidUserIdException {
		LocalDate expiryDate = null;
		List<PrimeTopup> topupDetails = PrimeTopupDao.getExpiryDate();
		boolean validUser = false;
		for (PrimeTopup topup : topupDetails) {
			if (topup.getUserId().equals(userId)) {
				expiryDate = topup.getExpiryDate();
				validUser = true;
			}
		}
		if (!validUser) {
			throw new InvalidUserIdException("User Id does not exists");
		}
		return expiryDate;

	}

	/**
	 * This method is used to calculate the validity of the user's plan and display
	 * the validity in days
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 * @throws InvalidUserIdException
	 */
	public static int getValidDays(String userId) throws DbException, InvalidUserIdException {
		int validity = 0;
		LocalDate now = LocalDate.now();
		LocalDate expire = getExpiryDateById(userId);
		validity = (int) ChronoUnit.DAYS.between(now, expire);
		System.out.println(validity);
		return validity;

	}

}
