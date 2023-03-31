package com.JsonAssignment.Troposphere.Utils;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class AllLevelUtil {

	public JsonObject setAllLevel(JsonObject json) {
		
		var newJson = json.deepCopy();

		if (newJson.has("ALL_LEVEL")) {
			var allLevelContent = newJson.get("ALL_LEVEL").getAsJsonObject();

			newJson.add("UG", allLevelContent);
			newJson.add("PG", allLevelContent);
			newJson.add("DIPLOMA", allLevelContent);
			newJson.add("Ph.D", allLevelContent);

			newJson.remove("ALL_LEVEL");

		}

		return newJson;
	}

}
