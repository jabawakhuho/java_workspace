/*
 * 하나의 프로세스 내에서독립적으로 실행되는 단위응 쓰레드라 하며 Tread 클래스로 지원한다.
 * 주의 쓰레드는 자바의 개념이 아니다. 현존하는 개부분의 응용프로그램은 쓰레드가 된다.
 * c,c#
 */
package com.sds.auto;

public class MyThread extends Thread {
	// 개발자는 독입적으로 수행하고 싶은 코드가 있다면 run()메서드를 재정의하면 된다.
	int count = 0;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);// 1초동안 non-runnable 상태로 있어라!! 1초 지나면
									// runnable복귀
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			System.out.println(count);
			
		}
	}
}
