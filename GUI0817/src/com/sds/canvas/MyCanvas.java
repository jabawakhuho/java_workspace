package com.sds.canvas;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MyCanvas extends JFrame implements KeyListener {
	Canvas can;
	int x = 0;
	boolean bl= true;

	public MyCanvas() {
		can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				g.drawOval(x, 300, 50, 50);
			}
			
		};

		can.setPreferredSize(new Dimension(700, 600));

		add(can);
		this.addKeyListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//윈도우를 모니터 크기와 상관없이 항상 가운데 띄우기!!
		setLocationRelativeTo(null);
		setSize(700, 600);
		setVisible(true);
	}

	public void shootting() {
		if (x != 700) {
			x += 10;
		} else {
			x = 0;
		}
		can.repaint();
	}

	public static void main(String[] args) {
		new MyCanvas();
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			x=0;
			//쓰레드 1개를 생성하여 작동!!
			Thread thread = new Thread() {
				@Override
				public void run() { 
					while (bl) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						x+=5;
						can.repaint();
					}
				}
			};
			thread.start();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
