/*
 ����Ͽ� ���� �͹����̸�, ����� ���� �ν��Ͻ��� ����ǹǷ�, �� ���뼺�� �����Ƿ� �����͸��ٴ� 
 .java�ҽ��� ������ �����Ű��~
 */

package com.sds.graphic;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MyCanvas extends Canvas implements MouseListener{
	Toolkit kit;
	Image img;
	ThumnailGallery frame;//null

	public MyCanvas(String url,ThumnailGallery frame) {
		//System.out.println(frame);
		this.frame = frame; 
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(url);
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 50,50,this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		frame.currentImg = img;
		//System.out.println(img);
		frame.p_right.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Image getPath(){
		return img;
	}
	
	
}
