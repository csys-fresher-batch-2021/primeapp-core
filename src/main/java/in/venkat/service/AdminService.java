package in.venkat.service;

import java.util.List;

import in.venkat.dao.AdminDao;
import in.venkat.exceptions.AdminNamePasswordMismatchException;
import in.venkat.exceptions.DbException;
import in.venkat.exceptions.EmptyFieldException;
import in.venkat.exceptions.InvalidNameException;
import in.venkat.exceptions.InvalidPasswordException;
import in.venkat.model.Admin;
import in.venkat.util.NameValidationUtil;
import in.venkat.util.PasswordValidationUtil;

public class AdminService {
	/**
	 * This method is used to validate the admin name and password
	 * 
	 * @param adminName
	 * @param password
	 * @return
	 * @throws DbException
	 * @throws AdminNamePasswordMismatchException
	 * @throws InvalidNameException
	 * @throws EmptyFieldException
	 * @throws InvalidPasswordException
	 */
	public static boolean adminLogin(String adminName, String password) throws DbException,
			AdminNamePasswordMismatchException, InvalidNameException, EmptyFieldException, InvalidPasswordException {
		boolean validAdmin = NameValidationUtil.checkName(adminName);
		boolean validPassword = PasswordValidationUtil.validatePassword(password);
		boolean isLoggedIn = false;
		List<Admin> adminDetails = AdminDao.getAdminDetails();
		if (validAdmin && validPassword) {
			for (Admin admin : adminDetails) {
				if (admin.getAdminName().equals(adminName)) {
					if (admin.getAdminPassword().equals(password)) {
						isLoggedIn = true;
					} else {
						throw new AdminNamePasswordMismatchException("unauthorized admin");
					}
					break;
				}

			}
		} else {
			throw new AdminNamePasswordMismatchException("invalid admin name or password");
		}

		return isLoggedIn;

	}

}
