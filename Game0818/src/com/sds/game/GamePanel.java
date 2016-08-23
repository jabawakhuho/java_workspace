package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//paint �޼��带 ������ �ϱ⟢ ��JPanel�� ��ӹ޴´�.
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread; //���� ����
	boolean running=true;
	Ship ship;
	ObjectManager objectManager; //���� ��ü ������
	
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
		
		//System.out.println("���ӿ��� �۵���!!!");
		//������ ��� ��ü�� �۵�!!!! tick(), render();
		for(int i=0; i< objectManager.objectList.size(); i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
		
	}
	//���� ����(Thread ���� �� ����)
	public void startGame(){
		if(gameThread !=null){
			return;
		}
		running = true;
		gameThread = new Thread(this);
		gameThread.start();//Runnable ����
	}
	//���Ӹ���(Thread ����)
	public void pauseGame(){
		running=false;
		gameThread = null;
	}
	//���� ����(���μ��� ����)
	public void exitGame(){
		System.exit(0); //0���� �������� �ָ� ���������ٴ� ����
	}
	//ship ��ü ���� �޼���
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
	//�� ���� �޼���
	public void createBlock(){
		//����
		for(int i=0; i <20;i++){
			Block block = new Block(i*50, 0, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
		
		//�Ʒ���
		for(int i=0; i <20;i++){
			Block block = new Block(i*50, HEIGHT-50, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
	}
	@Override
	public void run() {
		while(running){
			//try catch�� �ϴ� ������ ���� ������ �� ������ �߻��Ҽ��� �ֱ� ������~
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint(); //-> updateUI() - > paint()
		}
	}
}
