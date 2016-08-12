package com.sds.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MultiDownload extends JFrame implements ActionListener{
	JButton	bt;
	//MyThread bar1,bar2,bar3;
	Mybar bar1,bar2,bar3;
	Thread t1,t2,t3; //Runnable은 Thread가 필요함
	
	public MultiDownload() {
		setLayout(new FlowLayout());
		bt = new JButton("멀티다운");
		//진행 속도,Thread sleep time, background color
		/*bar1=new MyThread(1,1000,Color.GREEN);
		bar2=new MyThread(1,500,Color.BLUE);
		bar3=new MyThread(1,1500,Color.RED);*/
		bar1 = new Mybar(1000);
		bar2 = new Mybar(500);
		bar3 = new Mybar(1500);
		
		bt.addActionListener(this);
		
		add(bt);
		add(bar1);
		add(bar2);
		add(bar3);
		//Runnalble로 run메서드를 재정의할 경우 
		//Thread 생성시 Runnalble 객체를 인수로 넣어야
		//Runnalble 의 run메서드가 동작하게 된다!!
		//언제쓰나? Thread 클래스를 상속받아 코드를 작성하려고 했으나, 이미 다른 클래스의 자식인 클래스인경우
		//다중 상속이 불가능하므로, 이때 인터페이스인 Runnalble을 이용할수있다.
		t1 = new Thread(bar1);
		t2 = new Thread(bar2);
		t3 = new Thread(bar3);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void main(String[] args) {
		new MultiDownload();
	}

}
