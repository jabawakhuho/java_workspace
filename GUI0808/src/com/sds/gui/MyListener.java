package com.sds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class MyListener implements ActionListener{
	EventTest2 et;
	
	//멤버 변수인 et에 이미 떠있는 윈도우인 EventTest2의 레퍼런스 대입시키자!!
	public void setEt(EventTest2 et){
		this.et=et;
		//System.out.println("넘겨받은 주소값"+et);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("나눌렀어");
		
		JTextField txt = et.txt;
		txt.setText("나 눌렀어");
		//EventTest2.txt.setText("나눌렀어");
	}
	
}
