/*���ΰ��� �����Ѵ�.*/
package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Hero extends GameObject{
	Toolkit kit =Toolkit.getDefaultToolkit();
	Image img = kit.getImage("C:/java_workspace/GUI0817/res/ship.gif");
	
	public Hero(int x, int y, int width, int height, String name) {
		super(x, y, width, height, name);
		
	}

	//������ �������� ��ȭ���� �����ϴ� �޼���~
	public void tick(){
		x+=velX;
		y+=velY;
	}
	
	//�ڽ��� ��� �׷����� ������ �����ϴ� �޼���!!
	public void render(Graphics g,JPanel panel){
		//���������� ������ �׷��� �׸��� ���������.!!(���찳 ��Ȱ)
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		g.setColor(Color.YELLOW);
		g.drawImage(img, x, y, panel);
	}
}
