package in.venkat.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import in.venkat.dao.PlansDao;
import in.venkat.dao.PrimeTopupDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidChoiceException;
import in.venkat.exceptions.InvalidPlanException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.LoginLimitReachedException;
import in.venkat.exceptions.PlanNotExpiredException;
import in.venkat.model.Plans;
import in.venkat.model.PrimeTopup;
import in.venkat.util.Logger;
import in.venkat.validator.TopupValidation;
import in.venkat.validator.ValidateUserDetails;

public class PrimeTopupService {
	private PrimeTopupService() {
		/**
		 * Adding a private constructor
		 */
	}

	/**
	 * This method is used to calculate the plan details
	 * 
	 * @param choice
	 * @param isConfirm
	 * @param userId
	 * @throws DbException
	 * @throws InvalidUserIdException
	 * @throws PlanNotExpiredException
	 * @throws InvalidChoiceException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void primeTopup(int choice, String userId)
			throws DbException, PlanNotExpiredException, InvalidUserIdException, SQLException, InvalidChoiceException {
		boolean validTopup = PrimeTopupService.checkValidTopup(userId);
		boolean validUserId = ValidateUserDetails.checkUserId(userId);
		boolean isChoiceValid = TopupValidation.choiceValidation(choice);
		int id = getValidId(userId);
		List<Plans> plans = PlansDao.getPrimePlans();
		int plan = 0;
		int validity = 0;
		int screen = 0;
		for (Plans primePlans : plans) {
			if (choice == primePlans.getPlanId() && validTopup && validUserId && isChoiceValid && id == 0) {
				plan = primePlans.getPrimePlans();
				validity = primePlans.getPlanValidity();
				screen = primePlans.getMovieScreens();
				LocalDate today = LocalDate.now();
				LocalDate expiryDate = today.plusDays(validity);
				PrimeTopup primePlan = new PrimeTopup(userId, plan, today, validity, screen, expiryDate);
				PrimeTopupDao.saveTopupDetails(primePlan);
			}
		}
	}

	/**
	 * This method is used to check the expire date of the user and identify whether
	 * the plan expire or not
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 * @throws PlanNotExpiredException
	 */
	public static boolean checkValidTopup(String userId) throws DbException, PlanNotExpiredException {
		boolean checkNewTopup = isNewTopup(userId);
		boolean isValid = false;
		if (checkNewTopup) {
			LocalDate expiryDateCheck = getExpiryDate(userId);
			isValid = TopupValidation.isDateValid(expiryDateCheck);

		} else {
			isValid = true;
		}

		return isValid;
	}

	/**
	 * This method is used to get the expire date of user
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static LocalDate getExpiryDate(String userId) throws DbException {
		LocalDate expiryDate = null;
		List<PrimeTopup> topupExpiryDate = PrimeTopupDao.getTopupDetails();
		for (PrimeTopup expiryCheck : topupExpiryDate) {
			if (expiryCheck.getUserId().equals(userId)) {
				expiryDate = expiryCheck.getExpiryDate();
				break;
			}
		}
		return expiryDate;
	}

	/**
	 * This method checks whether the old plan exists
	 * 
	 * @param UserId
	 * @return
	 * @throws DbException
	 */
	public static boolean isNewTopup(String userId) throws DbException {
		boolean checkUser = false;
		List<PrimeTopup> newTopup = PrimeTopupDao.getTopupDetails();
		for (PrimeTopup userIdCheck : newTopup) {
			if (userIdCheck.getUserId().equals(userId)) {
				checkUser = true;
			}
		}
		return checkUser;
	}

	/**
	 * This method is for login when a new sign in occurs it will reduce the screen
	 * count .
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 * @throws LoginLimitReachedException
	 */
	public static boolean loginService(String userId) throws DbException, LoginLimitReachedException {
		boolean valid = false;
		int id = getValidId(userId);
		int count = 0;
		if (id > 0) {
			double planCost = getPlanById(id);
			count = getScreenCount(id);
			if (planCost == 399 && count == 1) {
				count--;
				PrimeTopupDao.updateScreenStatus(id, count);
			} else if (planCost == 699 && count > 0 && count <= 2) {
				count--;
				PrimeTopupDao.updateScreenStatus(id, count);
			} else {
				throw new LoginLimitReachedException("Your id has reached maximum no of screens");
			}
		}
		return valid;
	}

	/**
	 * This method is used when any user logged out it will increase the screen
	 * count
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 * @throws InvalidPlanException
	 */
	public static boolean logoutService(String userId) throws DbException, InvalidPlanException {
		boolean valid = false;
		int id = getValidId(userId);
		Logger.log(id);
		int count = 0;
		if (id > 0) {
			double planCost = getPlanById(id);
			count = getScreenCount(id);
			Logger.log(count);
			if (planCost == 399 && count == 0) {
				count++;
				Logger.log(count);
				PrimeTopupDao.updateScreenStatus(id, count);
			} else if (planCost == 699 && count >= 0 && count < 2) {
				count++;
				Logger.log(count);
				PrimeTopupDao.updateScreenStatus(id, count);
			}
		} else {
			throw new InvalidPlanException("there is no active plan recharge your account");
		}
		return valid;
	}

	/**
	 * This method is used to get the valid id whether it has active plans or not
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static int getValidId(String userId) throws DbException {
		int id = 0;
		boolean validDate = false;
		List<PrimeTopup> topup = PrimeTopupDao.getTopupDetails();
		for (PrimeTopup userTopup : topup) {
			if (userTopup.getUserId().equals(userId)) {
				validDate = TopupValidation.isValidExpirydate(userTopup.getExpiryDate());
				if (!validDate) {
					id = userTopup.getTopupId();
					break;
				}
			}
		}
		return id;
	}

	/**
	 * This method is used to get the screen count from the user
	 * 
	 * @param id
	 * @return
	 * @throws DbException
	 */
	public static int getScreenCount(int id) throws DbException {
		int count = 0;
		List<PrimeTopup> countScreen = PrimeTopupDao.getTopupDetails();
		for (PrimeTopup plan : countScreen) {
			if (plan.getTopupId() == id) {
				count = plan.getScreen();
			}
		}
		return count;

	}

	/**
	 * This method is used to get the plans by recharged id
	 * 
	 * @param id
	 * @return
	 * @throws DbException
	 */
	public static double getPlanById(int id) throws DbException {
		double planCost = 0;
		List<PrimeTopup> plans = PrimeTopupDao.getTopupDetails();
		for (PrimeTopup plan : plans) {
			if (plan.getTopupId() == id) {
				planCost = plan.getCost();
			}
		}
		return planCost;
	}
}
