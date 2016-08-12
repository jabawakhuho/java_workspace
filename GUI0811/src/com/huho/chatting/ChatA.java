/*Chat A,B,C 연결하기*/

package com.huho.chatting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField txt;
	JButton bt;
	JPanel p;
	ChatB chatB;
	ChatC chatC;
	boolean onB;//chatB창 열림/닫힘 유무 판단
	boolean onC;//chatC창 열림/닫힘 유무 판단
	FileReader reader;
	BufferedReader buffr;
	FileWriter writer;
	StringBuffer sb;
	String path="C:/java_workspace/GUI0811/res/1.txt";//생성  및 이전대화 로그  파일 경로
	
	
	public ChatA() {
		super("ChatA");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		txt = new JTextField(15);
		bt = new JButton("실행");
		p = new JPanel();
		showMessage();//area에 이전 대화 목록 보여주기
		
		add(scroll);
		p.setLayout(new FlowLayout());
		
		txt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					chatting();
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		bt.addActionListener(this);

		p.add(txt);
		p.add(bt);
		add(p, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 300, 400);
		setVisible(true);
		txt.requestFocus();
	}
	
	public void actionPerformed(ActionEvent e) {
		openChat();
		bt.setEnabled(false);
	}
	
	public void openChat(){
		if(!onB){
			chatB = new ChatB(this);
			chatB.area.setText(sb.toString());
		}
		if(!onC){
			chatC = new ChatC(this);
			chatC.area.setText(sb.toString());
		}
		chatB.setChatC(chatC);
		chatC.setChatB(chatB);
	}
	//입력 글 3자 체팅창으로 보내기
	public void chatting(){
		area.append("ChatA : "+txt.getText()+"\n");
		if(chatB!=null){
			chatB.area.append("ChatA : "+txt.getText()+"\n");
		}
		if(chatC!=null){
			chatC.area.append("ChatA : "+txt.getText()+"\n");
		}
		txt.setText("");
		createTxtFile();
	}
	
	//체팅글 파일로 만들기
	public void createTxtFile(){
		try {
			writer = new FileWriter(path);
			writer.write(area.getText()+"\n---이전글입니다.---");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "대화로그파일을만들수없습니다.");
			e1.printStackTrace();
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "파일만들기오류발생");
					e.printStackTrace();
				}
			}
			
		}
		
	}
	//체팅 시작시 이전 대화 내용 보여주기
	public void showMessage(){
		sb = new StringBuffer();
		try {
			reader = new FileReader(path);
			buffr = new BufferedReader(reader);
			String data;
			while(( data = buffr.readLine())!=null){
				sb.append(data+"\n");
			}
			area.setText(sb.toString());
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "대화로그파일을찾을수없습니다.");
			
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "대화로그파일을읽을수없습니다.");
			e.printStackTrace();
		}finally{
			if(buffr!=null){
				try {
					buffr.close();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(this, "파일읽기오류발생");
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new ChatA();
	}

}
