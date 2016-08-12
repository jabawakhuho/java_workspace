package com.huho.gui;

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

public class JsionArr {
	FileReader reader;
	BufferedReader buffr;
	String data;
	StringBuffer sb;
	ArrayList<String[]> list;

	public JsionArr(File file) {
	//public JsionArr(String file) {
		list = new ArrayList<String[]>();
		sb = new StringBuffer();
		try {
			reader = new FileReader(file);
			buffr = new BufferedReader(reader);
			while ((data = buffr.readLine()) != null) {
				// System.out.println(data);
				sb.append(data);
			}
			// System.out.println(sb);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
			JSONArray jsonArr = (JSONArray) jsonObject.get("member");
			// System.out.println(jsonArr.size());
			for (int i = 0; i < jsonArr.size(); i++) {
				// System.out.println(jsonArr.get(0));
				jsonObject = (JSONObject) jsonParser.parse(jsonArr.get(i).toString());
				String[] dataArr = { jsonObject.get("name").toString(),
						jsonObject.get("gender").toString(),
						jsonObject.get("age").toString(),
						jsonObject.get("path").toString()
				};
				list.add(dataArr);
				System.out.println(list);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (buffr != null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*public static void main(String[] args) {
		new JsionArr("C:/java_workspace/workspace/GUI0811/res/member.json");
	}*/
}
