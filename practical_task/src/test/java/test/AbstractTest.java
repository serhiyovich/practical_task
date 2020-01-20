package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.page.LetterPage;
import web.page.LoginPage;

public abstract class AbstractTest {
	private WebDriver driver;
	LoginPage loginPage;
	LetterPage letterPage;

	@BeforeClass
	public void beforeTest() {
		System.setProperty("chrome", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		letterPage = new LetterPage(driver);
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}