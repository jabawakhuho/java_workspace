/*Chat A,B,C 연결하기*/

package com.huho.chatting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class ChatA extends JFrame implements ActionListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField txt;
	JButton bt;
	JPanel p;
	//ChatA chatA;
	ChatB chatB;
	ChatC chatC;
	
	public ChatA() {
		super("ChatA");
		area = new JTextArea();
		txt = new JTextField(15);
		bt = new JButton("실행");
		p = new JPanel();
		
		scroll = new JScrollPane(area);
		add(scroll);
		p.setLayout(new FlowLayout());
		
		txt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					area.append("ChatA : "+txt.getText()+"\n");
					chatB.area.append("ChatA : "+txt.getText()+"\n");
					chatC.area.append("ChatA : "+txt.getText()+"\n");
					txt.setText("");
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		bt.addActionListener(this);
		//내장익명클래스는 생성자선언을 할수있다?!
		/*bt.addActionListener(new ActionListener(this) {
			ChatA chatA;
			public (CharA chatA){
				this.chatA = chatA;
			}
			public void actionPerformed(ActionEvent e) {
				chatB = new ChatB(chatA);
				chatC = new ChatC(chatA);
			}
		});*/
	
		p.add(txt);
		p.add(bt);
		add(p, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 300, 400);
		setVisible(true);
		txt.requestFocus();
	}
	
	public void actionPerformed(ActionEvent e) {
		chatB = new ChatB(this);
		chatC = new ChatC(this,chatB);
		
		chatB.setChatC(chatC);
		//chatC.setChatB(chatB);
		
		bt.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new ChatA();
	}

}
