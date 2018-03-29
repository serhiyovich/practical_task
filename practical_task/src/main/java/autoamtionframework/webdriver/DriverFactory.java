package autoamtionframework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver getDriver(String browserName) {
		if ("FIREFOX".equalsIgnoreCase(browserName)) {
			System.setProperty("autoamtionframework.webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			return new FirefoxDriver();
		} else if ("CHROME".equalsIgnoreCase(browserName)) {
			System.setProperty("autoamtionframework.webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			return new ChromeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
	}
}