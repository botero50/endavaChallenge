package com.challenge.ui.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.utils.Config;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "submit")
	private WebElement submitButton;

	@FindBy(xpath = "//span[not(string-length(normalize-space(.))=0)]")
	private WebElement errorMessage;

	public void enterEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickSubmit() {
		submitButton.click();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickSubmit();
	}

	public void login() {
		String email = Config.get("email");
		String password = Config.get("password");
		enterEmail(email);
		enterPassword(password);
		clickSubmit();
	}

	public boolean isLoginSuccessful() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		boolean isButtonInvisible = wait.until(ExpectedConditions.invisibilityOf(submitButton));
		return isButtonInvisible;
	}
}