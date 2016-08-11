package com.sds.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThumnailGallery extends JFrame {
	JPanel p_left, p_right;
	Image currentImg; // 유저가 지금 선택한 썸네일의 이미지!!
	//ArrayList<MyCanvas> canArr;
	Toolkit kit;
	String path = "C:/java_workspace/GUI0811/res/";
	String[] file = { "C:/java_workspace/GUI0811/res/kei.jpg", "C:/java_workspace/GUI0811/res/1.jpg",
			"C:/java_workspace/GUI0811/res/2.jpg", "C:/java_workspace/GUI0811/res/3.jpg",
			"C:/java_workspace/GUI0811/res/4.jpg", "C:/java_workspace/GUI0811/res/5.jpg",
			"C:/java_workspace/GUI0811/res/6.jpg", "C:/java_workspace/GUI0811/res/7.jpg",
			"C:/java_workspace/GUI0811/res/8.jpg", "C:/java_workspace/GUI0811/res/9.jpg" };
	MyCanvas[] can= new MyCanvas[file.length];
	
	public ThumnailGallery() {
		
		p_left = new JPanel();
		for(int i=0; i<can.length;i++){
			can[i] = new MyCanvas(file[i],this);
			can[i].setPreferredSize(new Dimension(50, 50));
			p_left.add(can[i]);
		}
		currentImg = can[0].img;
		
		p_right = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(currentImg, 0, 0, 400, 500, this);
			}
		};
	
		//큰이미지 초기값 설정
		
		p_left.setBackground(Color.RED);
		p_left.setPreferredSize(new Dimension(200, 500));

		add(p_left, BorderLayout.WEST);
		add(p_right);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ThumnailGallery();
	}
}
