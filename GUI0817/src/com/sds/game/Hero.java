/*주인공을 정의한다.*/
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

	//일정한 물리량의 변화값을 결정하는 메서드~
	public void tick(){
		x+=velX;
		y+=velY;
	}
	
	//자신이 어떻게 그려져야 할지를 결정하는 메서드!!
	public void render(Graphics g,JPanel panel){
		//검정색으로 기존에 그려진 그림을 덮어버린다.!!(지우개 역활)
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		g.setColor(Color.YELLOW);
		g.drawImage(img, x, y, panel);
	}
}
