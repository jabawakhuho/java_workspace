package com.huho.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.huho.json.jsonMovie;

public class ThumnailMove extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_center;
	JPanel p_south;
	JPanel p_mem;
	JMenuBar menuBar;
	JMenu	menu;
	String[] menuList;
	JButton bt_login;
	JPanel panel;
	Toolkit kit;
	Image img;
	JButton bt_left;
	JButton bt_right;
	Canvas can;
	jsonMovie jsonMovie;
	String path;
	int count=0;
	
	public ThumnailMove() {
		super("Movie");
		p_north = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		p_mem = new JPanel();
		bt_login = new JButton("로그인");
		menuBar = new JMenuBar();
		menu = new JMenu("메뉴");//TSET
		path = "C:/java_workspace/GUI0813/res/movie/movie.json";
		jsonMovie = new jsonMovie(new File(path));
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage(jsonMovie.movieList.get(count)[5]);
//		System.out.println(jsonMovie.movieList.get(0)[0]);
		
		p_mem.setLayout(null);
		bt_login.setBounds(350, 10,	 80, 20);
		bt_login.addActionListener(this);

		p_mem.setPreferredSize(new Dimension(460,50));
		p_mem.add(bt_login);
		
		menuBar.setPreferredSize(new Dimension(460,35));
		menuBar.add(menu);
		p_north.add(p_mem);
		p_center.setLayout(new BorderLayout());
		p_center.add(menuBar,BorderLayout.NORTH);
		
		p_north.setBackground(Color.YELLOW);
		
		//createThumnail();
		panel = new JPanel();
		bt_left = new JButton("◀");
		bt_right = new JButton("▶");
		bt_left.setPreferredSize(new Dimension(50, 515));
		bt_right.setPreferredSize(new Dimension(50, 515));
		bt_left.addActionListener(this);
		bt_right.addActionListener(this);
		can = new Canvas(){
	
			@Override
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, this);
			}
		};
		can.setPreferredSize(new Dimension(360, 515));
		panel.setLayout(new BorderLayout());
		panel.add(bt_left, BorderLayout.WEST);
		panel.add(can);
		panel.add(bt_right,BorderLayout.EAST);
		panel.setPreferredSize(new Dimension(460, 515));
		
		p_center.add(panel);
		p_north.setPreferredSize(new Dimension(390,50));
		p_center	.setPreferredSize(new Dimension(460	,540));
		p_south	.setPreferredSize(new Dimension(460	,100));
		p_center.setBackground(Color.GREEN);
		//p_south.setPreferredSize(new Dimension(390,40));
		p_south.setBackground(Color.PINK);
		
		
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		add(p_south,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(460, 700);
		setVisible(true);
	}
	//영화 썸네일 이미지
	
	public void createThumnail(){

	}
	
	public static void main(String[] args) {
		new ThumnailMove();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "◀" && count != 0){
			count--;
			img=kit.getImage(jsonMovie.movieList.get(count)[5]);
			can.repaint();
		}else if(e.getActionCommand() == "▶" && count != (jsonMovie.movieList.size()-1)){
			System.out.println(count);
			count++;
			img=kit.getImage(jsonMovie.movieList.get(count)[5]);
			can.repaint();
		}else if(e.getActionCommand() == "로그인"){
			new Login(this);
		}
	}

}
