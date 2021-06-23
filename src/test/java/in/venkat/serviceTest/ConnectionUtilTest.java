package in.venkat.serviceTest;

import java.sql.Connection;

import in.venkat.util.ConnectionUtil;
import in.venkat.util.Logger;

public class ConnectionUtilTest {

	public static void main(String[] args) {
		try {
			Connection con = ConnectionUtil.getConnection();
			Logger.log("Connection Status " + (con != null ));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
