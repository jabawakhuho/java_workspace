/*
 * ������ stage�ν� ���������� ��� �׷����� ó���Ǵ� ����!!!
 * */
package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread; //������ �����
	boolean flag=true;
	//������Ʈ �޴���!
	ObjectManager objectManager;
	//���ΰ� ����
	Hero hero;
	
	
	//������ ����
	Enemy[] enemy= new Enemy[5];
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		objectManager= new ObjectManager();
		createHero();//���ΰ� ����
		createEnemy();//��������
	}
	//���ΰ� ���� �޼��� ����
	public void createHero(){
		hero = new Hero(100,200,50,50,"hero");
		objectManager.addObject(hero);
	}
	//�������� �޼��� ����!!
	public void createEnemy(){
		for(int i=0; i < enemy.length; i++){
			enemy[i] = new Enemy(600,i*100,30,30,"enemy"+i);
			objectManager.addObject(enemy[i]);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		//��� ���ӿ�����Ʈ���� ����ִ� ����� �̿��Ͽ�
		//��� ���ӿ�����Ʈ�� tick�� render ȣ���ϰ� ����!
		for(int i=0;i<objectManager.objectList.size() ; i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick();
			obj.render(g,this);
		}
	}
	
	//���� ���� �޼���
	public void startGame(){
		if(gameThread!=null){//�̹� �������̶��...
			return;
		}
		gameThread = new Thread(this);
		flag = true;
		gameThread.start();
	}
	//�Ͻ� ���� �޼���
	public void pauseGame(){
		flag=false;
		gameThread = null;
	}
	//�������� �޼���
	public void exitGame(){
		System.exit(-1);
	}
	
	//Runnable�� run �޼��� ������
	@Override
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//System.out.println("���� ���� �۵���");
			repaint();//update()-> paint();
		}
	}
	
}
