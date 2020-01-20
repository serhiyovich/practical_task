package waiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DefaultWaiter {
	private static final long DEFAULT_TIMEOUT = 10;
	private WebDriver driver;

	public DefaultWaiter(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(WebElement element) {
		getDriverWait(DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
	}

	private FluentWait<WebDriver> getDriverWait(long timeout) {
		return new WebDriverWait(driver, timeout).pollingEvery(1000, TimeUnit.MILLISECONDS);
	}
}