package in.venkat.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import in.venkat.dao.PlansDao;
import in.venkat.dao.PrimeTopupDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidChoiceException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.PlanNotExpiredException;
import in.venkat.model.Plans;
import in.venkat.model.PrimeTopup;
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
			throws DbException, InvalidUserIdException, PlanNotExpiredException, ClassNotFoundException, SQLException,
			InvalidChoiceException {
		boolean validTopup = PrimeTopupService.checkValidTopup(userId);
		boolean validUserId = ValidateUserDetails.checkUserId(userId);
		boolean isChoiceValid = TopupValidation.choiceValidation(choice);
		List<Plans> plans = PlansDao.getPrimePlans();
		int plan = 0;
		int validity = 0;
		for (Plans primePlans : plans) {
			if (choice == primePlans.getPlanId() && validTopup && validUserId && isChoiceValid) {
				plan = primePlans.getPrimePlans();
				validity = primePlans.getPlanValidity();
				LocalDate today = LocalDate.now();
				LocalDate expiryDate = today.plusDays(validity);
				PrimeTopup primePlan = new PrimeTopup(userId, plan, today, validity, expiryDate);
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
	private static boolean checkValidTopup(String userId) throws DbException, PlanNotExpiredException {
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
		List<PrimeTopup> topupExpiryDate = PrimeTopupDao.getExpiryDate();
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
		List<PrimeTopup> newTopup = PrimeTopupDao.getExpiryDate();
		for (PrimeTopup userIdCheck : newTopup) {
			if (userIdCheck.getUserId().equals(userId)) {
				checkUser = true;
			}

		}
		return checkUser;
	}
}
