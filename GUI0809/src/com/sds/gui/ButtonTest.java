package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonTest extends JFrame{
	JButton bt1;
	JButton bt2;
	JButton[] btn;
	JPanel p1;
	JPanel p2;
	
	int x = 0;
	
	public ButtonTest() {
		bt1 = new JButton("����");
		bt2 = new JButton("����");
		p1 = new JPanel();
		p2 = new JPanel();
		
		btn = new JButton[100];

		
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				JButton b = (JButton) obj;
				if(b.getText() == "����"){
					System.out.println("����");
					ButtonAdd();
				}
				
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				JButton b = (JButton) obj;
				if(b.getText() == "����"){
					System.out.println("����");
					ButtonColor();
				}
			}
		});
		
		p1.add(bt1);
		p1.add(bt2);
		
		add(p1,BorderLayout.NORTH);
		add(p2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 700);
		setVisible(true);
	}
	
	//��ư �����ϴ� �ż���
	public void ButtonAdd(){
		JButton b = new JButton(x+"��ư");
		btn[x] = b;
		p2.add(b);
		add(p2);
		x++;		
	}
	
	public void ButtonColor(){
		for(int i = 0; i < x ; i++){
			btn[i].setBackground(Color.yellow);
		}
	}
	
	public static void main(String[] args) {
		new ButtonTest();
	}

}
