package com.JsonAssignment.Troposphere.Utils;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class CoursesUtil {
	
	Scanner scanner = new Scanner(System.in);

	public JsonObject selectCourse(JsonObject json) {
		System.out.println("Please Enter the course name:");
		String courseName = scanner.nextLine();
		
		switch (courseName.toUpperCase()) {
		case "Medical","M":
			return json.get("Medical").getAsJsonObject();
		
		case "Dental","D":
			return json.get("Dental").getAsJsonObject();
			
		case "Ayurveda","A":
			return json.get("Ayurveda").getAsJsonObject();
		default :
			System.out.println(courseName + "  is invalid course name.");
			return selectCourse(json);
	}
	}

}
