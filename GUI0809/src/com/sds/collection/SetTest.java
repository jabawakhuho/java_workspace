/*
 ���� ���� ���ִ� ��ü�� ǥ���� Set�� ���Ͽ� �н��Ѵ�.
 Set�� ���� ��ü�� hashset�� �н�����!
 
 * */

package com.sds.collection;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;

public class SetTest {

	public static void main(String[] args) {
		// Generic Type : �÷��� �����ӿ��� ä���� ���������� �����������ִ�. <�ڷ���>���� ǥ��
		HashSet<JButton> set = new HashSet<JButton>();

		// auto boxing
		int x = 3;
		// Intger i = new Integer(3);
		/*
		 * set.add(x); //���� �������� �Ѵ�!!! �׷��� �� �ȳ���?? �÷��� �����ӿ��� �޼����μ��� int�� ������
		 * �⺻�ڷ����� ����ϸ� �ڵ����� Wrapper��ü�� ��ȯ�Ǿ�����. ��?? �������� �ǵ��� �ľ��Ͽ� ���ŷ��� �ʰ� ���ذ�..
		 * 
		 * set.add("���"); //String ��ü�� ��
		 */
		set.add(new JButton("����ư"));
		set.add(new JButton("�ʹ�ư"));
		set.add(new JButton("���ư"));

		//������ ��� ���������
		Iterator it = set.iterator();//�������� Set�� �ϳ��� �����Ҽ��ֵ��� ���� ����
		
		while(it.hasNext()){
			JButton bt=(JButton)it.next();
			System.out.println(bt.getText());
		}
	}

}
