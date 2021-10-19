package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test
	public void editProfileTest() throws InterruptedException {
		// ucitavanje stranice
		this.driver.get(this.baseUrl + "/guest-user/login-form");

		// gasenje lokacionog iskacuceg dijaloga
		this.locationPopupPage.getCloseElement().click();

		// prijavljivanje na app preko demo naloga
		this.loginPage.loginUser("customer@dummyid.com", "12345678a");

		Thread.sleep(2000);

		// verifikovanje da je prikazana poruka sa tekstom "Login Successfull"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Login Successfull");

		// ucitavanje stranice
		this.driver.get(this.baseUrl + "/member/profile");

		// zamena osnovnih informacija korisnika
		this.profilePage.changeBasicInformation("Jenny", "Rose",
				"Montomery Line", "0789 77 888 987", "EQ8 7TT",
				"United Kingdom", "Bristol", "Avon");
		Thread.sleep(3000);

		// verifikovanje poruke sa tekstom "Setup Successfull"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Setup Successful");

		Thread.sleep(3000);

		// odjava sa sajta
		this.authPage.getUser().click();
		this.authPage.getLogout();
		this.authPage.logoutUser();

		// verifikovanje poruke sa tekstom "Logout Successfull!"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Logout Successfull!");
	}

	@Test
	public void changeProfileImage() throws IOException {

		// prijavljivanje na stranicu
		this.driver.get(this.baseUrl + "/guest-user/login-form");

		// gasenje lokacionog iskacuceg dijaloga
		this.locationPopupPage.getCloseElement().click();

		// prijava na app preko demo naloga
		this.loginPage.loginUser("customer@dummyid.com", "12345678a");

		// verifikovanje poruke sa tekstom "Login Successfull"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Login Successfull");

		// prijava na stranicu
		this.driver.get((this.baseUrl + "/member/profile"));

		// otpremanje profilne slike
		String imgPath = new File("img/slika.jpeg").getCanonicalPath();
		this.profilePage.photoUpload();
		this.profilePage.uploadPhoto(imgPath);

		// verifikovanje poruke sa tekstom "Profile Image Uploaded Successfully"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Profile Image Uploaded Successfully");

		// cekanje da obavestenje nestane
		this.notificationSistemPage.notificationMessageDisaper();

		// brisanje profilne slike
		this.profilePage.removePhoto();

		// verifikovanje poruke sa tekstom "Profile Image Deleted Successfully"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Profile Image Deleted Successfully");

		// cekanje da obavestenje nestane
		this.notificationSistemPage.notificationMessageDisaper();

		// odjava sa sajta
		this.authPage.getUser().click();
		this.authPage.getLogout();
		this.authPage.logoutUser();

		// verifikovanje poruke sa tekstom "Logout Successfull!"
		Assert.assertEquals(this.notificationSistemPage.getMessageText(),
				"Logout Successfull!");

	}
}
