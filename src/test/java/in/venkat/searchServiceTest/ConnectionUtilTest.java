package in.venkat.searchServiceTest;

import static org.junit.Assert.fail;

import in.venkat.util.ConnectionUtil;

public class ConnectionUtilTest {

	public static void main(String[] args) {
		try {
			ConnectionUtil.getConnection();
		} catch (Exception e) {
			fail();
		}
	}
}
