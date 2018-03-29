package testreporter;


import org.testng.log4testng.Logger;

public class LoggerHelper {
	private static final Logger LOGGER = Logger.getLogger(LoggerHelper.class);

	public static void info(String message) {
		LOGGER.info(message);
	}

	public static void error(String message) {
		LOGGER.error(message);
	}

	public static void warn(String message) {
		LOGGER.warn(message);
	}

	public static void debug(String message) {
		LOGGER.debug(message);
	}
}