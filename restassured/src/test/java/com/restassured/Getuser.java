package com.restassured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getuser {
	
	@Test
	public void getUsers() {
		RestAssured.baseURI = "http://127.0.0.1:5000";
		RequestSpecification requestSpecification = RestAssured.given();
		Response response = requestSpecification.request(Method.GET, "users");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

}
