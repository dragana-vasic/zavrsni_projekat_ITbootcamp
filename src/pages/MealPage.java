package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {
	public MealPage(WebDriver driver, WebDriverWait waiter,
			JavascriptExecutor javaScript) {
		super(driver, waiter, javaScript);
	}

	public WebElement getSearchYourFavMeals() {
		return this.driver
				.findElement(By.xpath("//input[@class='js-search-keywords']"));
	}

	public WebElement getFavoriteButton() {
		return this.driver.findElement(
				By.xpath("//div[@class='product-detail-image']/a"));
	}

	public WebElement getAddToCart() {
		return this.driver.findElement(
				By.xpath("//div[contains(@class, 'align-items-center')]/a"));
	}

	public WebElement getQuantityButton() {
		return this.driver.findElement(By.xpath("//input[@type='number']"));
	}

	public WebElement getLoginButton() {
		return this.driver.findElement(By
				.xpath("//div[contains(@class, 'accounts-link')]/ul/li[2]/a"));
	}

}
