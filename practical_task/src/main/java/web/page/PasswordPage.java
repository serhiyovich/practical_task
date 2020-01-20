package web.page;

import waiter.DefaultWaiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends AbstractPage {
	@FindBy(xpath = "//*[@type='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id='passwordNext']")
	private WebElement nextButton;

	public PasswordPage(WebDriver driver) {
		super(driver);
		waiter = new DefaultWaiter(driver);
	}

	@Step("The password field was filled in")
	public PasswordPage pastePassword(String password) {
		waiter.waitForElement(passwordField);
		passwordField.sendKeys(password);
		return this;
	}

	@Step("The next button was clicked")
	public InboxPage clickNextButtonPassword() {
		nextButton.click();
		return new InboxPage(driver);
	}
}