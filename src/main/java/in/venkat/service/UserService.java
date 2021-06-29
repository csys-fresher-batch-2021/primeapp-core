package in.venkat.service;

import java.lang.module.ModuleDescriptor.Builder;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import in.venkat.dao.PrimeTopupDao;
import in.venkat.dao.UserDao;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.exceptions.InvalidNumberException;
import in.venkat.exceptions.InvalidPasswordException;
import in.venkat.exceptions.InvalidPhoneNumberException;
import in.venkat.exceptions.InvalidUserIdException;
import in.venkat.exceptions.PasswordMismatchException;
import in.venkat.exceptions.UserIdPasswordMismatchException;
import in.venkat.model.PrimeTopup;
import in.venkat.model.User;
import in.venkat.util.Logger;
import in.venkat.validator.ValidateUserDetails;

public class UserService {
	private UserService() {
		/**
		 * adding a private constructor
		 */
	}

	/**
	 * 
	 * @param name
	 * @param mobileNumber
	 * @param userPasscode
	 * @param reEnteredPasscode
	 * @return
	 * @throws EmptyFieldException       when any field is empty it throws
	 *                                   EmptyFieldException
	 * @throws InvalidNameException      when the name contains any numbers then it
	 *                                   throws InvalidNameException
	 * @throws InvalidNumberException    when the mobile number contains any
	 *                                   alphabets then it throws
	 *                                   InvalidNumberException
	 * @throws InvalidPasswordException  when the password is in less security level
	 *                                   then it throws InvalidPasswordException
	 * @throws PasswordMismatchException when the password and re-entered password
	 *                                   is incorrect then it throws
	 *                                   PasswordMismatchException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DbException
	 */
	public static boolean registerUser(String name, long mobileNumber, String userPasscode, String reEnteredPasscode)
			throws EmptyFieldException, InvalidNameException, InvalidNumberException, InvalidPasswordException,
			PasswordMismatchException, SQLException, DbException {

		boolean isValid = ValidateUserDetails.validateUserDetails(name, mobileNumber, userPasscode);
		if (isValid && ValidateUserDetails.isPassEqual(userPasscode, reEnteredPasscode)) {
			String mobNum = Long.toString(mobileNumber);
			String userId = name.concat(mobNum);
			User register = new User(userId, name, mobileNumber, userPasscode);
			UserDao.register(register);
			Logger.log("your user id is :" + userId);

		}
		return isValid;

	}

	/**
	 * This method is used to find the given input is phone number or userId
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws DbException
	 * @throws UserIdPasswordMismatchException
	 * @throws InvalidPhoneNumberException
	 */
	public static boolean validateUserLogin(String userId, String password)
			throws DbException, UserIdPasswordMismatchException, InvalidPhoneNumberException {
		boolean isLoggedIn = false;
		if (userId.trim().length() == 10) {
			long phoneNumber = ValidateUserDetails.checkPhoneNumber(userId);

			isLoggedIn = loginByPhoneNumber(phoneNumber, password);
		} else {
			isLoggedIn = loginByUserId(userId, password);
		}
		return isLoggedIn;
	}

	/**
	 * This method is used when phone number and password is entered
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 * @throws DbException
	 * @throws UserIdPasswordMismatchException
	 */
	private static boolean loginByPhoneNumber(long phoneNumber, String password)
			throws DbException, UserIdPasswordMismatchException {
		boolean isLoggedIn = false;
		List<User> userDetails = UserDao.getAllUserPhoneNumber();
		for (User user : userDetails) {
			if (user.getPhoneNumber() == phoneNumber) {
				if (user.getPassword().equals(password)) {
					isLoggedIn = true;
				} else {
					throw new UserIdPasswordMismatchException("invalid password");
				}
				break;
			}

		}

		return isLoggedIn;

	}

	/**
	 * This method is used to login by userId and password
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws DbException
	 * @throws UserIdPasswordMismatchException
	 */
	public static boolean loginByUserId(String userId, String password)
			throws DbException, UserIdPasswordMismatchException {
		boolean isLoggedIn = false;
		List<User> userDetails = UserDao.getAllRegisteredUserId();
		for (User user : userDetails) {
			if (user.getUserId().equals(userId)) {
				if (user.getPassword().equals(password)) {
					isLoggedIn = true;
				} else {
					throw new UserIdPasswordMismatchException("invalid password");
				}
				break;
			}

		}

		return isLoggedIn;

	}

	/**
	 * This method is used to check whether the user already exists
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 * @throws InvalidUserIdException
	 */
	public static boolean isValidUser(String userId) throws DbException, InvalidUserIdException {
		boolean isValid = false;
		List<User> user = UserDao.getAllRegisteredUserId();
		for (User users : user) {
			if (users.getUserId().equals(userId)) {
				isValid = true;
			}
		}
		if (!isValid) {
			throw new InvalidUserIdException("invalid user");
		}
		return isValid;

	}

	/**
	 * This method is used to find the user re-charge is expired or not
	 * 
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	public static boolean isRechargeNotExpired(String userId) throws DbException {
		boolean isValid = false;
		List<PrimeTopup> recharge = PrimeTopupDao.getExpiryDate();
		for (PrimeTopup recharged : recharge) {
			if (recharged.getUserId().equals(userId) && recharged.getExpiryDate().isBefore(LocalDate.now())) {
				isValid = true;
			}
		}
		return isValid;
	}


}
