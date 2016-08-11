package com.sds.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProfileApp {
	FileReader reader;//������ ��������� �Է½�Ʈ��
	BufferedReader buffr;
	ArrayList<String[]> list;
	String path="C:/java_workspace/GUI0811/res/member.json";

	public ProfileApp(String path) {
		this.path = path;
		list = new ArrayList<String[]>();
		try {
			reader = new FileReader(this.path);
			buffr = new BufferedReader(reader);
			
			String data =null;
			StringBuffer sb = new StringBuffer();
			while((data= buffr.readLine())!=null){
				//System.out.println(data);
				sb.append(data); //sb�� ����!!!!
			}
			System.out.println(sb.toString());
			//�Ľ� ����
			JSONParser jsonParser=new JSONParser();
			JSONObject jsonObject=(JSONObject)jsonParser.parse(sb.toString());
			
			JSONArray jsonArray = (JSONArray)jsonObject.get("members");
			
			//System.out.println(jsonArray.size());
			for(int i =0; i < jsonArray.size();i++){
				//System.out.println(jsonArray.get(i));
				JSONObject member = (JSONObject)jsonArray.get(i);
				//System.out.println(member.get("name")+","+member.get("gender")+","+member.get("age")+","+member.get("photo"));
				//JSON�� ���� ������ 2�� �迭�� ���
				String[] memArr = {member.get("name").toString(),member.get("gender").toString(),member.get("age").toString(),member.get("photo").toString()};
				list.add(memArr);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			System.out.println("json ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
		}finally{
			if(buffr!=null){
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	


}
