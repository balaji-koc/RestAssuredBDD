package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBDD {
 
	String uri = "http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
	@Test()
     public void getData() {
	  {
		 given()
		  .when().get(uri)
		  .then()
		    .statusCode(200)
		    .header("Content-Type", "application/json")
		    .assertThat().body("City", equalTo("Hyderabad"));
		  
		
		  
	  }
  }
}
