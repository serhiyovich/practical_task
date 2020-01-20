package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.TestData;

import java.util.UUID;

public class GMailTest extends AbstractTest {
	@Test(description = "Check that letter from me")
	public void checkReceivedMessageTest() {
		String subjectText = UUID.randomUUID().toString();

		String receivedTextSubjectInMessageBody = loginPage
				.openPage()
				.pasteEmail(TestData.EMAIL)
				.clickNextButton()
				.pastePassword(TestData.PASSWORD)
				.clickNextButtonPassword()
				.clickComposeButton()
				.pasteRecipientsField(TestData.EMAIL)
				.pasteSubjectField(subjectText)
				.pasteMessageBodyField(TestData.MESSAGE_TEXT)
				.clickSendButton()
				.openMessage().getSubjectText();

		String receivedTextSenderInMessageBody = letterPage.getSenderText();

		Assert.assertEquals(receivedTextSubjectInMessageBody
				, subjectText
				, String.format("Text %s did not find.", subjectText));

		Assert.assertEquals(receivedTextSenderInMessageBody
				, TestData.EMAIL
				, String.format("Text %s did not find.", TestData.EMAIL));

		letterPage
				.clickMoreButton()
				.clickDeleteTooltip();
	}
}