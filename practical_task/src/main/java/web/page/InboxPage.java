package web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends AbstractPage {
	@FindBy(xpath = "//div[contains(text(),'COMPOSE')]")// в чем разница между этим и другим FindBy
	private WebElement composeButton;
	@FindBy(xpath = "//*[@name='to']")// возможны проблемы с изменением локатора
	private WebElement recipientsField;
	@FindBy(xpath = "//*[@name='subjectbox']")
	private WebElement subjectField;
	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement messageBodyField;
	@FindBy(xpath = "//div[contains(text(),'Send')]")
	private WebElement sendButton;
	//	@FindBy(xpath = "//span[contains(text(),'I want to work!')]")//сделать стримом
//	private WebElement massages;
//	@FindBy(xpath = "//colgroup/following-sibling::tbody/child::*")//сделать стримом
//	private List<WebElement> messages;
	@FindBy(xpath = "//*[@role='tabpanel']//tr")//сделать стримом
	private WebElement messages;
	@FindBy(xpath = "//*[@role='presentation']//h2")
	private WebElement getSubjectTextField;
	@FindBy(xpath = "//*[@id='link_vsm']")
	private WebElement confirmSendMessagePopUp;
	@FindBy(xpath = "//*[@data-tooltip='More']")
	private WebElement dropDownList;
	@FindBy(xpath = "//*[contains(text(),'Delete this message')]")
	private WebElement deleteInDropDownListButton;

	public InboxPage(WebDriver driver) {
		super(driver);
	}

	public InboxPage clickComposeButton() {
		waiter.waitForElement(composeButton);
		composeButton.click();
		return this;
	}

	public InboxPage pasteRecipientsField(String email) {
		waiter.waitForElement(recipientsField);
		recipientsField.sendKeys(email);
		return this;
	}

	public InboxPage pasteSubjectField(String subject) {
		subjectField.sendKeys(subject);
		return this;
	}

	public InboxPage pasteMessageBodyField(String message) {
		messageBodyField.sendKeys(message);
		return this;
	}

	public InboxPage clickSendButton() {
		sendButton.click();
		return this;
	}

	public InboxPage openMessage() {
		waiter.waitForElement(confirmSendMessagePopUp);
		refresh();
		messages.click();
		return this;
	}

	public String getSubjectText() {
		return getSubjectTextField.getText().trim();
	}

	public InboxPage clickMoreButton() {
		waiter.waitForElement(dropDownList);
		dropDownList.click();
		return this;
	}

	public InboxPage clickDeleteTooltip() {
		waiter.waitForElement(deleteInDropDownListButton);
		deleteInDropDownListButton.click();
		return this;
	}
//	public void selectMessageByText(String text) {
//		WebElement requiredMessage = findMessageByText(text).findElement((By) messages);//исправить в старый способ возможно
//		requiredMessage.click();
//	}

//	private List<WebElement> getAllDisplayedMessages() {
//		return messages;
//	}

//	private WebElement findMessageByText(String text) {
//		return getAllDisplayedMessages()
//				.stream()
//				.filter(element -> element.findElement((By) messages).getText().trim().equalsIgnoreCase(text))// исправить в старый способ возможно
//				.findFirst()
//				.orElseThrow(() -> new NoSuchElementException(String.format("No messages with text: %s", text)));
//	}
}