package com.practice;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class StudentAPITestWithSerialization {

	@Test(priority=1)
	public void createNewStudentSerialization()
	{
		ArrayList<String> coursesList=new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("selenium");
		
		StudentPOJO stu=new StudentPOJO();
		stu.setSID(101);
		stu.setFirstName("John");
		stu.setLastName("Deo");
		stu.setEmail("abc@gmail.com");
		stu.setProgramme("Computer science");
		stu.setCourses(coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat().body("msg",equalTo("Student added"));
	}
	
	@Test(priority=2)
	void getStudentRecordDeSerilization()
	{
		StudentPOJO stu= get("http://localhost:8085/student/101").as(StudentPOJO.class);
		System.out.println(stu.getStudentRecord());
		Assert.assertEquals(stu.getSID(), 101);
		
	}
	@Test(priority=3)
	void getStudentListDeSerilization()
	{
		StudentPOJO[] slist =get("http://localhost:8085/student/list").as(StudentPOJO[].class);
		
		 for(StudentPOJO temp: slist)
		 {
			 System.out.println(temp.getStudentRecord());
			 
		 }
		
		
	}
}
