package com.challenge.uiTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.challenge.ui.pages.BaseTest;
import com.challenge.ui.pages.LoginPage;

public class LoginTests extends BaseTest {

	@Test(description = "Test if the user can login using valid data on the login page")
	public void testLoginAsAnExistingUser() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		assertTrue(loginPage.isLoginSuccessful(),
				"login was not successful after sending real user and real password.");
	}

	@Test(description = "Test if the error message appears when user is not sending the right data on the login page")
	public void testLoginAsANonExistingUser() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("BadUser", "BadPassword");
		assertEquals(loginPage.getErrorMessage(), "Incorrect username or password");
	}
}