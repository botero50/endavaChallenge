package com.challenge.ui.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactListPage {

	private WebDriver driver;

	public ContactListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-contact")
	private WebElement addContactButton;

	@FindBy(id = "myTable")
	private WebElement MyTable;

	@FindBy(id = "add-contact")
	private WebElement addNewContactButton;

	private By table(String name) {
		return By.xpath("//table[@id='myTable']//tr[contains(@class, 'contactTableBodyRow')]/td[text()='" + name
				+ "']/parent::tr");
	}

	public void clickAddNewContact() {
		addNewContactButton.click();
	}

	public boolean doContactExistsInTheTable(String name) {
		return driver.findElements(table(name)).size() > 0;
	}

	public List<WebElement> getContactByName(String name) {
		WebElement row = driver.findElement(table(name));
		return row.findElements(By.tagName("td"));
	}

	public void assertContactIsPropertlyLoadedInTheGrid(String name, String expectedBirthdate, String expectedEmail,
			String expectedPhone, String expectedAddress, String expectedState, String expectedCountry) {
		List<WebElement> cells = getContactByName(name);
		assertEquals(cells.get(2).getText(), expectedBirthdate,
				"Actual birthdate: %s is not equal to the expected birth date: %s".formatted(cells.get(2).getText(),
						expectedBirthdate));
		assertEquals(cells.get(3).getText(), expectedEmail, "Actual email: %s is not equal to the expected email: %s"
				.formatted(cells.get(3).getText(), expectedEmail));
		assertEquals(cells.get(4).getText(), expectedPhone, "Actual phone: %s is not equal to the expected phone: %s"
				.formatted(cells.get(4).getText(), expectedPhone));
		assertEquals(cells.get(5).getText(), expectedAddress,
				"Actual address: %s is not equal to the expected address: %s".formatted(cells.get(5).getText(),
						expectedAddress));
		assertEquals(cells.get(6).getText(), expectedState, "Actual state: %s is not equal to the expected state: %s"
				.formatted(cells.get(6).getText(), expectedState));
		assertEquals(cells.get(7).getText(), expectedCountry,
				"Actual country: %s is not equal to the expected country: %s".formatted(cells.get(7).getText(),
						expectedCountry));
	}

	public void createNewContact(String name, String expectedBirthdate, String expectedEmail, String expectedPhone,
			String expectedAddress, String expectedState, String expectedCountry) {
		List<WebElement> cells = getContactByName(name);
		assertEquals(cells.get(2).getText(), expectedBirthdate,
				"Actual birthdate: %s is not equal to the expected birth date: %s".formatted(cells.get(2).getText(),
						expectedBirthdate));
		assertEquals(cells.get(3).getText(), expectedEmail, "Actual email: %s is not equal to the expected email: %s"
				.formatted(cells.get(3).getText(), expectedEmail));
		assertEquals(cells.get(4).getText(), expectedPhone, "Actual phone: %s is not equal to the expected phone: %s"
				.formatted(cells.get(4).getText(), expectedPhone));
		assertEquals(cells.get(5).getText(), expectedAddress,
				"Actual address: %s is not equal to the expected address: %s".formatted(cells.get(5).getText(),
						expectedAddress));
		assertEquals(cells.get(6).getText(), expectedState, "Actual state: %s is not equal to the expected state: %s"
				.formatted(cells.get(6).getText(), expectedState));
		assertEquals(cells.get(7).getText(), expectedCountry,
				"Actual country: %s is not equal to the expected country: %s".formatted(cells.get(7).getText(),
						expectedCountry));
	}

	public void selectElementInTheGrid(String name) {
		List<WebElement> cells = getContactByName(name);
		cells.get(1).click();
	}
}