package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {
	public NotificationSistemPage(WebDriver driver, WebDriverWait waiter,
			JavascriptExecutor javaScript) {
		super(driver, waiter, javaScript);
	}

	public WebElement getNotificationMessage() {
		return this.driver.findElement(
				By.xpath("//*[contains(@class, 'alert--success') or"
						+ " contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

	public String getMessageText() {
		return this.getNotificationMessage().getText();
	}

	public void notificationMessageDisaper() {
		this.driver.findElement(By.xpath(
				"//*[contains(@class, 'system_message')][@style='display: none;']"));
	}

}
