package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//paint 메서드를 재정의 하기윟 ㅐJPanel을 상속받는다.
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread; //게임 엔진
	boolean running=true;
	Ship ship;
	ObjectManager objectManager; //게임 객체 관리자
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		objectManager = new ObjectManager();
		createShip();
		createEnemy();
		createBlock();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		/*try {
			Image img =ImageIO.read(this.getClass().getClassLoader().getResource("background.png"));
			g.drawImage(img, 0, 0, WIDTH, HEIGHT, this);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//System.out.println("게임엔진 작동중!!!");
		//게임의 모든 객체를 작동!!!! tick(), render();
		for(int i=0; i< objectManager.objectList.size(); i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
		
	}
	//게임 시작(Thread 생성 및 시작)
	public void startGame(){
		if(gameThread !=null){
			return;
		}
		running = true;
		gameThread = new Thread(this);
		gameThread.start();//Runnable 영역
	}
	//게임멈춤(Thread 종료)
	public void pauseGame(){
		running=false;
		gameThread = null;
	}
	//게임 종료(프로세스 종료)
	public void exitGame(){
		System.exit(0); //0보다 작은수를 주면 빠져나간다는 뜻임
	}
	//ship 객체 생성 메서드
	public void createShip(){
		ship = new Ship(100,200,50,50,"ship",objectManager);
		objectManager.addObject(ship);
	}
	public void createEnemy(){
		for(int i=0; i < 7; i++){
			Random random = new Random();
			Enemy enemy= new Enemy(WIDTH-50, random.nextInt(HEIGHT), 30, 30, "enemy", objectManager);
			objectManager.addObject(enemy);
		}
	}
	//블럭 생성 메서드
	public void createBlock(){
		//윗블럭
		for(int i=0; i <20;i++){
			Block block = new Block(i*50, 0, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
		
		//아랫블럭
		for(int i=0; i <20;i++){
			Block block = new Block(i*50, HEIGHT-50, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
	}
	@Override
	public void run() {
		while(running){
			//try catch를 하는 이유는 다중 쓰레드 시 에러가 발생할수도 있기 때문에~
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint(); //-> updateUI() - > paint()
		}
	}
}
