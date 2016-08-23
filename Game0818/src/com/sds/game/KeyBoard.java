package com.sds.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoard extends KeyAdapter{
	ObjectManager objectManager;
	
	public KeyBoard(ObjectManager objectManager) {
		this.objectManager = objectManager;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		setVelXY(key,"ship", 2, 2);
		shooting(key,"ship");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		setVelXY(key,"ship",0,0);
	}
	
	public void setVelXY(int key,String name,int velX,int velY){
		for(int i=0; i < objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			if(obj.name.equals(name)){
				switch(key){
					case KeyEvent.VK_LEFT : 	obj.velX= -velX;break;
					case KeyEvent.VK_UP : 		obj.velY= -velY;break;
					case KeyEvent.VK_RIGHT : obj.velX= velX;break;
					case KeyEvent.VK_DOWN : obj.velY= velY;break;
				}
			}
		}
	}
	
	public void shooting(int key,String name){
		for(int i=0; i < objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			if(obj.name.equals(name)){
				switch(key){
				case KeyEvent.VK_SPACE : ((Ship)obj).fire();break;
				}
			}
		}
	}
}
