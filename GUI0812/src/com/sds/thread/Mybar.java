package com.sds.thread;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

public class Mybar extends JProgressBar implements Runnable{
	int interval;
	int n;
	
	public Mybar(int interval) {
		this.interval = interval;
		setPreferredSize(new Dimension(270, 70));
	}
	
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
			this.setValue(n);
		}
	}
	
}
