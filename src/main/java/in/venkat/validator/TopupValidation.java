package in.venkat.validator;

import java.sql.SQLException;
import java.time.LocalDate;

import in.venkat.dao.PlansDao;
import in.venkat.exceptions.InvalidChoiceException;
import in.venkat.exceptions.PlanNotExpiredException;

public class TopupValidation {
	private TopupValidation() {
		/**
		 * Adding private constructor
		 */
	}

	/**
	 * This method checks whether the user plan has expired or not
	 * 
	 * @param expiryDate
	 * @return
	 * @throws PlanNotExpiredException
	 */
	public static boolean isDateValid(LocalDate expiryDate) throws PlanNotExpiredException {
		boolean valid = false;
		if (LocalDate.now().isAfter(expiryDate) || (expiryDate.equals(LocalDate.now()))) {
			valid = true;
		} else {
			throw new PlanNotExpiredException("plan not expired");
		}
		return valid;
	}

	/**
	 * This method is used to validate the choice whether the given choice have
	 * plans
	 * 
	 * @param choice
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InvalidChoiceException
	 */
	public static boolean choiceValidation(int choice) throws SQLException, InvalidChoiceException {
		int totalCount = PlansDao.totalPlans();
		boolean isChoiceValid = false;
		if (totalCount >= choice) {
			isChoiceValid = true;
		} else {
			throw new InvalidChoiceException("there is no plans existing in this choice");
		}
		return isChoiceValid;
	}
}
