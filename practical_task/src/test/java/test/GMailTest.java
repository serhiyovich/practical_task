package test;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.TestData;

public class GMailTest extends AbstractTest {
	@Test
	@Step("TRACE: sssssssssss {0}")
	public void TestGMail() {
		loginPage
				.openPage()
				.pasteEmail(TestData.EMAIL)
				.clickNextButton()
				.pastePassword(TestData.PASSWORD)
				.clickNextButtonPassword()
				.clickComposeButton()
				.pasteRecipientsField(TestData.EMAIL)
				.pasteSubjectField(TestData.SUBJECT_TEXT)
				.pasteMessageBodyField(TestData.MESSAGE_TEXT)
				.clickSendButton()
				.openMessage();

		String receivedTextSubjectInMessageBody = inboxPage.getSubjectText();

		Assert.assertEquals(receivedTextSubjectInMessageBody
				, TestData.SUBJECT_TEXT
				, String.format("Text %s did not find.", TestData.SUBJECT_TEXT));

		inboxPage
				.clickMoreButton()
				.clickDeleteTooltip();
	}
}