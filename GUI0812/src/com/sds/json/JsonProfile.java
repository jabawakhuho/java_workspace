package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonProfile extends JFrame {
	JButton bt;
	JPanel p_west;
	JPanel p_center;
	JScrollPane scroll;
	JFileChooser chooser;
	FileReader reader;
	BufferedReader buffr;
	StringBuffer sb;
	public JsonProfile() {
		bt = new JButton("열기");
		p_west = new JPanel();
		p_center = new JPanel();
		scroll = new JScrollPane(p_center);
		chooser = new JFileChooser("C:/java_workspace/GUI0812/res");
		// 왼쪽 패널에 버튼 부착후 패널을 서쪽에 부착
		p_west.add(bt);
		add(p_west, BorderLayout.WEST);
		p_west.setBackground(Color.GREEN);

		// 센터에 스크롤 부착
		add(scroll);
		p_center.setBackground(Color.WHITE);
		p_center.setPreferredSize(new Dimension(700, 600));
		// 버튼 이미지
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}

		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}

	public void openFile() {
		if ((chooser.showOpenDialog(this)) == JFileChooser.APPROVE_OPTION) {
			// 제이슨 열기
			File file = chooser.getSelectedFile();
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				String data;
				sb = new StringBuffer();
				while ((data = buffr.readLine()) != null) {
					sb.append(data);
				}
				//System.out.println(sb);
				createProfile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
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
			// json file 읽어서 파싱하자
		}
	}

	// 데이터 수에 따라 Profile 인스턴스 생성메서드 작성
	public void createProfile() {
		//파싱 시작
		JSONParser jsonparser = new JSONParser();
		try {
			JSONObject jsonObject= (JSONObject)jsonparser.parse(sb.toString());
			JSONArray jsonArray = (JSONArray)jsonObject.get("member");

			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject member = (JSONObject)jsonArray.get(i);
				String name = (String)member.get("name");
				String gender = (String)member.get("gender");
				String age = (String)member.get("age");
				String path = (String)member.get("path");
				Profile profile = new Profile(path);
				profile.la_name.setText("이름 : "+name);
				profile.la_gender.setText("성별 : "+gender);
				profile.la_age.setText("나이 : "+age);
				p_center.add(profile);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		p_center.updateUI();
	}

	public static void main(String[] args) {
		new JsonProfile();
	}

}
