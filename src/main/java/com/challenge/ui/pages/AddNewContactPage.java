package com.challenge.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewContactPage {

	// Constructor to initialize the page elements
	public AddNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Locate elements using @FindBy
	@FindBy(id = "firstName")
	private WebElement firstNameField;

	@FindBy(id = "lastName")
	private WebElement lastNameField;

	@FindBy(id = "birthdate")
	private WebElement birthdateField;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "phone")
	private WebElement phoneField;

	@FindBy(id = "street1")
	private WebElement street1Field;

	@FindBy(id = "street2")
	private WebElement street2Field;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "stateProvince")
	private WebElement stateProvinceField;

	@FindBy(id = "postalCode")
	private WebElement postalCodeField;

	@FindBy(id = "country")
	private WebElement countryField;

	@FindBy(id = "submit")
	private WebElement submitButton;

	// Define methods to interact with the page
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterBirthdate(String birthdate) {
		birthdateField.sendKeys(birthdate);
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterPhone(String phone) {
		phoneField.sendKeys(phone);
	}

	public void enterStreet1(String street1) {
		street1Field.sendKeys(street1);
	}

	public void enterStreet2(String street2) {
		street2Field.sendKeys(street2);
	}

	public void enterCity(String city) {
		cityField.sendKeys(city);
	}

	public void enterStateProvince(String stateProvince) {
		stateProvinceField.sendKeys(stateProvince);
	}

	public void enterPostalCode(String postalCode) {
		postalCodeField.sendKeys(postalCode);
	}

	public void enterCountry(String country) {
		countryField.sendKeys(country);
	}

	public void clickSubmit() {
		submitButton.click();
	}

	public void addNewContact(String firstName, String lastName, String birthdate, String email, String phone,
			String street1, String street2, String city, String stateProvince, String postalCode, String country) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		birthdateField.sendKeys(birthdate);
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
		street1Field.sendKeys(street1);
		street2Field.sendKeys(street2);
		cityField.sendKeys(city);
		stateProvinceField.sendKeys(stateProvince);
		postalCodeField.sendKeys(postalCode);
		countryField.sendKeys(country);
		submitButton.click();
	}
}