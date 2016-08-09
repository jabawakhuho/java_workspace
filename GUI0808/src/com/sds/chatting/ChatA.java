package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JPanel p;
	JTextField txt;
	JButton bt;
	JScrollPane scroll;
	ChatB b;
	
	public ChatA() {
		super("ChatA");
		area = new JTextArea();
		p =new JPanel();
		txt = new JTextField(15);
		bt = new JButton("새창");
		
		//스크롤을 적용하고자 하는 컴포넌트를 인수로 넘긴다!!!
		scroll = new JScrollPane(area);
		
		//센터에 area부착
		add(scroll);
		
		//패널에 txt 와 bt 부착후 남쪽에 부착
		p.add(txt);
		p.add(bt);
		add(p,BorderLayout.SOUTH);
		bt.addActionListener(this);
		
		txt.addKeyListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,200,300,400);
		//setSize(300,400);
		setVisible(true);
		txt.requestFocus();//포커스 올리기!!!!
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼 이벤트 발생시 맴버변수 b에  ChatB의 주소값을 보유하게함
		b=new ChatB(this);
		bt.setEnabled(false);//버튼 비활성화
	//  생성자 메서드에서 주소값을 넘겨 받기때문에 따로 주소값을 넘기는 메서드를 생성할 필요가 없어진다.
	//	b.setChat(this); 
	//	txt.requestFocus();//포커스 올리기!!!!
	}
	
	
	public static void main(String[] args) {
		new ChatA();
	}




	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
		/*	String s1 = this.txt.getText();
			String s2 = area.getText();
			String txt = s2 +"\n" +s1;
			area.setText(txt);*/
			String txt = this.txt.getText();
			area.append("Chat A :"+txt+"\n");
			//입력메세지 초기화
			this.txt.setText("");
			
			//
			b.area.append("Chat A :"+txt+"\n");
		}
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
