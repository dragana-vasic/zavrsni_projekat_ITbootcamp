package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {

	@Test
	public void mealToCart() throws InterruptedException {

		// ucitavanje stranice
		this.driver
				.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");

		// gasenje lokacionog iskacuceg dijaloga
		this.locationPopupPage.getCloseElement().click();

		// dodavanje jela u korpu
		this.mealPage.getAddToCart().click();

		// verifikovanje poruke sa tekstom "The Following Errors Occurred:
		// Please Select Location"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"The Following Errors Occurred:\nPlease Select Location");

		// cekanje da obavestenje nestane
		this.notificationSistemPage.notificationMessageDisaper();

		// postavljanje lokacije
		this.locationPopupPage.getSelectLocation().click();
		this.locationPopupPage.setLocation("City Center - Albany");

		Thread.sleep(3000);
		// dodavanje jela u korpu
		this.mealPage.getAddToCart().click();

		// verifikovanje poruke sa tekstom "Meal Added To Cart"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Meal Added To Cart");
	}

	@Test
	public void addMealToFavorite() throws InterruptedException {
		// ucitavanje stranice
		this.driver.get(
				this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");

		// gasenje lokacionog iskacuceg dojaloga
		this.locationPopupPage.getCloseElement().click();

		Thread.sleep(3000);

		// dodavanje jela u omiljena
		this.mealPage.getFavoriteButton().click();

		// verifikovanje poruke sa tekstom "Please login first!"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Please login first!");

		Thread.sleep(5000);

		// ucitavanje stranice za prijavu
		this.mealPage.getLoginButton().click();

		Thread.sleep(3000);

		// prijava na app preko demo naloga
		this.loginPage.getLoginButton().click();

		Thread.sleep(2000);

		// ucitavanje stranice
		this.driver.get(
				this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");

		// dodavanje jela u omiljeno
		this.mealPage.getFavoriteButton().click();

		// verifikovanje poruke sa tekstom ""Product has been added to your
		// favorites."
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Product has been added to your favorites.");

	}

	@Test
	public void clearCartTest() throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();

		// ucitavanje stranice
		this.driver.get(this.baseUrl + "/meals");

		// postavljanje lokacije
		this.locationPopupPage.setLocation("City Center - Albany");

		// citanje podataka, dodavanje proizvoda i verifikovaje poruke sa
		// tekstom "Meal Added To Cart"
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheetMeals = wb.getSheet("Meals");
		for (int i = 1; i <= sheetMeals.getLastRowNum(); i++) {

			String url = sheetMeals.getRow(i).getCell(0).getStringCellValue();

			this.driver.get(url);
			this.mealPage.getAddToCart().click();

			Thread.sleep(2000);

			sa.assertEquals(this.notificationSistemPage.getMessageText(),
					"Meal Added To Cart");
		}
		sa.assertAll();

		Thread.sleep(3000);

		// brisanje svih stavki iz korpe
		this.cartSummaryPage.getClearAll().click();

		// verifikovanje poruke sa tekstom "All meals removed from Cart
		// successfully"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"All meals removed from Cart successfully");
	}
}
