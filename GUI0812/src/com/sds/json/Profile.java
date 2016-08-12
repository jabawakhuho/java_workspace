package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JPanel{
	JPanel p_west; //켄버스를 포함할 패널
	JPanel p_center;
	Toolkit kit;
	Image img;
	Canvas can;
	JLabel la_name,la_gender,la_age;
	
	public Profile(String url) {
		p_west = new JPanel();
		p_center = new JPanel();
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(url);
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 100, 100, this);
			}
		};
		la_name = new JLabel("이름");
		la_gender = new JLabel("성별");
		la_age = new JLabel("나이");
		
		setLayout(new BorderLayout());
		//켄버스의 크기 설정
		can.setPreferredSize(new Dimension(100, 100));
		can.setBackground(Color.BLACK);
		//p_west에 켄버스 부착하고 West영역에 부착
		p_west.setPreferredSize(new Dimension(120, 120));
		p_west.add(can);
		add(p_west,BorderLayout.WEST);
		
		//p_center panel에 gridlayout 적용
		p_center.setLayout(new GridLayout(3, 1));
		p_center.add(la_name);
		p_center.add(la_gender);
		p_center.add(la_age);
		//Center에 p_center panel부착
		add(p_center);
		p_center.setBackground(Color.cyan);
		
		//profile 자신의 크기 지정
		setPreferredSize(new Dimension(700, 120));
	}
}
