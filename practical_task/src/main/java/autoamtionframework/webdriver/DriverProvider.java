package autoamtionframework.webdriver;

import org.openqa.selenium.WebDriver;

public interface DriverProvider {
	void setDriverInstance(String browserName);

	WebDriver getDriverInstance();

	void destroy();
}