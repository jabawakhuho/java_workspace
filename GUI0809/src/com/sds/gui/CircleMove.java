/*
 ��ư�� �̿��Ͽ� CirCle�� �̵����Ѻ���!!!!!
width, height 600,600
����-----------
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
	int x = 100; // �ɹ������� �����Է�Ŭ�������� ���� ������ �߻����� �ʴ´�.(��밡���ϴ�)
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
		// MyCanvas�� ���� Ŭ������ �����͸�Ŭ������ ������
		can = new Canvas() {
			@Override
			public void paint(Graphics g) {
				// ������ �ֵ��Ͽ� �׷��� ó������
				g.drawOval(x, y, 40, 40); // ���׸���
			}
		};

		p_north.add(bt_left);
		p_north.add(bt_right);
		p_north.add(bt_up);
		p_north.add(bt_down);

		add(p_north, BorderLayout.NORTH);
		add(can);
		// ��ư�� �����ʿ��� ����
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(new ActionListener() {
				@Override
				// �����Է� Ŭ���������� �������� ������ �Ұ����ϴ�
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					JButton b = (JButton) obj;
					System.out.println(b.getText() + "����");
					/*
					 * x=8; //�ɹ������� ������ �����ϴ� System.out.println(k);//Final�� ���ǵ�
					 * ���������� ���� �����ϴ�.
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

	// �¿� �̵� �޼���
	public void moveHorizon(int x){
		this.x+=x;
		can.repaint();
	}

	// ���Ʒ� �̵� �޼���
	public void moveVertical(int y) {
		this.y-=y;
		can.repaint();
	}

	public static void main(String[] args) {
		new CircleMove();

	}

}
