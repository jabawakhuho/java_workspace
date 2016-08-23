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
	Socket client;//대화용 소켓(전화기)
	String ip="70.12.112.100";
	int port=8888;
	BufferedReader buffr; //입력용
	BufferedWriter buffw; //출력용
	
	public ChatClient() {
		p_south = new JPanel();
		ta_msg = new JTextArea();
		ta_msg.setPreferredSize(new Dimension(250, 350));
		scroll = new JScrollPane(ta_msg);
		tf_insert = new JTextField(15);
		bt_con = new JButton("접속");
		
		bt_con.addActionListener(this);
		tf_insert.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					//서버에 메시지 보내기!!
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
	//서버에 접속하는 메서드 정의
	public void connect(){
		try {
			//ip와 port번호를 이용하여 서버에 접속!!!
			client = new Socket(ip,port); //접속이 발생
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw= new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (UnknownHostException e) {
			System.out.println("해당 ip를 찾을수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("네트워크 문제가 발생했어요~~");
			e.printStackTrace();
		}
	}
	
	//서버에 메세지 보내는 메서드
	public void sendMsg(){
		try {
			//MSG 전송
			String msg=tf_insert.getText();
			buffw.write(msg+"\n"); //메세지 보내기!! \n으로 입력이 완료되었다는것을 알려줘야
			buffw.flush();//물내리기
			
			//echo 받기!!!
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
