package com.sds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyListener implements ActionListener{
	EventTest2 et;
	
	//��� ������ et�� �̹� ���ִ� �������� EventTest2�� ���۷��� ���Խ�Ű��!!
	public void setEt(EventTest2 et){
		this.et=et;
		//System.out.println("�Ѱܹ��� �ּҰ�"+et);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("��������");
		
		JTextField txt = et.txt;
		txt.setText("�� ������");
		//EventTest2.txt.setText("��������");
	}
	
}
