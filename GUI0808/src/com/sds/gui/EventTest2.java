package com.sds.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest2 extends JFrame{
	JButton bt;
	JTextField txt;
	MyListener my;
	
	public EventTest2() {
		super("������ ������ ����");
		bt = new JButton("��ư");
		txt= new JTextField(10);
		
		setLayout(new FlowLayout());
		add(bt);
		add(txt);
		//��ư�� �����ʿ��� ����!!
		my = new MyListener();
		
		bt.addActionListener(my);
		//System.out.println("setEt()�޼��� ȣ����  �� �ּҰ�"+this);
		my.setEt(this); //call by reference
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new EventTest2();
	}

}
