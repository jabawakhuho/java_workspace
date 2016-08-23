package com.sds.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GamWindow extends JFrame implements ActionListener{
	//���ӿɼ�- ���ӽ���, ����,����
	//����
	GamePanel gamePanel;
	JMenuBar bar;
	JMenu[] menu=new JMenu[2];
	JMenuItem[] menuItem = new JMenuItem[3];
	String[] item = {"���ӽ���","����","����"};
	KeyBoard keyboard;
	
	public GamWindow() {
		super("����������");
		gamePanel = new GamePanel();
		bar = new JMenuBar();
		//menu����
		menu[0] = new JMenu("���ӿɼ�");
		menu[1] = new JMenu("����");
		//menuItem���� �� menu[0]�� ����
		for(int i=0; i < menuItem.length; i++){
			menuItem[i] = new JMenuItem(item[i]);
			menuItem[i].addActionListener(this);
			menu[0].add(menuItem[i]);
			
		}
		keyboard = new KeyBoard(gamePanel.objectManager);
		
		bar.add(menu[0]);
		bar.add(menu[1]);
		//bar�� ������(JFrame)�� ����
		setJMenuBar(bar);
		add(gamePanel);
		//�����Ϳ� ������ ����
		addKeyListener(keyboard);
		
		pack(); //���� �ν��Ͻ��� �°� ũ�� ����
		setBackground(Color.BLACK);
		setLocationRelativeTo(null); //JFrame�� ȭ�� �߾ӿ� ��ġ��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==menuItem[0]){
			gamePanel.startGame();
		}else if(obj==menuItem[1]){
			gamePanel.pauseGame();
		}else if(obj==menuItem[2]){
			gamePanel.exitGame();
		}
	}
	public static void main(String[] args) {
		new GamWindow();

	}

}
