/*
 �ڹ��� GUI���� API���� java.awt ��Ű�� ���� �����Ѵ�.
 Ư�� ������� ���� �ٸ� ������Ʈ���� �����Ҽ��ִ� ��ü��
 ��ġ�� ������ ����ؾ� �ϸ�, �� ��ġ�� ������ 5������ �ִ�.
 ���� BorderLayout�� �н��Ѵ�.
 borderLayout : ��,��,��,��,���� 5���� 
  */
package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class BorderTeat {

	public static void main(String[] args) {
		Frame frame=new Frame();
		
		Button bt_north= new Button("����");
		Button bt_west= new Button("����");
		Button bt_center= new Button("���");
		Button bt_east= new Button("����");
		Button bt_south= new Button("����");
		
		//BorderLayout�� ��������!!
		BorderLayout layout = new BorderLayout();
		
		//frame�� layout�� ��������
		//�����ڰ� layout�� ������ ������, �ش� ��ü�� ����Ʈ ��ġ�����ڰ� ����ǰ�,
		//Frame�� ��� ����Ʈ ��ġ�����ڴ� BorderLayout �̴�!!! 
		//����BorderLayout �����ڰ� ������ �������� ������ CENTER�̴�!!!
		frame.setLayout(layout);
		
		frame.add(bt_north, BorderLayout.NORTH);
		//��ư�� ũ�⸦ �����ϴ� Class > Dimension
		bt_west.setPreferredSize(new Dimension(100, 400));
		frame.add(bt_west, BorderLayout.WEST);
		frame.add(bt_center, BorderLayout.CENTER);
		frame.add(bt_east, BorderLayout.EAST);
		frame.add(bt_south, BorderLayout.SOUTH);
		
	
		frame.setSize(500,400);
		frame.setVisible(true);
		
	}

}
