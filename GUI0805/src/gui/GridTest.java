/*
 5���� ��ġ��������  GridLayout �� �н��Ѵ�.
 grid : ����(������ Table����), row(����) , colum(����)
 
 java.awt ��Ű���� os �÷����� ���� �������� �������̶� �̸� ������ GUI ��Ű���� ����Ѵ�.
 */
package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setLayout(new GridLayout(4,5));
		
		//button 20���� �����Ͽ� ������ ��ư 1,2�� �Ͻÿ�
		Button[] bt = new Button[20];
		
		for(int i = 0; i < bt.length; i++){
			bt[i]=new Button("��ư"+(i+1));
			frame.add(bt[i]);
			
		}
		
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

}
