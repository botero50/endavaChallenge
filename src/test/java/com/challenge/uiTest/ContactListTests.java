package com.challenge.uiTest;

import org.testng.annotations.Test;

import com.challenge.api.ContractApiCalls;
import com.challenge.dto.ContactDto;
import com.challenge.ui.pages.AddNewContactPage;
import com.challenge.ui.pages.BaseTest;
import com.challenge.ui.pages.ContactListPage;
import com.challenge.ui.pages.LoginPage;
import com.challenge.utils.DtoHelper;
import com.challenge.utils.RandomGenerator;

public class ContactListTests extends BaseTest {
	ContractApiCalls contractApiCalls = new ContractApiCalls();

	@Test(description = "Testing if the user can create a contact in the UI")
	public void testContactCreationOnTheUi() {
		LoginPage loginPage = new LoginPage(driver);
		ContactListPage contactListPage = new ContactListPage(driver);
		AddNewContactPage addNewContactPage = new AddNewContactPage(driver);

		loginPage.login();
		contactListPage.clickAddNewContact();
		ContactDto contactDTO = DtoHelper.createDtoFromJsonFile(ContactDto.class, "contactModel.json");
		contactDTO.firstName = RandomGenerator.generateFirstName();
		contactDTO.lastName = RandomGenerator.generateLastName();
		contactDTO.email = "%s%s@example.com".formatted(contactDTO.firstName, contactDTO.lastName).toLowerCase();
		contactDTO.phone = RandomGenerator.generateRandomNumber(10);
		contactDTO.postalCode = RandomGenerator.generateRandomNumber(5);

		addNewContactPage.addNewContact(contactDTO.firstName, contactDTO.lastName, contactDTO.birthdate, contactDTO.email, 
				contactDTO.phone, contactDTO.street1, contactDTO.street2, contactDTO.city, contactDTO.stateProvince,
				contactDTO.postalCode, contactDTO.country);

		contactListPage.assertContactIsPropertlyLoadedInTheGrid("%s %s".formatted(contactDTO.firstName, contactDTO.lastName), contactDTO.birthdate, contactDTO.email,
				contactDTO.phone, "%s %s".formatted(contactDTO.street1, contactDTO.street2), "%s %s %s".formatted(contactDTO.city, contactDTO.stateProvince, contactDTO.postalCode), contactDTO.country);
	}
}