package com.huho.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientWindow extends JFrame{
	LoginPanel loginPanel;
	
	public ClientWindow() {
		super("Movie ticket");
		loginPanel = new LoginPanel(400, 50);
		
		add(loginPanel,BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//pack();
		setSize(400, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new ClientWindow();
	}

}
