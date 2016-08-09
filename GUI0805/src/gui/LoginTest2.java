package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginTest2 extends JFrame{
	JLabel login;
	JLabel id;
	JLabel pwd;
	JTextField t_id;
	JTextField t_pwd;
	JButton bt1;
	JButton bt2;
	JPanel p_id;		
	JPanel p_pwd;		
	JPanel p_bt;		
	
	public LoginTest2() {
		super("login window");
		
		login = new JLabel("·Î±×ÀÎ");
		
		id = new JLabel("ID");
		pwd = new JLabel("Password");
		t_id = new JTextField(15);
		t_pwd = new JTextField(15);
		JPanel panel1= new JPanel();
		JPanel panel2= new JPanel();
		p_id = new JPanel();
		p_pwd = new JPanel();
		t_id.setBackground(Color.yellow);
		t_pwd.setBackground(Color.yellow);
		
		panel1.add(login);
		p_id.add(id);
		p_id.add(t_id);
		p_pwd.add(pwd);
		p_pwd.add(t_pwd);
		panel2.add(p_id);
		panel2.add(p_pwd);
		
		bt1 = new JButton("login");
		bt2 = new JButton("sign");
			
		p_bt = new JPanel();
		p_bt.add(bt1);
		p_bt.add(bt2);
		
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(p_bt,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LoginTest2();
	}

}
