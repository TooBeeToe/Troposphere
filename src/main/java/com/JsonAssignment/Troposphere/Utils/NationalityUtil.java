package com.JsonAssignment.Troposphere.Utils;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class NationalityUtil {
	
	Scanner scanner = new Scanner(System.in);

	public JsonObject getNationality(JsonObject json) {
		System.out.println("Please Enter the Nationality:");
		String nationality = scanner.nextLine();
		
		switch (nationality.toUpperCase()) {
		case "INDIAN","I":
			return json.get("INDIAN").getAsJsonObject();
			
		case "FOREIGN","F":
			return json.get("FOREIGN").getAsJsonObject();
			
		case "NRI","N":
			return json.get("NRI").getAsJsonObject();
			
		case "SAARC","S":
			return json.get("SAARC").getAsJsonObject();
		default :
			System.out.println(nationality + "  is invalid nationality.");
			return getNationality(json);
	}
	}

}
