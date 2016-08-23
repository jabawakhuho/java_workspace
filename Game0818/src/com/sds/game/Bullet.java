package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

public class Bullet extends GameObject{
	Image img;
	
	public Bullet(int x, int y, int width, int height, String name,ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		img=getImage("bullet.png");
		velX=5;
	}

	@Override
	public void tick() {
		x+=velX;
		rect.setBounds(x, y, width, height);
		//�Ѿ˰� ������� �浹 �˻�
		hitTest();
	}

	@Override
	public void render(Graphics g) {
		showRect(g);
		g.drawImage(img, x, y, width, height, null);
	}

	public void hitTest(){
		for(int  i=0; i< objectManager.objectList.size(); i++){
			GameObject obj =objectManager.objectList.get(i);
			if(obj.name.equals("enemy")){
				//������ ���� �浹�˻�
				boolean result = rect.intersects(obj.rect);
				//System.out.println("�¾�");
				if(result){
					objectManager.removeObject(this);
					objectManager.removeObject(obj);
				}
			}
		}
	}
}
