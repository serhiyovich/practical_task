package autoamtionframework.webdriver;

import org.openqa.selenium.WebDriver;

public class DefaultDriverProvider implements DriverProvider {
	private WebDriver driverInstance;

	public void setDriverInstance(String browserName) {
		if (driverInstance == null) {
			driverInstance = DriverFactory.getDriver(browserName);
		}
	}

	public WebDriver getDriverInstance() {
		return driverInstance;
	}

	public void destroy() {
		if (driverInstance != null) {
			driverInstance.quit();
			driverInstance = null;
		}
	}
}