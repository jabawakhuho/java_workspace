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
		bt = new JButton("��â");
		
		//��ũ���� �����ϰ��� �ϴ� ������Ʈ�� �μ��� �ѱ��!!!
		scroll = new JScrollPane(area);
		
		//���Ϳ� area����
		add(scroll);
		
		//�гο� txt �� bt ������ ���ʿ� ����
		p.add(txt);
		p.add(bt);
		add(p,BorderLayout.SOUTH);
		bt.addActionListener(this);
		
		txt.addKeyListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,200,300,400);
		//setSize(300,400);
		setVisible(true);
		txt.requestFocus();//��Ŀ�� �ø���!!!!
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//��ư �̺�Ʈ �߻��� �ɹ����� b��  ChatB�� �ּҰ��� �����ϰ���
		b=new ChatB(this);
		bt.setEnabled(false);//��ư ��Ȱ��ȭ
	//  ������ �޼��忡�� �ּҰ��� �Ѱ� �ޱ⶧���� ���� �ּҰ��� �ѱ�� �޼��带 ������ �ʿ䰡 ��������.
	//	b.setChat(this); 
	//	txt.requestFocus();//��Ŀ�� �ø���!!!!
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
			//�Է¸޼��� �ʱ�ȭ
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
