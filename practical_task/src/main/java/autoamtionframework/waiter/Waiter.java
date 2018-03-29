package autoamtionframework.waiter;

import org.openqa.selenium.WebElement;

public interface Waiter {
	void waitForElement(WebElement element);

//	void waitForElement(By by);
}