/*
 버튼을 이용하여 CirCle을 이동시켜보자!!!!!
width, height 600,600
구성-----------
bt4
canvas
---------------------
*/
package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMove extends JFrame {
	JPanel p_north;
	JButton bt_left, bt_right, bt_up, bt_down;
	Canvas can;
	JButton[] btn = new JButton[4];
	int x = 100; // 맴버변수는 내부입력클래스에서 사용시 에러가 발생하지 않는다.(사용가능하다)
	int y = 100;

	public CircleMove() {
		p_north = new JPanel();
		bt_left = new JButton("left");
		bt_right = new JButton("right");
		bt_up = new JButton("up");
		bt_down = new JButton("down");
		// final int k=9;

		btn[0] = bt_left;
		btn[1] = bt_right;
		btn[2] = bt_up;
		btn[3] = bt_down;
		// MyCanvas와 같은 클래스를 내부익명클래스로 정의함
		can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				// 개발자 주도하에 그래픽 처리하자
				g.drawOval(x, y, 40, 40); // 원그리기
			}
		};

		p_north.add(bt_left);
		p_north.add(bt_right);
		p_north.add(bt_up);
		p_north.add(bt_down);

		add(p_north, BorderLayout.NORTH);
		add(can);
		// 버튼과 리스너와의 연결
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(new ActionListener() {
				@Override
				// 내부입력 클래스에서는 지역변수 접근은 불가능하다
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					JButton b = (JButton) obj;
					System.out.println(b.getText() + "누름");
					/*
					 * x=8; //맴버변수는 접근이 가능하다 System.out.println(k);//Final로 정의된
					 * 지역변수는 접근 가능하다.
					 */
					switch(b.getText()){
						case "left":moveHorizon(-5);break;
						case "right":moveHorizon(5);break;
						case "up":moveVertical(5);break;
						case "down":moveVertical(-5);break;
					}
				}
			});
		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
	}

	// 좌우 이동 메서드
	public void moveHorizon(int x){
		this.x+=x;
		can.repaint();
	}

	// 위아래 이동 메서드
	public void moveVertical(int y) {
		this.y-=y;
		can.repaint();
	}

	public static void main(String[] args) {
		new CircleMove();

	}

}
