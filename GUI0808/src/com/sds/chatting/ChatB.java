package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener, WindowListener{
	JTextArea area;
	JPanel p;
	JTextField txt;
	JScrollPane scroll;
	ChatA chatA;
	
	//생성자도 메서드이므로 아래의 코드는 충분히 가능하다!!
	//
	public ChatB(ChatA chatA) {
		super("ChatB");
		this.chatA=chatA;
		area = new JTextArea();
		p =new JPanel();
		txt = new JTextField(15);
		
		//스크롤을 적용하고자 하는 컴포넌트를 인수로 넘긴다!!!
		scroll = new JScrollPane(area);
		
		//센터에 area부착
		add(scroll);
		
		//패널에 txt 와 bt 부착후 남쪽에 부착
		p.add(txt);
		txt.addKeyListener(this);
		addWindowListener(this);
		
		add(p,BorderLayout.SOUTH);
		
		setBounds(400, 200, 300, 400);
		//setSize(300,400);
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	public void setChat(ChatA chatA){
		this.chatA = chatA;
	}*/
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key  = e.getKeyCode();
		if(key == KeyEvent.VK_ENTER){
			String t= txt.getText();
			area.append("Chat B :"+t+"\n");
			chatA.area.append("Chat B :"+t+"\n");
			txt.setText("");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	///////////////
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("windowClosing");
		chatA.bt.setEnabled(true);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
