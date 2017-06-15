package com.lskyo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJson {

	public static void main(String[] args) {
		try {
			
			
			
			JsonParser parser = new JsonParser();
			JsonObject object = (JsonObject) parser.parse(new FileReader(new File("test.json")));
			System.out.println("cat=" + object.get("cat").getAsString());
			System.out.println("pop=" + object.get("pop").getAsBoolean());
		
			JsonArray array = object.get("language").getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				System.out.println("--------------------------");
				JsonObject subObject = array.get(i).getAsJsonObject();
				System.out.println("id=" + subObject.get("id").getAsInt());
				System.out.println("name=" + subObject.get("name").getAsString());
				System.out.println("ide=" + subObject.get("ide").getAsString());
			}
		
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
