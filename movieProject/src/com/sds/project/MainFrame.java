package com.sds.project;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	public static final int WIDTH=400;
	public static final int HEIGHT=700;

	JPanel main;
	//TopPlanel ฐüทร
	MainTop mainTop;
	MainPanel mainPanel;
	MovieInfo movieInfo;
	
	public MainFrame() {
		main = new JPanel();
		main.setLayout(new BorderLayout());
		
		setMainPanel();
		
		add(main);
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	public void setMovieInfoPanel(){
		main.remove(mainPanel);
		movieInfo = new MovieInfo("");
		main.add(movieInfo);
		main.updateUI();
	}
	
	public void setRegistPanel(){
		main.removeAll();
		RegistForm registForm = new RegistForm(this);
		main.add(registForm);
		main.updateUI();
	}

	public void setMainPanel(){
		main.removeAll();
		mainTop = new MainTop(WIDTH, 70,this);
		mainPanel = new MainPanel(WIDTH,HEIGHT-mainTop.getWidth(),this);
		
		main.add(mainTop,BorderLayout.NORTH);
		main.add(mainPanel);
		main.updateUI();
		
		
	}
	
	public static void main(String[] args){
		new MainFrame();
	}
}
