/*
 	아래의 원칙으 ㄹ잘 기억하자(=안드로이드 개발시 동일)
 1.알맞는 리스너 선택
 2.리스너의 메서드 제정의
 3.이벤트 소스(이벤트를 일으킴 컴포넌트 )와 리스너와 연결
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
		bt = new JButton("버튼");
		
		add(txt);
		add(bt);
		//버튼과 리스너와 연결!!
		bt.addActionListener(this);
		//텍스트필드와 리스너 연결
		txt.addKeyListener(this);
		//윈도우와 윈도우리스너연결..
		addWindowListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	//
	public void actionPerformed(ActionEvent e) {
		System.out.println("나눌렀어");
	}
	
	//keyListener가 보유한 추상메서드 오버라이드 하자
	public void keyPressed(KeyEvent e) {

	}
	
	public void keyReleased(KeyEvent e) {
		//System.out.println(e.getKeyCode()+"눌렀어");
		
		int key = e.getKeyCode();
		if(key== KeyEvent.VK_ENTER){
			System.out.println("엔터 그만 눌러");
		}
	}
	
	public void keyTyped(KeyEvent e) {

	}
	
	//윈도우 추상메서드 오버라이딩
	@Override
	public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated 호출");
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed 호출");
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing 호출");
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated 호출");
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified 호출");
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified 호출");
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened 호출");
	}
	
	
	
	
	public static void main(String[] args) {
			new EventTest();

	}





}
