package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor javaScript;

	public BasicPage(WebDriver driver, WebDriverWait waiter,
			JavascriptExecutor javaScript) {
		this.driver = driver;
		this.waiter = waiter;
		this.javaScript = javaScript;

	}

}
