package com.sds.thread;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

public class MyThread extends JProgressBar{
	Thread thread;
	int n;
	
	public MyThread(int n,int t,Color color) {
		this.n = n;
		setPreferredSize(new Dimension(270, 70));
		setBackground(color);
		
		thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(t);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					fill();
				}
			}
			
		};
		
	}
	
	public void fill(){
		n++;
		setValue(n);
	}
}
