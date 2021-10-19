package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {
	public CartSummaryPage(WebDriver driver, WebDriverWait waiter,
			JavascriptExecutor javaScript) {
		super(driver, waiter, javaScript);
	}

	public WebElement getClearAll() {
		return this.driver
				.findElement(By.xpath("//div[@class='cart-head']/a[2]"));
	}

	public void clearAllCommand() {
		this.getClearAll().clear();
	}
}
