package in.venkat.service;

import java.util.List;

import in.venkat.dao.PlansDao;
import in.venkat.exceptions.DbException;
import in.venkat.model.Plans;
import in.venkat.util.Logger;

public class PlansService {
	private PlansService() {
		/**
		 * Adding private constructor
		 */
	}

	public static List<Plans> getPlans() throws DbException {
		List<Plans> plans = PlansDao.getPrimePlans();
		Logger.log(plans);
		return plans;

	}

}
