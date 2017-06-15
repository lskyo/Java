package com.lskyo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WriteJson {

	public static void main(String[] args) {
		JsonObject object = new JsonObject();
		object.addProperty("cat", "it");
		
		JsonArray array = new JsonArray();
		
		JsonObject sub1 = new JsonObject();
		sub1.addProperty("id", 1);
		sub1.addProperty("name", "java");
		sub1.addProperty("ide", "Eclipse");
		array.add(sub1);
		
		JsonObject sub2 = new JsonObject();
		sub2.addProperty("id", 2);
		sub2.addProperty("name", "Swift");
		sub2.addProperty("ide", "XCode");
		array.add(sub2);
		
		JsonObject sub3 = new JsonObject();
		sub3.addProperty("id", 3);
		sub3.addProperty("name", "C#");
		sub3.addProperty("ide", "Visual Studio");
		array.add(sub3);
		
		object.add("language", array);
		object.addProperty("pop", true);
		
		
		System.out.println(object.toString());
	}

}
