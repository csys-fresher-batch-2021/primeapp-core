package in.venkat.validator;

import java.time.LocalDate;

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
}
