/* 
 * 게임에 사용될 키보드 이벤트를 전담하여 처리하는 객체
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
	
	//reference를 이용한 Object 찾기
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
	
	//GameObject에 Key값(String name)을 이용한 Object 찾기
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
