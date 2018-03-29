package web.page;

import autoamtionframework.waiter.DefaultWaiter;
import autoamtionframework.waiter.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends AbstractPage {
	Waiter waiter;
	@FindBy(xpath = "//*[@type='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id='passwordNext']")
	private WebElement nextButton;

	public PasswordPage(WebDriver driver) {
		super(driver);
		waiter = new DefaultWaiter(driver);
	}

	public PasswordPage pastePassword(String password) {
		waiter.waitForElement(passwordField);
		passwordField.sendKeys(password);
		return this;
	}

	public InboxPage clickNextButtonPassword() {
		nextButton.click();
		return new InboxPage(driver);
	}
}
