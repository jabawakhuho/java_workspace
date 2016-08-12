package com.huho.chatting;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatC extends JFrame {
	JTextArea area;
	JScrollPane scroll;
	JTextField txt;
	JPanel p;
	ChatA chatA;
	ChatB chatB;

	public ChatC(ChatA chatA) {
		super("ChatC");
		this.chatA = chatA;
		// this.chatB = chatB;

		area = new JTextArea();
		scroll = new JScrollPane(area);
		txt = new JTextField(15);
		p = new JPanel();
		txt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					chatting();
					chatA.createTxtFile();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				chatA.onC=true;
				JOptionPane.showMessageDialog(chatA, "ChatC´ÔÀÌ ÀÔÀåÇÏ¼Ì½À´Ï´Ù.");
			//	JOptionPane.showMessageDialog(chatB,"ChatC´ÔÀÌ ÀÔÀåÇÏ¼Ì½À´Ï´Ù.");
			}
			@Override
			public void windowIconified(WindowEvent e) {
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			@Override
			public void windowClosing(WindowEvent e) {
				chatA.area.append("ChatC´ÔÀÌ ÅðÀåÇÏ¼Ì½À´Ï´Ù.\n");
				chatB.area.append("ChatC´ÔÀÌ ÅðÀåÇÏ¼Ì½À´Ï´Ù.\n");
				chatA.onC=false;
				// Window Close½Ã ChatAÀÇ btÀ» È°¼ºÈ­ ½ÃÅ²´Ù.
				chatA.bt.setEnabled(true);
			}
			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		});

		add(scroll);
		p.add(txt);
		add(p, BorderLayout.SOUTH);

		setBounds(700, 50, 300, 400);
		setVisible(true);
		txt.requestFocus();
	}
	
	public void chatting(){
		area.append("ChatC : " + txt.getText() + "\n");
		if(chatA!=null){
			chatA.area.append("ChatC : " + txt.getText() + "\n");
		}
		if(chatB!=null){
			chatB.area.append("ChatC : " + txt.getText() + "\n");
		}
		txt.setText("");
	}

	
	public void setChatB(ChatB chatB) {
		this.chatB = chatB;
	}
}
