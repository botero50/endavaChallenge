package com.challenge.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import com.challenge.dto.ContactDto;
import com.challenge.utils.DtoHelper;
import com.challenge.utils.RandomGenerator;

import io.restassured.response.Response;

public class ContractApiCalls extends BaseApi {

	public List<String> getContactIds() {
		String token = getBearerToken();
		Response response = given().header("Authorization", token).when().get("/contacts").then().statusCode(200)
				.extract().response();

		return response.jsonPath().getList("_id");
	}

	public void deleteContacts(List<String> contacts) {
		for (String contact : contacts) {
			deleteContact(contact);
		}
	}

	public void deleteContact(String contact) {
		String token = getBearerToken();
		Response response = given().header("Authorization", token).when().delete("/contacts/%s".formatted(contact))
				.then().statusCode(200).extract().response();

		assertEquals(response.getBody().asString(), "Contact deleted");
	}

	public Response createDefaultContact(ContactDto contact) {
		String token = getBearerToken();

		return given()
				.header("Authorization", token)
				.header("Content-Type", "application/json")
				.body(contact)
				.when()
				.post("/contacts")
				.then()
				.statusCode(201)
				.extract()
				.response();

	}
}
