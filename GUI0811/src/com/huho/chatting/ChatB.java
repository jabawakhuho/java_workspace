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

public class ChatB extends JFrame {
	JTextArea area;
	JScrollPane scroll;
	JTextField txt;
	JPanel p;
	ChatA chatA;
	ChatC chatC;

	public ChatB(ChatA chatA) {
		super("ChatB");
		this.chatA = chatA;
		//this.chatC = chatC;

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
		// Window Close½Ã ChatAÀÇ btÀ» È°¼ºÈ­ ½ÃÅ²´Ù.
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				chatA.onB=true;
				JOptionPane.showMessageDialog(chatA, "ChatB´ÔÀÌ ÀÔÀåÇÏ¼Ì½À´Ï´Ù.");
			//	JOptionPane.showMessageDialog(chatC,"ChatB´ÔÀÌ ÀÔÀåÇÏ¼Ì½À´Ï´Ù.");
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
				chatA.area.append("ChatB´ÔÀÌ ÅðÀåÇÏ¼Ì½À´Ï´Ù.\n");
				chatC.area.append("ChatB´ÔÀÌ ÅðÀåÇÏ¼Ì½À´Ï´Ù.\n");
				chatA.onB=false;
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

		setBounds(400, 50, 300, 400);
		setVisible(true);
		txt.requestFocus();
	}
	
	public void chatting(){
		area.append("ChatB : " + txt.getText() + "\n");
		if(chatA!=null){
			chatA.area.append("ChatB : "+ txt.getText() + "\n");
		}
		if(chatC!=null){
			chatC.area.append("ChatB : " + txt.getText() + "\n");
		}
		txt.setText("");
	}

	public void setChatC(ChatC chatC) {
		this.chatC = chatC;
	}
}
