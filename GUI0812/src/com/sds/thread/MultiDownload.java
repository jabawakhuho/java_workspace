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
	Thread t1,t2,t3; //Runnable�� Thread�� �ʿ���
	
	public MultiDownload() {
		setLayout(new FlowLayout());
		bt = new JButton("��Ƽ�ٿ�");
		//���� �ӵ�,Thread sleep time, background color
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
		//Runnalble�� run�޼��带 �������� ��� 
		//Thread ������ Runnalble ��ü�� �μ��� �־��
		//Runnalble �� run�޼��尡 �����ϰ� �ȴ�!!
		//��������? Thread Ŭ������ ��ӹ޾� �ڵ带 �ۼ��Ϸ��� ������, �̹� �ٸ� Ŭ������ �ڽ��� Ŭ�����ΰ��
		//���� ����� �Ұ����ϹǷ�, �̶� �������̽��� Runnalble�� �̿��Ҽ��ִ�.
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
