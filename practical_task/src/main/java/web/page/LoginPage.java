package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.TestData;

public class LoginPage extends AbstractPage {
	@FindBy(xpath = "//*[@type='email']")//________________________в чем разница между этим и @FindBy(xpath)?
	private WebElement emailOrPhoneField;
	@FindBy(xpath = "//*[@id='identifierNext']")
	private WebElement nextButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage openPage() {
		maximize();
		driver.get(getUrl());
		return this;
	}

	public String getUrl() {
		return TestData.URL;
	}

	//	@Step("Login Step with username: {0}, for method: {method} step...")
	@Step("TRACE: sssssssssss {0}")

	public LoginPage pasteEmail(String email) {
		emailOrPhoneField.sendKeys(email);
		return this;
//		TestReporter.reportStep("Fill in email",email);
	}

	public PasswordPage clickNextButton() {
		nextButton.click();
		return new PasswordPage(driver);//зачем обьявляем драйвер?
	}
}