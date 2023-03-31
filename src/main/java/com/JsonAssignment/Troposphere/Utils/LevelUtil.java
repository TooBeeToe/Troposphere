package com.JsonAssignment.Troposphere.Utils;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class LevelUtil {
	
	Scanner scanner = new Scanner(System.in);

	public Integer selectLevel(JsonObject json) {
		System.out.println("Please Enter the Level:");
		String levelName = scanner.nextLine();
		
		switch (levelName.toUpperCase()) {
		case "UG":
			return json.get("UG").getAsJsonObject().get("amount").getAsInt();
		
		case "PG":
			return json.get("PG").getAsJsonObject().get("amount").getAsInt();
			
		case "DIPLOMA","D":
			return json.get("DIPLOMA").getAsJsonObject().get("amount").getAsInt();
		
		case "PH.D","PHD":
			return json.get("Ph.D").getAsJsonObject().get("amount").getAsInt();
		
		case "UG-DIPLOMA","UGD":
			return json.get("UG-DIPLOMA").getAsJsonObject().get("amount").getAsInt();
		default :
			System.out.println(levelName + "  is invalid level name.");
			return selectLevel(json);
	}
	}

}
