package com.sds.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GamWindow extends JFrame implements ActionListener{
	//게임옵션- 게임시작, 멈춤,종료
	//도움말
	GamePanel gamePanel;
	JMenuBar bar;
	JMenu[] menu=new JMenu[2];
	JMenuItem[] menuItem = new JMenuItem[3];
	String[] item = {"게임시작","멈춤","종료"};
	KeyBoard keyboard;
	
	public GamWindow() {
		super("게임윈도우");
		gamePanel = new GamePanel();
		bar = new JMenuBar();
		//menu생성
		menu[0] = new JMenu("게임옵션");
		menu[1] = new JMenu("도움말");
		//menuItem생성 및 menu[0]에 붙임
		for(int i=0; i < menuItem.length; i++){
			menuItem[i] = new JMenuItem(item[i]);
			menuItem[i].addActionListener(this);
			menu[0].add(menuItem[i]);
			
		}
		keyboard = new KeyBoard(gamePanel.objectManager);
		
		bar.add(menu[0]);
		bar.add(menu[1]);
		//bar를 윈도우(JFrame)에 붙임
		setJMenuBar(bar);
		add(gamePanel);
		//리스터와 윈도우 연결
		addKeyListener(keyboard);
		
		pack(); //안의 인스턴스에 맞게 크기 조정
		setBackground(Color.BLACK);
		setLocationRelativeTo(null); //JFrame의 화면 중앙에 배치함
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
