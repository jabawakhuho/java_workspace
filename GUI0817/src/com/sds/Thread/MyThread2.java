package com.sds.Thread;

public class MyThread2 extends Thread{
	int count =0;
	CounterPro app;
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
		//윈도우의 라벨에 출력
		app.la_count.setText(Integer.toString(count));
	}
	
	public MyThread2(CounterPro app, int speed) {
		this.app = app;
		this.speed = speed;
	}
}
