package com.sds.Thread;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Thread를 상속받아 사용하려할때, 이미 누군가의 자식 클래스라면, Runnable인터페이스를 이용할수있다.
//Runnable은 run 메서드를 추상메서드로 보유한 인터페이스이다!!
public class CounterApp extends JFrame implements Runnable{
	JLabel la_count;
	JButton bt;
	MyThread tr; //외부클래스 작성
	int count=0;
	CounterApp app;
	Thread tr2; //내부익명클래스로 정의
	Thread thread3; //Runnable은 Thread가 아니므로, run 메서드를 재정의하였다 하더라도 쓰레드가 존재해야한다.
	
	public CounterApp() {
		super("Counter");
		app = this;
		la_count = new JLabel(Integer.toString(count));
		la_count.setFont(new Font("arial black", Font.BOLD, 120));
		bt = new JButton("실행");
	
		tr2 = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						tr.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					counter();
				}
			}
		};
		//new Thread(Runnable run);
		thread3 = new Thread(this);
		
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*tr = new MyThread(app);
				tr.start();*/
				//tr2.start();
				thread3.start();
			}
		});
		
		
		add(bt,BorderLayout.NORTH);
		add(la_count);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
	
	public void counter(){
		count++;
		la_count.setText(Integer.toString(count));
		la_count.updateUI();
	}
	//이 run메서드는 Runnable 인터페이스 꺼다!!
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter();
		}
	}
	
	public static void main(String[] args){
		new CounterApp();
	}
}
