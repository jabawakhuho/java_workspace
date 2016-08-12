/*
 800,700
메뉴바(파일, 편집, 보기, 검색, 문서,프로젝트,도구,브라우져 ,ZC , 창,도움말)
icon 메뉴
라인바 / TextArea
 
 */

package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Editor extends JFrame{
	JMenuBar menuBar;
	JMenu[] menu;
	JMenuItem[] fileMenu;
	String[] menuList = {"파일","편집","보기","검색","문서","프로젝트","도구","브라우져","ZC","창","도움말"};
	String[] menuItem={"새파일","열기","닫기","저장","새이름으로저장","종료"};
	JPanel p_center;
	JPanel p1;
	JPanel p2;
	JTextArea area;
	JScrollPane scroll;
	ArrayList<JLabel> line;
	int count=1;

	public Editor() {
		menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(800, 30));
		menu = new JMenu[menuList.length];
		for(int i =0; i < menuList.length ; i++){
			JMenu m = new JMenu(menuList[i]);
			menu[i] = m;
			menuBar.add(menu[i]);
		}
		createFileMenu(menuItem);
		
		p_center = new JPanel();
		p1= new JPanel();
		p2= new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(p_center);
		line = new ArrayList<JLabel>();
		createLine(count);

		p2.setBackground(Color.RED);
		//p2.setPreferredSize(new Dimension(700, 650));
		area.setPreferredSize(new Dimension(770, 770));
		p2.setPreferredSize(new Dimension(770, 770));
		p2.add(area);
		p_center.setLayout(new BorderLayout());
		p_center.setPreferredSize(new Dimension(800, 770));
		p1.setPreferredSize(new Dimension(30, 770));
		p_center.add(p1,BorderLayout.WEST);
		p_center.add(p2);
		
		area.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					createLine(count);
					p1.updateUI();
				}
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){

				}
			}
			public void keyPressed(KeyEvent e) {
			}
		});
		add(menuBar,BorderLayout.NORTH);
		add(scroll);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setVisible(true);
		
	}
	
	public void createLine(int i){
		JLabel la = new JLabel(Integer.toString(i));
		la.setBackground(Color.GREEN);
		la.setPreferredSize(new Dimension(20, 20));
		line.add(la);
		
		p1.add(line.get(i-1));
		count++;
	}
	
	public void createFileMenu(String[] menuItem){
		for(int i=0; i < menuItem.length ;i++){
			fileMenu = new JMenuItem[menuItem.length];
			JMenuItem item = new JMenuItem(menuItem[i]);
			fileMenu[i] = item;
			menu[0].add(fileMenu[i]);
		}
		menu[0].updateUI();
	}
	
	public void newFile(){
		
	}
	public static void main(String[] args) {
		new Editor();
	}

}
