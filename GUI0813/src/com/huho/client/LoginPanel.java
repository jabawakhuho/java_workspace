package com.huho.client;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{
	JLabel lb_id;
	JLabel lb_pwd;
	JTextField tf_id;
	JTextField tf_pwd;
	JButton bt_panel;
	JButton bt_login;
	boolean flag = false;
	
	public LoginPanel(int width,int height) {
		createBt(bt_panel,"+");
		setPreferredSize(new Dimension(width, height));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		flag=!flag;
		Object obj=e.getSource();
		/*System.out.println(flag);
		System.out.println(obj);*/
		if(obj.equals(bt_panel)){
			createLogin();
			createBt(bt_login,"·Î±×ÀÎ");
		}/*else if(obj.equals(bt_panel)&&flag==false){
			removeAll();
			createBt(bt_panel,"+");
		}else if(obj.equals(bt_login)){
		
		}*/
		updateUI();
	}
	
	public void createLogin(){
		lb_id = new JLabel("ID");
		lb_pwd = new JLabel("PW");
		tf_id = new JTextField(8);
		tf_pwd = new JTextField(8);
		
		add(lb_id);
		add(tf_id);
		add(lb_pwd);
		add(tf_pwd);
	
	}
	
	public void createBt(JButton bt,String name){
		bt = new JButton(name);
		bt.addActionListener(this);
		add(bt);
	}
}

