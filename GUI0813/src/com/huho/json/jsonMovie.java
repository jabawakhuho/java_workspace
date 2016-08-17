package com.huho.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonMovie {
	FileReader reader;
	BufferedReader buffr;
	String data;
	StringBuffer sb;
	public ArrayList<String[]> movieList;
	
	public jsonMovie(File file) {
		movieList = new ArrayList<String[]>();
		sb = new StringBuffer();
		try {
			reader = new FileReader(file);
			buffr = new BufferedReader(reader);
			while((data =buffr.readLine())!=null){
				sb.append(data);
			}
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(sb.toString());
			JSONArray jsonArr = (JSONArray)jsonObj.get("movie");
			for(int i=0; i < jsonArr.size() ; i++){
				jsonObj=(JSONObject)jsonParser.parse(jsonArr.get(i).toString());
				String[] arr = { jsonObj.get("name").toString(),
						jsonObj.get("artor").toString(),
						jsonObj.get("type").toString(),
						jsonObj.get("grade").toString(),
						jsonObj.get("story").toString(),
						jsonObj.get("path").toString()};
				movieList.add(arr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally{
			if(buffr != null){
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
