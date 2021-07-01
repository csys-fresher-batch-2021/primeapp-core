package in.venkat.serviceTest;

import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidDetailsException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.service.ShowService;
import in.venkat.util.Logger;
import in.venkat.util.NameValidationUtil;

public class PreferenceTest {
	public static void main(String[] args) {
		String preferredLanguage = "hindi";

		preference(preferredLanguage);
	}

	private static void preference(String preferredLanguage) {
		try {
			if (NameValidationUtil.validateName(preferredLanguage)) {
				ShowService.getPreferredMoviesByLanguage(preferredLanguage);
			}
		} catch (DbException | EmptyFieldException | InvalidDetailsException | InvalidNameException e) {
			Logger.exception(e);
		}
	}
}
