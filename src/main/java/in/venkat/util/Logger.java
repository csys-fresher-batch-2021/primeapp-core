package in.venkat.util;

public class Logger {
	private Logger() {
		/**
		 * Adding a  private Constructor
		 */
	}

	public static void log(Object obj) {
		System.out.println(obj);
	}

	public static void exception(Exception e) {
		System.out.println(e.getMessage());

	}
}
