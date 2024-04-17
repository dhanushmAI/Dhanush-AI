package com.restassured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostUsers {

	@Test
	public void postUsers() {

		RestAssured.baseURI = "http://192.168.20.199:5000/";
		RequestSpecification requestSpecification = RestAssured.given().
				header("Content-Type", "application/json")
				.body("{\r\n" + "	\"username\":\"Dhanush\",\r\n"
							  + "	\"id\":\"1\",\r\n"
							  + "	\"email\":\"dhanush@gmail.com\"\r\n" + "}");
		Response response = requestSpecification.request(Method.POST, "users");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}
}
