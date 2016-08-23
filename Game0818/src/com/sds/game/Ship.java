package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

public class Ship extends GameObject{
	Image img;
	
	public Ship(int x, int y, int width, int height, String name,ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		//URL�̶� �ڿ��� ��ġ�� �ǹ��Ѵ�. web => http://~  : ����-->�ý��۳������� �ڿ��� ��ġ!!
		//Class class�� �̿��� ���
		img = getImage("space.png");
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		//�ǽð� �簢��rect�� ��ġ�� ����(���ΰ��� ��ġ�� �°�)
		rect.setBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		showRect(g);
		g.drawImage(img, x, y, width, height,null);
		//g.translate(x, y);
	}
	//�Ѿ˹߻�
	public void fire(){
		Bullet bullet = new Bullet(x+width, y+(height/2), 10, 10, "bullet", objectManager);
		objectManager.addObject(bullet);
	}
}
