/*
 java�� �̹��� �����ϱ�
 �׸��� �׷�����
 ����  : �׸��׸����(��ü) -> ����1(��),����2(�ķ�Ʈ) -> �׷��� ���
Com :  ���۳�Ʈ������(�ڱ��ڽ��� �׸�) ->�޼���(�Ű�����)-> ���۳�Ʈ(�ڱ��ڽ�) 
 ----------------------------------------------------------------------------
 JAVA�� ��� GUI ������Ʈ�� ������ �׸��� ��ü�� �Ǿ� �����θ� �׸���. �̶� �׸� �׸��� ������ Paint �޼����
 ǥ���Ǹ�, �� Paint �޼����� �Ű������� �ȷ�Ʈ ��Ȱ�� ��ü�� Graphics ��ü�� �μ��� ���޵Ǿ�����.
 ex)��ư�� �ҽ��� �׸��� ����...
 */
package com.sds.gallery;

import java.awt.Canvas;//�ƹ��͵� �׷��� ���� ���� ��ȭ�� �˹���

import javax.swing.JFrame;

public class ImageTest extends JFrame {
	Mybutton bt;
	MyCanvas can;
	
	public ImageTest() {
		bt = new Mybutton("Ŀ���� ��ư");
		can =new MyCanvas();
		add(can);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageTest();
	}

}
