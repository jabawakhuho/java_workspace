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
		super("리스너 밖으로 빼기");
		bt = new JButton("버튼");
		txt= new JTextField(10);
		
		setLayout(new FlowLayout());
		add(bt);
		add(txt);
		//버튼과 리스너와의 연결!!
		my = new MyListener();
		
		bt.addActionListener(my);
		//System.out.println("setEt()메서드 호출전  내 주소값"+this);
		my.setEt(this); //call by reference
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new EventTest2();
	}

}
