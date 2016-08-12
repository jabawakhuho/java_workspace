package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnimationApp extends JFrame{
	JButton bt;
	Canvas can;
	String path = "C:/java_workspace/GUI0812/res/bullet.png";
	Toolkit kit= Toolkit.getDefaultToolkit();
	Image img;
	int x=0;
	Thread thread;
	
	public AnimationApp() {
		bt = new JButton("총알");
		img = kit.getImage(path);
		
		can =new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, x, 0, 50, 50, this);
			}
		};
		//쓰레드 생성
		thread = new Thread() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					bulletX();
				}
			}
		};
		
		can.setPreferredSize(new Dimension(900, 750));
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		add(bt,BorderLayout.NORTH);
		add(can);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,800);
		setVisible(true);
	}
	//총알의 X축 이동
	public void bulletX(){
		x +=10;
		can.repaint();
	}
	public static void main(String[] args) {
		new AnimationApp();
	}

}
