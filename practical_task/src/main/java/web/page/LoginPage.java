package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.TestData;

public class LoginPage extends AbstractPage {
	@FindBy(xpath = "//*[@type='email']")
	private WebElement emailOrPhoneField;
	@FindBy(xpath = "//*[@id='identifierNext']")
	private WebElement nextButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Step("The page was opened")
	public LoginPage openPage() {
		maximize();
		driver.get(getUrl());
		return this;
	}

	@Step("The email field was filled in")
	public LoginPage pasteEmail(String email) {
		emailOrPhoneField.sendKeys(email);
		return this;
	}

	@Step("The next button was clicked")
	public PasswordPage clickNextButton() {
		nextButton.click();
		return new PasswordPage(driver);
	}

	private String getUrl() {
		return TestData.URL;
	}
}