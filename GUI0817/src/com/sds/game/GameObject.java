/*
Hero�̰� Enemy�̰� ������ ���ӿ� �����ϴ� ��� �繰�� �������� Ư���� ������ �����ϰ� �����Ƿ�,
�� ��ü���� ������ Ư���� ������ �����Ͽ� �ڵ带 �ߺ����� ����, �ֻ����� ������ �θ� Ŭ������ �����Ͽ�
�ڵ��� ������ �õ��غ���!!
 */

package com.sds.game;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GameObject {
	String name;
	int x,y,velX,velY,width,height;
	
	public GameObject(int x, int y, int width, int height, String name) {
		this.x= x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.name=name;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g,JPanel panel);
}
