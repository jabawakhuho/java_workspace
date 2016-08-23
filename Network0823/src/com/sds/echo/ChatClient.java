package com.sds.echo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{
	JPanel p_center,p_south;
	JTextArea ta_msg;
	JScrollPane scroll;
	JTextField tf_insert;
	JButton bt_con;
	Socket client;//��ȭ�� ����(��ȭ��)
	String ip="70.12.112.100";
	int port=8888;
	BufferedReader buffr; //�Է¿�
	BufferedWriter buffw; //��¿�
	
	public ChatClient() {
		p_south = new JPanel();
		ta_msg = new JTextArea();
		ta_msg.setPreferredSize(new Dimension(250, 350));
		scroll = new JScrollPane(ta_msg);
		tf_insert = new JTextField(15);
		bt_con = new JButton("����");
		
		bt_con.addActionListener(this);
		tf_insert.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					//������ �޽��� ������!!
					sendMsg();
				}
			
			}
		});
		p_south.add(tf_insert);
		p_south.add(bt_con);
		
		
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	//������ �����ϴ� �޼��� ����
	public void connect(){
		try {
			//ip�� port��ȣ�� �̿��Ͽ� ������ ����!!!
			client = new Socket(ip,port); //������ �߻�
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw= new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (UnknownHostException e) {
			System.out.println("�ش� ip�� ã���� �����ϴ�.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��Ʈ��ũ ������ �߻��߾��~~");
			e.printStackTrace();
		}
	}
	
	//������ �޼��� ������ �޼���
	public void sendMsg(){
		try {
			//MSG ����
			String msg=tf_insert.getText();
			buffw.write(msg+"\n"); //�޼��� ������!! \n���� �Է��� �Ϸ�Ǿ��ٴ°��� �˷����
			buffw.flush();//��������
			
			//echo �ޱ�!!!
			String data=buffr.readLine();
			ta_msg.append(data+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		connect();
	}
	
	
	public static void main(String[] args) {
		new ChatClient();
	}

}
