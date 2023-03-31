package com.JsonAssignment.Troposphere.Utils;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class FeeTypeUtil {
	
	Scanner scanner = new Scanner(System.in);

	public JsonObject getFeeType(JsonObject json) {
		System.out.println("Please Enter the fee type (E/A):");
		String feeType = scanner.nextLine();
		
		switch (feeType.toUpperCase()) {
		case "E":
			return json.get("Exam Fee").getAsJsonObject();
			
		case "A":
			return json.get("Application Fee").getAsJsonObject();
		default :
			System.out.println(feeType + "  is invalid fee type.");
			return getFeeType(json);
	}
	}

}
