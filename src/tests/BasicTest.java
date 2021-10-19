package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor javaScript;
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String email;
	protected String password;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.waiter = new WebDriverWait(this.driver, 20);
		this.javaScript = (JavascriptExecutor) driver;
		this.locationPopupPage = new LocationPopupPage(this.driver, this.waiter,
				this.javaScript);
		this.loginPage = new LoginPage(this.driver, this.waiter,
				this.javaScript);
		this.notificationSistemPage = new NotificationSistemPage(this.driver,
				this.waiter, this.javaScript);
		this.profilePage = new ProfilePage(this.driver, this.waiter,
				this.javaScript);
		this.authPage = new AuthPage(this.driver, this.waiter, this.javaScript);
		this.mealPage = new MealPage(this.driver, this.waiter, this.javaScript);
		this.cartSummaryPage = new CartSummaryPage(this.driver, this.waiter,
				this.javaScript);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(this.driver, result.getName());
		}
		this.driver.quit();
	}

}
