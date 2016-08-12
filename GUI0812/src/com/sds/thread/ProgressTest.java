package com.sds.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressTest extends JFrame{
	JProgressBar bar;
	JButton bt;
	Thread thread; 
	int n;
	
	public ProgressTest() {
		setLayout(new FlowLayout());
		bar = new JProgressBar();
		bt = new JButton("다운로드");
		thread = new Thread() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					fill();
				}
			}
		};
		bar.setPreferredSize(new Dimension(380, 50));
		bar.setBackground(Color.YELLOW);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		add(bt);
		add(bar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 150);
		setVisible(true);
	
	}
	
	public void fill(){
		n++;
		bar.setValue(n);
	}
	public static void main(String[] args) {
		new ProgressTest();
	}

}
