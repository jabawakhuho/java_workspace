/*��ư�� �̿��� Image��ȯ �Ҽ��ִ� Gallery�����*/

package com.sds.gallery;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gallery extends JFrame implements ActionListener{
	MyCanvas2 can; 
	JTextField txt;
	JButton undo;
	JButton redo;
	JPanel p;
		
	public Gallery() {
		super("Gallery");
		can = new MyCanvas2();
		txt = new JTextField(30);
		undo = new JButton("��");
		redo = new JButton("��");
		p = new JPanel();
		
		add(can);
		p.setLayout(new FlowLayout());
		
		p.add(undo);
		txt.setText(can.path[can.count]);
		p.add(txt);
		p.add(redo);
		
		undo.addActionListener(this);
		redo.addActionListener(this);
		
		
		add(p,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,650);
		setVisible(true);
	}
	
	//���� �̹��� �����ֱ�
	public void prev(){
		//JOptionPane.showMessageDialog(this, "�����̹���");
		if(can.count <0){
			JOptionPane.showMessageDialog(this, "���̻��̹����������ϴ�.");
			can.count=0;
		}else{
			can.count--;
			can.repaint();
			txt.setText(can.path[can.count]);
		}
	}

	//���� �̹��� �����ֱ�
	public void next(){
		//JOptionPane.showMessageDialog(this, "�����̹���");
		//MyCanvas2�� count������ �ٲ��ش�
		if(can.count>can.imgs.length){
			JOptionPane.showMessageDialog(this, "���̻��̹����������ϴ�.");
			can.count=9;
		}else{
		can.count++;
		//�ٽ� �׷����� ��û ~~ repaint()-->update() ȭ�� �����--> paint() �ٽ� �׸�
		can.repaint();
		txt.setText(can.path[can.count]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj.equals(undo)){
			prev();
		}else if(obj == redo){
			next();
		}
		
	}
	
	public static void main(String[] args) {
		new Gallery();
	}


}
