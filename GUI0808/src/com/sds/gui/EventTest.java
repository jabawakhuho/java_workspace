/*
 	�Ʒ��� ��Ģ�� ���� �������(=�ȵ���̵� ���߽� ����)
 1.�˸´� ������ ����
 2.�������� �޼��� ������
 3.�̺�Ʈ �ҽ�(�̺�Ʈ�� ����Ŵ ������Ʈ )�� �����ʿ� ����
 * */

package com.sds.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest extends JFrame implements ActionListener, KeyListener, WindowListener{
	JTextField txt;
	JButton bt;
	
	public EventTest() {
		super("test");
		setLayout(new FlowLayout());
		txt = new JTextField(15);
		bt = new JButton("��ư");
		
		add(txt);
		add(bt);
		//��ư�� �����ʿ� ����!!
		bt.addActionListener(this);
		//�ؽ�Ʈ�ʵ�� ������ ����
		txt.addKeyListener(this);
		//������� �����츮���ʿ���..
		addWindowListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	//
	public void actionPerformed(ActionEvent e) {
		System.out.println("��������");
	}
	
	//keyListener�� ������ �߻�޼��� �������̵� ����
	public void keyPressed(KeyEvent e) {

	}
	
	public void keyReleased(KeyEvent e) {
		//System.out.println(e.getKeyCode()+"������");
		
		int key = e.getKeyCode();
		if(key== KeyEvent.VK_ENTER){
			System.out.println("���� �׸� ����");
		}
	}
	
	public void keyTyped(KeyEvent e) {

	}
	
	//������ �߻�޼��� �������̵�
	@Override
	public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated ȣ��");
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed ȣ��");
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing ȣ��");
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated ȣ��");
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified ȣ��");
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified ȣ��");
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened ȣ��");
	}
	
	
	
	
	public static void main(String[] args) {
			new EventTest();

	}





}
