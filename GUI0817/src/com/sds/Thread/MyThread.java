package com.sds.Thread;

public class MyThread extends Thread{
	/*���������� �����ϰ� ���� �ڵ带 run �޼��忡 �ۼ��ؾ��Ѵ�.*/
	int count =0;
	CounterApp app;
	int speed;
	@Override
	public void run() {
		while(true){
			try {
				this.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count();
		}
	}
	
	
	public void count(){
		count++;
		//�������� �󺧿� ���
		app.la_count.setText(Integer.toString(count));
	}
	
	public MyThread(CounterApp app, int speed) {
		this.app = app;
		this.speed = speed;
	}
}
