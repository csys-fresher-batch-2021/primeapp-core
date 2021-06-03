package in.venkat.searchServiceTest;

import in.venkat.util.ConnectionUtil;

public class ConnectionUtilTest {

	public static void main(String[] args) {
		try {
			ConnectionUtil.getConnection();
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
