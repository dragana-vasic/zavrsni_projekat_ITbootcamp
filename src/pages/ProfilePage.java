package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
	public ProfilePage(WebDriver driver, WebDriverWait waiter,
			JavascriptExecutor javaScript) {
		super(driver, waiter, javaScript);
	}

	public WebElement getFirstName() {
		return this.driver
				.findElement(By.xpath("//*[@name='user_first_name']"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}

	public WebElement getAddress() {
		return this.driver.findElement(By.xpath("//*[@name='user_address']"));
	}

	public WebElement getPhoneNumber() {
		return this.driver.findElement(By.xpath("//*[@name='user_phone']"));
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.xpath("//*[@name='user_zip']"));
	}

	public Select getCountry() {
		WebElement country = this.driver.findElement(By.id("user_country_id"));
		Select select = new Select(country);
		return select;
	}

	public Select getState() {
		WebElement state = this.driver.findElement(By.id("user_state_id"));
		Select select = new Select(state);
		return select;
	}

	public Select getCity() {
		WebElement city = this.driver.findElement(By.id("user_city"));
		Select select = new Select(city);
		return select;
	}

	public WebElement getButtonSave() {
		return this.driver.findElement(By
				.xpath("//*[@id='profileInfoFrm']/div[5]/div/fieldset/input"));
	}

	public WebElement getImage() {
		return this.driver.findElement(By.xpath("//*[@class='avatar']"));
	}

	public void photoUpload() {
		WebElement uploadButton = this.driver
				.findElement(By.xpath("//a[contains(@class, 'upload')]"));
		this.javaScript.executeScript("arguments[0].click()", uploadButton);
	}

	public void uploadPhoto(String image) {
		WebElement file = this.driver
				.findElement(By.xpath("//input[@type='file']"));
		file.sendKeys(image);
	}

	public void removePhoto() {
		WebElement removeButton = this.driver
				.findElement(By.xpath("//a[contains(@class, 'remove')]"));
		this.javaScript.executeScript("arguments[0].click()", removeButton);
	}

	public void changeBasicInformation(String firstName, String lastName,
			String address, String phoneNumber, String zipCode, String country,
			String state, String city) throws InterruptedException {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhoneNumber().clear();
		this.getPhoneNumber().sendKeys(phoneNumber);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(2000);
		this.getState().selectByVisibleText(state);
		Thread.sleep(2000);
		this.getCity().selectByVisibleText(city);
		Thread.sleep(2000);

		WebElement element = this.driver.findElement(By.name("user_zip"));

		this.javaScript.executeScript("arguments[0].scrollIntoView(true);",
				element);
		this.getButtonSave().click();

	}

}
