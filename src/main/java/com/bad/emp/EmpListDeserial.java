package com.bad.emp;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;


public class EmpListDeserial {
	
	@Test(priority=1)
	public void getEmpList()
	{
					
	    ObjectMapper objmap= new ObjectMapper();
		EmpPOJO[] emp =get("http://dummy.restapiexample.com/api/v1/employees").as(EmpPOJO[].class, ObjectMapperType.GSON);
		
		for(EmpPOJO temp:emp)
		{
			System.out.println(temp.getData());
		}
		
	}

}
