/*
 * 게임의 stage로써 실제적으로 모든 그래픽이 처리되는 영역!!!
 * */
package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread; //게임의 심장부
	boolean flag=true;
	//오브젝트 메니져!
	ObjectManager objectManager;
	//주인공 선언
	Hero hero;
	
	
	//적군들 선언
	Enemy[] enemy= new Enemy[5];
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		objectManager= new ObjectManager();
		createHero();//주인공 생성
		createEnemy();//적군생성
	}
	//주인공 등장 메서드 정의
	public void createHero(){
		hero = new Hero(100,200,50,50,"hero");
		objectManager.addObject(hero);
	}
	//적군등장 메서드 정의!!
	public void createEnemy(){
		for(int i=0; i < enemy.length; i++){
			enemy[i] = new Enemy(600,i*100,30,30,"enemy"+i);
			objectManager.addObject(enemy[i]);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		//모든 게임오브젝트들이 들어있는 명단을 이용하여
		//모든 게임오브젝트의 tick과 render 호출하게 하자!
		for(int i=0;i<objectManager.objectList.size() ; i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick();
			obj.render(g,this);
		}
	}
	
	//게임 시작 메서드
	public void startGame(){
		if(gameThread!=null){//이미 가동중이라면...
			return;
		}
		gameThread = new Thread(this);
		flag = true;
		gameThread.start();
	}
	//일시 정지 메서드
	public void pauseGame(){
		flag=false;
		gameThread = null;
	}
	//게임종료 메서드
	public void exitGame(){
		System.exit(-1);
	}
	
	//Runnable의 run 메서드 재정의
	@Override
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("게임 엔진 작동중");
			repaint();//update()-> paint();
		}
	}
	
}
