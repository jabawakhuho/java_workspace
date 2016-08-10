package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfileApp extends JFrame implements ActionListener{
	JLabel src;
	Canvas profile;
	JButton bt;
	JPanel p;
	String path = "C:/java_workspace/GUI0810/res/pro.png";
	Toolkit kit;
	Image img;
	JFileChooser chooser;
	
	public ProfileApp() {
		src = new JLabel(path);
		bt = new JButton("파일탐색");
		p = new JPanel();
		kit= Toolkit.getDefaultToolkit();
		img= kit.getImage(path);
		
		profile = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 300,300,this);
			}
		};
		//FileChooser생성
		chooser = new JFileChooser("C:/java_workspace/GUI0810/res");
		//버튼과 리스너 연결
		bt.addActionListener(this);
		
		p.add(bt);
		p.add(src);
		
		profile.setPreferredSize(new Dimension(300,300));
		add(profile,BorderLayout.WEST);
		add(p);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 320);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		openFile();
	}
	//스윙에서도 파일탐색기가 지원된다!!!
	// 모든 탐색기는 JFileChooser를 사용한다.
	public void openFile(){
		int result =chooser.showOpenDialog(this);
		//System.out.println("당신의 선택은"+result);
		if(result == JFileChooser.APPROVE_OPTION){
			//지금선택한 이미지를 프로필 사진에 반영!!!
			File file =chooser.getSelectedFile();
			//System.out.println(file);
			path = file.getAbsolutePath();
			img=kit.getImage(path);
			//System.out.println(path);
			profile.repaint();
		}
		
	}
	public static void main(String[] args){
		new ProfileApp();
	}

}