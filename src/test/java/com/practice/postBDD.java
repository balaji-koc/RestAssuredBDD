package com.practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class postBDD {
	
	String baseURI = "http://localhost:8085/";
	
    HashMap jobj= new HashMap();
    
    @BeforeClass
    public void init()
    {
    	jobj.put("id", 101);
		jobj.put("firstName","Keerthi");
		jobj.put("lastName","koc");
		jobj.put("email", "keerthi.Koc@gmail.com");
		jobj.put("programme", "CM");
    }
    
	
  @Test(priority=1)
  public void postData() {
	  
	  given()
	    .contentType("application/json")
	    .body(jobj)
	    
	 .when().post(baseURI.concat("student"))
	 .then().statusCode(201); 
  }
  
  @Test(priority=2)
  public void getData()
  {
	  given()
	  .when().get(baseURI.concat("student/list"))
	  .then()
	    .body("lastName", hasItems("Brenden","koc"));
	  
  }
  
}
