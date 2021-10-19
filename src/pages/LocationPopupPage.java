package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {
	public LocationPopupPage(WebDriver driver, WebDriverWait waiter,
			JavascriptExecutor javaScript) {
		super(driver, waiter, javaScript);

	}

	public WebElement getSelectLocation() {
		return this.driver
				.findElement(By.xpath("//div[@class='location-selector']/a"));
	}

	public WebElement getCloseElement() {
		return this.driver.findElement(
				By.xpath("//div[contains(@class,'location-search')]/a"));
	}

	public WebElement getKeyword() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By
				.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void openDialog() {
		this.getSelectLocation().click();
	}

	public void setLocation(String locationName) {
		this.getKeyword().click();
		String dataValue = this.getLocationItem(locationName)
				.getAttribute("data-value");
		javaScript.executeScript("arguments[0].value=arguments[1]",
				this.getLocationInput(), dataValue);
		javaScript.executeScript("arguments[0].click()", this.getSubmit());
	}

	public void closeDialog() {
		this.driver
				.findElement(
						By.xpath("//a[contains(@class,'close-btn-white')]"))
				.click();
	}
}
