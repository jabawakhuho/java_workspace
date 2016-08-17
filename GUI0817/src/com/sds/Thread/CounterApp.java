package com.sds.Thread;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Thread�� ��ӹ޾� ����Ϸ��Ҷ�, �̹� �������� �ڽ� Ŭ�������, Runnable�������̽��� �̿��Ҽ��ִ�.
//Runnable�� run �޼��带 �߻�޼���� ������ �������̽��̴�!!
public class CounterApp extends JFrame implements Runnable{
	JLabel la_count;
	JButton bt;
	MyThread tr; //�ܺ�Ŭ���� �ۼ�
	int count=0;
	CounterApp app;
	Thread tr2; //�����͸�Ŭ������ ����
	Thread thread3; //Runnable�� Thread�� �ƴϹǷ�, run �޼��带 �������Ͽ��� �ϴ��� �����尡 �����ؾ��Ѵ�.
	
	public CounterApp() {
		super("Counter");
		app = this;
		la_count = new JLabel(Integer.toString(count));
		la_count.setFont(new Font("arial black", Font.BOLD, 120));
		bt = new JButton("����");
	
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
	//�� run�޼���� Runnable �������̽� ����!!
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
