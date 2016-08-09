/*
Layout null
 * */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginTest extends JFrame{
	JLabel login;
	JLabel id;
	JLabel pwd;
	
	JTextField t_id;
	JTextField t_pwd;
	JButton bt1;
	JButton bt2;
//	Panel p_id;
//	Panel p_pwd;
	Panel p_bt;
	
	public LoginTest() {
		super("login화면");
		setLayout(null);
		login = new JLabel("로그인");
		id = new JLabel("ID");
		pwd = new JLabel("Password");
		t_id = new JTextField(15);
		t_pwd = new JTextField(15);
		bt1 = new JButton("login");
		bt2 = new JButton("sign");
		
		login.setBounds(180, 10, 100, 50);
		id.setBounds(10, 50, 100, 20);
		t_id.setBounds(150, 50, 200, 20);
		pwd.setBounds(10, 100, 100, 20);
		t_pwd.setBounds(150, 100, 200, 20);
		bt1.setBounds(50, 150, 100, 50);
		bt2.setBounds(160, 150, 100, 50);
		
	
		add(login);
		add(id);
		add(t_id);
		add(pwd);
		add(t_pwd);
		add(bt1);
		add(bt2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,500);
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginTest();
	}

}
