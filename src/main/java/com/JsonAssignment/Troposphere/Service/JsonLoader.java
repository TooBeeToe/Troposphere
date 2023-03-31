package com.JsonAssignment.Troposphere.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class JsonLoader {
	
	@Autowired
	JsonHandler jsonHandler;
	
	// Load the text file
	public void loadTextFile(String fileName) throws IOException {
		
    File file = new File("src/main/resources/"+fileName);
    String textFile = new String(Files.readAllBytes(Paths.get(file.toURI())));
    
    // Parse the text into a JSON object
    JsonObject json = JsonParser.parseString(textFile).getAsJsonObject();
    
    // Passing the JSON to JsonHandler for further processing
    jsonHandler.processJson(json);

	}

   
}
