package com.challenge.e2eTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.challenge.api.ContractApiCalls;
import com.challenge.dto.ContactDto;
import com.challenge.ui.pages.BaseTest;
import com.challenge.ui.pages.ContactDetailsPage;
import com.challenge.ui.pages.ContactListPage;
import com.challenge.ui.pages.LoginPage;
import com.challenge.utils.DtoHelper;

import io.restassured.response.Response;

public class ContactListE2ETests extends BaseTest {
	ContractApiCalls contractApiCalls = new ContractApiCalls();

	@Test(description = "Testing an E2E testcase where the UI and API are involved and based on creation and deletion of contacts")
	public void TestContacListAddedInTheBackEndIsLoadedInTheFrontEnd() {
		LoginPage loginPage = new LoginPage(driver);
		ContactListPage contactListPage = new ContactListPage(driver);
		ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);

		/// Cleaning up the data in the database and Creating new contact using the API
		contractApiCalls.cleanupEnvironment();
		ContactDto contactDTO = DtoHelper.createDtoFromJsonFile(ContactDto.class, "contactModel.json");	
		Response response = contractApiCalls.createDefaultContact(contactDTO);

		String name = "%s %s".formatted(response.jsonPath().getString("firstName"),
				response.jsonPath().getString("lastName"));
		String birthdate = response.jsonPath().getString("birthdate");
		String email = response.jsonPath().getString("email");
		String phone = response.jsonPath().getString("phone");
		String address = "%s %s".formatted(response.jsonPath().getString("street1"),
				response.jsonPath().getString("street2"));
		String state = "%s %s %s".formatted(response.jsonPath().getString("city"),
				response.jsonPath().getString("stateProvince"), response.jsonPath().getString("postalCode"));
		String country = response.jsonPath().getString("country");

		loginPage.login();
		/// Checking if the contact I created in the API is present in the UI
		contactListPage.assertContactIsPropertlyLoadedInTheGrid(name, birthdate, email, phone, address, state, country);
		contactListPage.selectElementInTheGrid(name);

		/// Deleting the contact using the UI
		contactDetailsPage.clickDeleteContactButton();
		contactDetailsPage.acceptDeletePopup();

		/// Checking if the contact was removed from the UI and API
		assertFalse(contactListPage.doContactExistsInTheTable(name),
				"Contact were not deleted after click on delete button");
		assertTrue(contractApiCalls.getContactIds().size() == 0, "Contact is still present in the Contacts API");
	}
}