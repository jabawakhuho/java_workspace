package com.huho.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class ProfileApp extends JFrame{
	JPanel p_left;
	JPanel p_right;
	JButton bt;
	JScrollPane scroll;
	JFileChooser chooser;
	JsionArr json;
	
	public ProfileApp() {
		super("Json Test");
		p_left = new JPanel();
		p_right = new JPanel();
		bt = new JButton("열기");
		scroll = new JScrollPane(p_right);
		chooser = new JFileChooser("C:/java_workspace/GUI0811/res");
		//버튼에 이벤트 달기
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectFile();
				
			}
		});
		
		p_left.add(bt);
		p_left.setBackground(Color.GREEN);
		add(p_left,BorderLayout.WEST);
		add(scroll);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 600);
		setVisible(true);
	}
	
	public void selectFile(){
		int result =chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			json = new JsionArr(file); 
			int height =(json.list.size()*250);
			p_right.setPreferredSize(new Dimension(320, height));
			for(int i=0; i < json.list.size() ; i++){
				createProfile(i);
			}
		}
	}
	
	public void createProfile(int i){
		JPanel profile = new JPanel();
		JPanel pro_right = new JPanel();
		
		JLabel name = new JLabel("이름 : "+json.list.get(i)[0]);
		JLabel gender = new JLabel("성별 : "+json.list.get(i)[1]);
		JLabel age = new JLabel("나이 : "+json.list.get(i)[2]);
		MyCanvas can = new MyCanvas(json.list.get(i)[3],200,200);
		
		pro_right.setLayout(new GridLayout(3, 1));
		pro_right.setBackground(Color.WHITE);
		pro_right.add(name);
		pro_right.add(gender);
		pro_right.add(age);
		
		can.setPreferredSize(new Dimension(200, 200));
		profile.setLayout(new BorderLayout());
		profile.setPreferredSize(new Dimension(300,200));
		profile.add(can, BorderLayout.WEST);
		profile.add(pro_right);
				
		p_right.add(profile);
		scroll.updateUI();
	}
	
	public static void main(String[] args) {
		new ProfileApp();
	}

}
