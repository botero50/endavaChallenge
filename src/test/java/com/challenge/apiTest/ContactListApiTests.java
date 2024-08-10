package com.challenge.apiTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.challenge.api.BaseApi;
import com.challenge.api.ContractApiCalls;
import com.challenge.dto.ContactDto;
import com.challenge.utils.DtoHelper;
import com.challenge.utils.RandomGenerator;

import io.restassured.response.Response;

public class ContactListApiTests extends BaseApi {
	ContractApiCalls contractApiCalls = new ContractApiCalls();

	@Test(description = "Test the creation of a contact and verify that the contact is created with correct details.")
	public void testCreationOfContacts() {
		ContactDto contactDTO = DtoHelper.createDtoFromJsonFile(ContactDto.class, "contactModel.json");
		contactDTO.firstName = RandomGenerator.generateFirstName();
		contactDTO.lastName = RandomGenerator.generateLastName();
		contactDTO.email = "%s%s@example.com".formatted(contactDTO.firstName, contactDTO.lastName).toLowerCase();
		contactDTO.phone = RandomGenerator.generateRandomNumber(10);
		contactDTO.postalCode = RandomGenerator.generateRandomNumber(5);
		
		Response response = contractApiCalls.createDefaultContact(contactDTO);

		assertNotNull(response.jsonPath().getString("_id"), "Contact ID should not be null.");
		assertEquals(response.jsonPath().getString("firstName"), contactDTO.firstName, "First name does not match.");
		assertEquals(response.jsonPath().getString("lastName"), contactDTO.lastName, "Last name does not match.");
		assertEquals(response.jsonPath().getString("email"), contactDTO.email, "Email does not match.");
	}

	@Test(description = "Test the creation of multiple contacts and verify that all the contacts are being created")
	public void testGetContactList() {
		ContactDto contactDTO = DtoHelper.createDtoFromJsonFile(ContactDto.class, "contactModel.json");	
		contractApiCalls.cleanupEnvironment();
		contractApiCalls.createDefaultContact(contactDTO);
		contractApiCalls.createDefaultContact(contactDTO);
		contractApiCalls.createDefaultContact(contactDTO);

		assertEquals(contractApiCalls.getContactIds().size(), 3,
				"Contacts are not fullfiling the assertion after expecting 3 contacts created on the page");
	}
}