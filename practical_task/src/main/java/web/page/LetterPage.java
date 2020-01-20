package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends AbstractPage {
	@FindBy(xpath = "//*[@data-tooltip='More']")
	private WebElement dropDownList;
	@FindBy(xpath = "//*[contains(text(),'Delete this message')]")
	private WebElement deleteInDropDownListButton;
	@FindBy(xpath = "//*[@role='presentation']//h2")
	private WebElement subjectTextField;
	@FindBy(xpath = "//div[@role='listitem']//span[@class='go']")
	private WebElement senderTextField;

	public LetterPage(WebDriver driver) {
		super(driver);
	}

	@Step("The more button was clicked")
	public LetterPage clickMoreButton() {
		waiter.waitForElement(dropDownList);
		dropDownList.click();
		return this;
	}

	@Step("The current message was deleted")
	public void clickDeleteTooltip() {
		waiter.waitForElement(deleteInDropDownListButton);
		deleteInDropDownListButton.click();
	}

	@Step("The subject text was gotten")
	public String getSubjectText() {
		return subjectTextField.getText().trim();
	}

	@Step("The sender was gotten")
	public String getSenderText() {
		return senderTextField.getText().trim().replaceAll("[^a-zA-Z@. ]", "");
	}

}