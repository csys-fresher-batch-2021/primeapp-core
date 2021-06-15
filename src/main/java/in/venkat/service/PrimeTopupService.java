package in.venkat.service;

import java.time.LocalDate;
import java.util.List;

import in.venkat.dao.PrimeTopupDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.PlanNotExpiredException;
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
	 */
	public static void primeTopup(int choice, boolean isConfirm, String userId)
			throws DbException, InvalidUserIdException, PlanNotExpiredException {
		int plan = 0;
		int validity = 0;
		LocalDate today = LocalDate.now();
		LocalDate expireDate = null;
		boolean validUserId = ValidateUserDetails.checkUserId(userId);
		boolean validTopup = PrimeTopupService.checkValidTopup(userId);
		if (validUserId && isConfirm && validTopup) {

			switch (choice) {
			case 1: {
				plan = 399;
				Logger.log("PLAN :  " + plan);
				validity = 30;
				Logger.log("VALIDITY : " + validity + " DAYS ");
				Logger.log("TODAY DATE : " + today);
				expireDate = today.plusDays(validity);
				Logger.log("EXPIRY DATE : " + expireDate);
				PrimeTopup plans = new PrimeTopup(userId, plan, today, validity, expireDate);
				PrimeTopupDao.saveTopupDetails(plans);

				break;

			}

			case 2: {
				plan = 699;
				Logger.log("PLAN : " + plan);
				validity = 60;
				Logger.log("VALIDITY : " + validity + " DAYS ");
				Logger.log("TODAY DATE : " + today);
				expireDate = today.plusDays(validity);
				Logger.log("EXPIRY DATE : " + expireDate);
				PrimeTopup plans = new PrimeTopup(userId, plan, today, validity, expireDate);
				PrimeTopupDao.saveTopupDetails(plans);

				break;

			}
			default: {
				Logger.log("invalid plan details");
			}

			}
		} else {
			throw new InvalidUserIdException("invalid user id ");
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
		boolean isExpired = false;
		if (checkNewTopup) {
			LocalDate expiryDateCheck = getExpiryDate(userId);
			isExpired = TopupValidation.isDateValid(expiryDateCheck);

		}

		return isExpired;
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
	public static boolean isNewTopup(String UserId) throws DbException {
		boolean checkUser = false;
		List<PrimeTopup> newTopup = PrimeTopupDao.getExpiryDate();
		for (PrimeTopup userIdCheck : newTopup) {
			if (userIdCheck.getUserId().equals(UserId)) {
				checkUser = true;
			}

		}
		return checkUser;
	}
}
