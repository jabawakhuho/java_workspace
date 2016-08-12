package com.huho.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas extends Canvas{
	Toolkit kit  = Toolkit.getDefaultToolkit();
	Image img;
	String path;
	int x=0;
	int y=0;
	
	public MyCanvas(String path,int x,int y) {
		this.path = path;
		this.x = x;
		this.y = y;
		img = kit.getImage(path);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, x, y, this);
	}
}
