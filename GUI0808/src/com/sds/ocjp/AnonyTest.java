/*
 Ŭ���� �ȿ� Ŭ������ �Ѽ��ִ°�?? �ִ�!!!!!
  
 */
/*
 �����͸�Ŭ������ ���� �ʿ��ұ�?
 .java�� ����� ������ ������ �ϱ� ���ؼ� �̴�. 
 �׷��� ������ �ش� Ŭ������������ ���� �ٸ� Ŭ�����鿡�� ���ʿ����
 ��, ���뼺�� �ʿ���� �͵��� �ش� Ŭ������ �͸� ����Ŭ������ ���� ����Ѵ�.
 
  */
package com.sds.ocjp;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonyTest extends JFrame{
	Canvas can;
	JButton bt1;
	JButton bt2;
		
	public AnonyTest() {
		//���� �͸� Ŭ����..
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawLine(0, 0, 300, 400);
			}
		};
		
		add(can); //�������� ���Ϳ� �˹��� ����
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		
		bt1 = new JButton("��ư 1");
		bt2 = new JButton("��ư 2");
		//�͸�Ŭ���� implements ActionListener{}
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����ư1");
			}
		});
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����ư2");
			}
		});
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new AnonyTest();
	}

}
