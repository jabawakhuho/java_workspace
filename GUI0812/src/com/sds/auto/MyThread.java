/*
 * �ϳ��� ���μ��� ���������������� ����Ǵ� ������ ������� �ϸ� Tread Ŭ������ �����Ѵ�.
 * ���� ������� �ڹ��� ������ �ƴϴ�. �����ϴ� ���κ��� �������α׷��� �����尡 �ȴ�.
 * c,c#
 */
package com.sds.auto;

public class MyThread extends Thread {
	// �����ڴ� ���������� �����ϰ� ���� �ڵ尡 �ִٸ� run()�޼��带 �������ϸ� �ȴ�.
	int count = 0;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);// 1�ʵ��� non-runnable ���·� �־��!! 1�� ������
									// runnable����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			System.out.println(count);
			
		}
	}
}
