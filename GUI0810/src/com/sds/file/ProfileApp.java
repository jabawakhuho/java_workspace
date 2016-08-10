package com.sds.collection;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfileApp extends JFrame{
	JLabel src;
	Canvas profile;
	JButton bt;
	JPanel p;
	
	public ProfileApp() {
		src = new JLabel("123");
		bt = new JButton();
		p = new JPanel();
		profile = new Canvas() {
			Toolkit kit = Toolkit.getDefaultToolkit();
			Image img;
			String path= "C:/java_workspace/GUI0810/res/pro.png";
			
			img = kit.getImage(path);
			
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this);
			}
		};
		
		p.add(bt);
		p.add(src);
		
		profile.setPreferredSize(new Dimension(300,300));
		add(profile);
		add(p);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new ProfileApp();
	}
}