package com.JsonAssignment.Troposphere.Utils;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class AllCoursesUtil {

	public JsonObject setAllCourses(JsonObject json) {
		
		var newJson = json.deepCopy();

		if (newJson.has("ALL_COURSES")) {
			var allCoursesContent = newJson.get("ALL_COURSES").getAsJsonObject();

			newJson.add("Medical", allCoursesContent);
			newJson.add("Dental", allCoursesContent);
			newJson.add("Ayurveda", allCoursesContent);

			newJson.remove("ALL_COURSES");

		}

		return newJson;
	}

}
