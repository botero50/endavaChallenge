package com.challenge.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.challenge.utils.Config;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseApi {

	@BeforeMethod
	public void setUp() {
		cleanupEnvironment();
	}

	public void cleanupEnvironment() {
		ContractApiCalls contracctApiCalls = new ContractApiCalls();
		contracctApiCalls.deleteContacts(contracctApiCalls.getContactIds());
	}

	public String getBearerToken() {
		RestAssured.baseURI = Config.get("baseUrl");
		String requestBody = "{\"email\": \"testUser@testUser2.com\",\"password\": \"testUser\"}";

		Response response = given().header("Content-Type", "application/json").body(requestBody).when()
				.post("/users/login").then().statusCode(200).extract().response();

		return String.format("Bearer %s", response.jsonPath().getString("token"));
	}

	@AfterMethod
	public void tearDown() {
		cleanupEnvironment();
	}
}
