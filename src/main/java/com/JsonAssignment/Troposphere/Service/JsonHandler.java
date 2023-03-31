package com.JsonAssignment.Troposphere.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JsonAssignment.Troposphere.Utils.AllCoursesUtil;
import com.JsonAssignment.Troposphere.Utils.AllLevelUtil;
import com.JsonAssignment.Troposphere.Utils.CoursesUtil;
import com.JsonAssignment.Troposphere.Utils.FeeTypeUtil;
import com.JsonAssignment.Troposphere.Utils.LevelUtil;
import com.JsonAssignment.Troposphere.Utils.NationalityUtil;
import com.google.gson.JsonObject;

@Service
public class JsonHandler {
	
	@Autowired
	FeeTypeUtil feeTypeUtil;
	@Autowired
	NationalityUtil nationalityUtil;
	@Autowired
	AllCoursesUtil allCoursesUtil;
	@Autowired
	CoursesUtil coursesUtil;
	@Autowired
	AllLevelUtil allLevelUtil;
	@Autowired
	LevelUtil levelUtil;

	public void processJson(JsonObject json) {

		//Select Fee Type
		System.out.println("Select Fee Type :");

		for (String key : json.keySet()) {
			System.out.println(key);
		}

		var feeTypeJson = feeTypeUtil.getFeeType(json);
		
		//Select Nationality
		System.out.println("Select Nationality :");
		for (String key : feeTypeJson.keySet()) {
			System.out.println(key);
		}
		
		var nationalityJson = nationalityUtil.getNationality(feeTypeJson);
		
		System.out.println("Before 'ALL_COURSES' substitution");
		System.out.println(nationalityJson);
		
		//ALL_COURSES substitution with Medical, Dental and Ayurveda
		var allCoursesSubstitutionJson = allCoursesUtil.setAllCourses(nationalityJson);
		
		System.out.println("After 'ALL_COURSES' substitution");
		System.out.println(allCoursesSubstitutionJson);
		
		//Select Course
		System.out.println("Select Course :");
		for (String key : allCoursesSubstitutionJson.keySet()) {
			System.out.println(key);
		}
		
		var courseJson = coursesUtil.selectCourse(allCoursesSubstitutionJson);
		
		//Check if selected course has 'ALL_LEVEL' field
		if(courseJson.has("ALL_LEVEL")) {
			
			System.out.println("Before 'ALL_LEVEL' substitution");
			System.out.println(courseJson);
			
			//ALL_LEVEL substitution with  UG, PG, DIPLOMA, Ph.D
			var allLevelSubstitutionJson = allLevelUtil.setAllLevel(courseJson);
			
			System.out.println("After 'ALL_LEVEL' substitution");
			System.out.println(allLevelSubstitutionJson);
			
			//Select Level
			System.out.println("Select Level :");
			for (String key : allLevelSubstitutionJson.keySet()) {
				System.out.println(key);
			}
			//get the fee amount for selected level
			var amount = levelUtil.selectLevel(allLevelSubstitutionJson);
			System.out.println("fee amount for the selected fee type, nationality, course and level is : "+amount);
		}else {
			
			//Select Level
			System.out.println("Select Level :");
			for (String key : courseJson.keySet()) {
				System.out.println(key);
			}
			//get the fee amount for selected level
			var amount = levelUtil.selectLevel(courseJson);
			System.out.println("fee amount for the selected fee type, nationality, course and level is : "+amount);
		}
		
	}

}
