package testreporter;


import io.qameta.allure.Step;

public class TestReporter {
	public static void reportStep(String stepMessage, Object... parameters) {
		String message = String.format(stepMessage, parameters);
		LoggerHelper.info(message);
		reportAllureStep(message);
	}
	@Step("{0}")
	private static void reportAllureStep(String stepMessage) {
	}
}