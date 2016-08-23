package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

public class Ship extends GameObject{
	Image img;
	
	public Ship(int x, int y, int width, int height, String name,ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		//URL이란 자원의 위치를 의미한다. web => http://~  : 응용-->시스템내에서의 자원의 위치!!
		//Class class를 이용한 방법
		img = getImage("space.png");
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		//실시간 사각형rect의 위치를 변경(주인공의 위치와 맞게)
		rect.setBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		showRect(g);
		g.drawImage(img, x, y, width, height,null);
		//g.translate(x, y);
	}
	//총알발사
	public void fire(){
		Bullet bullet = new Bullet(x+width, y+(height/2), 10, 10, "bullet", objectManager);
		objectManager.addObject(bullet);
	}
}
