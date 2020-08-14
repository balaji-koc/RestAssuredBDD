package com.employee;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.Assert;
import io.restassured.http.ContentType;

public class GetEmpList {
	
	@Test(priority=1)
	
	
	public void getList()
	{
		Emp[] emp = get("https://jsonplaceholder.typicode.com/users").as(Emp[].class);
		
		for(Emp temp: emp)
		{
			System.out.println("Empname:"+temp.getName());
			System.out.println("Company:"+temp.getCompany().getName());
			System.out.println("Lat,log:"+temp.getAddress().getGeo().getLat()+", "+temp.getAddress().getGeo().getLng()+"\n");
		}
				
	}

}
