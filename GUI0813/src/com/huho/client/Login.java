package com.huho.client;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONArray;

import com.huho.json.*;

public class Login extends JFrame{
	JLabel login;
	JLabel id;
	JLabel pwd;
	JTextField t_id;
	JTextField t_pwd;
	JButton bt_login;
	JButton bt_sign;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	ThumnailMove tm;
	String[] arr;
	private int loginCount=0;
	
	public Login(ThumnailMove tm) {
		super("LoginTest");
		this.tm = tm;
		setLayout(new GridLayout(3, 1));
		
		login = new JLabel("로그인");
		id = new JLabel("ID");
		pwd = new JLabel("password");
		t_id = new JTextField(15);
		t_pwd = new JTextField(15);
		bt_login= new JButton("login");
		bt_sign=new JButton("sign");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		bt_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginTest(t_id.getText(),t_pwd.getText());
			}
		});
		p1.add(login);
		
		GridLayout grid1 = new GridLayout(2, 4);
		GridLayout grid2 = new GridLayout(1, 4);
		grid1.setVgap(10);
		
		p2.setLayout(grid1);
		p2.add(new JLabel());
		p2.add(id);
		p2.add(t_id);
		p2.add(new JLabel());
		p2.add(new JLabel());
		p2.add(pwd);
		p2.add(t_pwd);
		p2.add(new JLabel());
		
		p3.setLayout(grid2);
		p3.add(new JLabel());
		p3.add(bt_login);
		p3.add(bt_sign);
		p3.add(new JLabel());
		
		add(p1);
		add(p2);
		add(p3);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 100, 300, 200);
		//setSize(300,200);
		setVisible(true);
		
	}
	
	public void loginTest(String id, String pwd){
		boolean test = false;
		String path="C:/java_workspace/GUI0813/res/member/member.json";
		File file = new File(path);
		jsonLogin jsonMem = new jsonLogin(file);
		
		System.out.println(id+","+pwd);
		for(int i=0; i < jsonMem.memList.size() ; i++){
			System.out.println(jsonMem.memList.get(i)[0].toString());
			if(id.equals(jsonMem.memList.get(i)[0].toString())){
				test = true;
				if(pwd.equals(jsonMem.memList.get(i)[1].toString())){
					arr = jsonMem.memList.get(i);
					loginCount =i;
					JOptionPane.showMessageDialog(this, "안녕하세요"+jsonMem.memList.get(i)[0]+"님");
					
				}else{
					System.out.println("비밀번호가 틀렸습니다.");
				}
				break;
			}
		}
		if(test){
			tm.p_north.removeAll();
			JPanel p1 = new JPanel();
			p1.setLayout(null);
			p1.setPreferredSize(new Dimension(460, 50));
			JLabel name = new JLabel(arr[2]+"님");
			JLabel mileage = new JLabel("마일리지: "+arr[6]);
			name.setBounds(200, 10, 70, 30);
			mileage.setBounds(300, 10, 100, 30);
			p1.add(name);
			p1.add(mileage);
			tm.p_north.add(p1);
			tm.p_north.updateUI();
		}else{
			System.out.println("해당 아이디가 없습니다.");
		}
		
	}
}
