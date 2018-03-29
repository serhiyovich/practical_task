package test;

import autoamtionframework.webdriver.DefaultDriverProvider;
import autoamtionframework.webdriver.DriverProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import web.page.InboxPage;
import web.page.LoginPage;

public abstract class AbstractTest {
	DriverProvider driverProvider = new DefaultDriverProvider();
//	DefaultWaiter waiter;
	LoginPage loginPage;
//	PasswordPage passwordPage;
	InboxPage inboxPage;

	@BeforeClass
	@Parameters({"browserName"})
	public void beforeTest(@Optional("Chrome") String browserName) {
		driverProvider.setDriverInstance(browserName);
		loginPage = new LoginPage(driverProvider.getDriverInstance());
		inboxPage = new InboxPage(driverProvider.getDriverInstance());
//		PropertyReader.initProperty("src\\main\\resources\\application.properties");
//		DriverFactory.getDriver(browserName);
	}

	@AfterClass
	public void close() {
		driverProvider.destroy();
	}
}