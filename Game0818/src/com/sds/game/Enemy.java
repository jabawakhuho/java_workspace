package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Enemy extends GameObject{
	Image img;
	String[] imgPath = {"enermy1.png","enermy2.png","green_king.png","blue_king.png"};
	
	public Enemy(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		Random random = new Random();
		img=getImage(imgPath[random.nextInt(imgPath.length)].toString());
		//velX=-1;
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		
		rect.setBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		showRect(g);
		g.drawImage(img, x, y, width, height, null);
	}

}
