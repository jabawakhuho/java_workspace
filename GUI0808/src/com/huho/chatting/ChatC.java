package com.huho.chatting;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
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

	public ChatC(ChatA chatA,ChatB chatB) {
		super("ChatC");
		this.chatA = chatA;
		this.chatB = chatB;

		area = new JTextArea();
		txt = new JTextField(15);
		p = new JPanel();
		scroll=new JScrollPane(area);
		
		txt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					area.append("ChatC : " + txt.getText() + "\n");
					chatA.area.append("ChatC : " + txt.getText() + "\n");
					chatB.area.append("ChatC : " + txt.getText() + "\n");
					txt.setText("");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		// Window Close시 ChatA의 bt을 활성화 시킨다.
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				area.append("ChatA방에 초대 되셨습니다.\n");
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
				chatA.area.append("ChatC님이 퇴장하셨습니다.\n");
				chatB.area.append("ChatC님이 퇴장하셨습니다.\n");
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

	public void setChatB(ChatB chatB) {
		this.chatB = chatB;
	}
}
