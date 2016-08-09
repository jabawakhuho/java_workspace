/*
 �迭�� �����͸� �޸𸮿� �����ְ� �÷����� �뵵�δ� ���� �Ǹ��ϴ�.
 ������ ��κ��� �������α׷����� �迭�� ������ �� ũ�⸦ ����ؾ� �Ѵ�!!
 ���δ� �� ��Ģ�� �������� ���ϴ�...
 
 �ڹپ����� ��ü�� ��Ƽ� ó���Ҷ� ���� ȿ�������� ó���ϱ� ���� ��Ű���� �����Ǹ�
 �� ��Ű���� ������ �÷��� �����ӿ��̶� �Ѵ�.!!!!!
 ------------------------------------------------------------------------------
 [�÷��� �����ӿ��� ����]
1. �����ִ¸��: List
-Ư¡ : �迭�� ���� ����. 
-������ : �迭�� �⺻�ڷ��������� ����������, List�� List�� ������ �÷��� �����ӿ��� ����� ��ü������ �����ȴ�.
			�迭�� ������ ��ũ�⸦ ����ؾ�������(����), �÷��� �����ӿ��� �������� �þ��. 
			���� ������ �� ũ�⸦ ������� �ʾƵ� �ȴ�..
2. �������¸�� : Set
3. key-value�� ������ �̷���� ��� : Map

�÷��� �����ӿ��� java.util ��Ű������ ����!!!
 */

package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CollectionTest extends JFrame{
	ArrayList<JButton> list;
	JButton bt_create,bt_color;
	JPanel p_north,p_center;
	
	public CollectionTest() {
		list = new ArrayList<JButton>();//����Ʈ ����!! 
		p_north = new JPanel();
		p_center = new JPanel();
		bt_create = new JButton("����");
		bt_color = new JButton("����");
		
		p_north.add(bt_create);
		p_north.add(bt_color);
		
		p_center.setBackground(Color.GREEN);
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		bt_create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ư�� ����
				JButton bt = new JButton("����ư");
				p_center.add(bt);
				p_center.updateUI();//���ΰ�ħ �޼���(������Ʈ ����)
				
				//������ ��ư��  LIST�� ����!!
				list.add(bt);
				System.out.println("��������� ����Ʈ ũ���"+list.size());
			}
		});
		//����ٲٱ�!!
		bt_color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i < list.size();i++){
					/*Object obj = list.get(i);
					JButton b = (JButton)obj;*/
					/*JButton b= (JButton)list.get(i);*/
					JButton b = list.get(i); 
					// ArrayList�� ������� <JButton>���� �����Ͽ��⿡ Jbutton���� �ٷ� �������ִ�.!!
					b.setBackground(Color.YELLOW);
				}
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new CollectionTest();
	}

}
