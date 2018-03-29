package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends AbstractPage {
	@FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
	private WebElement composeButton;
	@FindBy(xpath = "//*[@name='to']")
	private WebElement recipientsField;
	@FindBy(xpath = "//*[@name='subjectbox']")
	private WebElement subjectField;
	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement messageBodyField;
	@FindBy(xpath = "//div[contains(text(),'Send')]")
	private WebElement sendButton;
	@FindBy(xpath = "//*[@role='tabpanel']//tr")
	private WebElement message;
	@FindBy(xpath = "//*[@id='link_vsm']")
	private WebElement confirmSendMessagePopUp;

	InboxPage(WebDriver driver) {
		super(driver);
	}

	@Step("The compose button was clicked")
	public InboxPage clickComposeButton() {
		waiter.waitForElement(composeButton);
		composeButton.click();
		return this;
	}

	@Step("The recipients field was filled in")
	public InboxPage pasteRecipientsField(String email) {
		waiter.waitForElement(recipientsField);
		recipientsField.sendKeys(email);
		return this;
	}

	@Step("The subject was filled in")
	public InboxPage pasteSubjectField(String subject) {
		subjectField.sendKeys(subject);
		return this;
	}

	@Step("The message body was filled in")
	public InboxPage pasteMessageBodyField(String message) {
		messageBodyField.sendKeys(message);
		return this;
	}

	@Step("The letter was sent")
	public InboxPage clickSendButton() {
		sendButton.click();
		return this;
	}

	@Step("The new message was opened")
	public LetterPage openMessage() {
		waiter.waitForElement(confirmSendMessagePopUp);
		refresh();
		message.click();
		return new LetterPage(driver);
	}
}