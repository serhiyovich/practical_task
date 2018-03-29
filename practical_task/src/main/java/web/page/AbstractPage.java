package web.page;

import autoamtionframework.waiter.DefaultWaiter;
import autoamtionframework.waiter.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	WebDriver driver;
	Waiter waiter;

	AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waiter = new DefaultWaiter(driver);
	}

	void maximize() {
		driver.manage().window().maximize();
	}

	void refresh() {
		driver.navigate().refresh();
	}
}
