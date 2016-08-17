package com.sds.Thread;

public class MyThread extends Thread{
	/*독립적으로 수행하고 싶은 코드를 run 메서드에 작성해야한다.*/
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
		//윈도우의 라벨에 출력
		app.la_count.setText(Integer.toString(count));
	}
	
	public MyThread(CounterApp app, int speed) {
		this.app = app;
		this.speed = speed;
	}
}
