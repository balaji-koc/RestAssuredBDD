package com.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class JsonObject {
	
	
	String uri= "http://dummy.restapiexample.com/api/v1";
	@Test()
     public void getData() 
	  {
		Response rsp= given()
		  .when().get(uri);
		  
		 JsonPath jp = rsp.jsonPath(); 	
		 
		System.out.println("Data is: "+ jp.get("id"));
		System.out.println("Response :" + rsp.asString());
		 
		 
		// Assert.assertEquals(actual, expected);
	   }
	}

