package in.venkat.searchServiceTest;

import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class ConnectionUtilTest {

	public static void main(String[] args) {
		try {
			ConnectionUtil.getConnection();
			Logger.log(" Connection Success");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
