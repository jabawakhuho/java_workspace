package test;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfileApp extends JFrame{
	Canvas can;
	JPanel p_center;
	JButton bt;
	JLabel la_path;
	Toolkit kit;
	Image img;
	
	
	public ProfileApp() {
		kit= Toolkit.getDefaultToolkit();
		img=kit.getImage("C:/java_workspace/GUI0810/res/pro.png");
		
		can=new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 300, 280, this);
			}			
		};
		can.setPreferredSize(new Dimension(300,280));
		
		p_center = new JPanel();
		p_center.setBackground(Color.WHITE);
		bt = new JButton("ÆÄÀÏÅ½»ö");
		la_path = new JLabel();
		la_path.setPreferredSize(new Dimension(250, 40));
		
		p_center.add(bt);
		p_center.add(la_path);
		add(can, BorderLayout.WEST);
		add(p_center);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ProfileApp();
	}

}
