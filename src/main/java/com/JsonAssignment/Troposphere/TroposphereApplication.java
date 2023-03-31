package com.JsonAssignment.Troposphere;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.JsonAssignment.Troposphere.Service.JsonLoader;

@SpringBootApplication
public class TroposphereApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(TroposphereApplication.class, args);

		//Retrieve an instance of JsonLoader service
		JsonLoader jsonLoader = context.getBean(JsonLoader.class);
		jsonLoader.loadTextFile("troposphere.txt");
	
		
		
	}

}