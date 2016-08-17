/* 
 * ���ӿ� ���� Ű���� �̺�Ʈ�� �����Ͽ� ó���ϴ� ��ü
 * */

package com.sds.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	ObjectManager objectManager;
	Hero hero;
	
	
	public KeyBoard(ObjectManager objectManager,Hero hero) {
		this.objectManager = objectManager;
		this.hero = hero;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
	/*	setObjectVelXY(hero,key,10,10);*/
		setObjectStringVelXY("hero",key,10,10);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		/*setObjectVelXY(hero,key,0,0);*/
		setObjectStringVelXY("hero",key,0,0);
	}
	
	//reference�� �̿��� Object ã��
	public void setObjectVelXY(GameObject gameObject,int key,int velX,int velY){
		for(int i=0;i< objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			if(obj == gameObject){
				switch(key){
					case KeyEvent.VK_LEFT : obj.velX=-velX; break;
					case KeyEvent.VK_UP : obj.velY=-velY; break;
					case KeyEvent.VK_RIGHT : obj.velX=velX; break;
					case KeyEvent.VK_DOWN : obj.velY=velY; break;
					case KeyEvent.VK_SPACE : ; break;
				}
			}
		}
	}
	
	//GameObject�� Key��(String name)�� �̿��� Object ã��
	public void setObjectStringVelXY(String name,int key,int velX,int velY){
		for(int i=0;i< objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			if(obj.name.equals(name) ){
				switch(key){
					case KeyEvent.VK_LEFT : obj.velX=-velX; break;
					case KeyEvent.VK_UP : obj.velY=-velY; break;
					case KeyEvent.VK_RIGHT : obj.velX=velX; break;
					case KeyEvent.VK_DOWN : obj.velY=velY; break;
					case KeyEvent.VK_SPACE : ; break;
				}
			}
		}
	}

}
