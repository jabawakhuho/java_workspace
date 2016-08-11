package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUICopy extends JFrame{
	JLabel la_ori, la_dest;
	JTextField t_ori, t_dest;
	JButton bt_ori, bt_dest;
	JButton bt_copy;
	JPanel p_center;
	JPanel p_south;
	JFileChooser chooser; //File탐색기 객체
	//GUICopy gc;
	FileInputStream fis;//파일을 대상으로한 입력 스트림
	FileOutputStream fos;//파일을 대상으로한 출력 스트림
	
	public GUICopy() {
		//gc=this;
		
		la_ori  =new JLabel("원본 선택");
		la_dest  =new JLabel("복사 경로");
		t_ori  = new JTextField(25);
		t_dest = new JTextField(25);
		bt_ori = new JButton("찾기");
		bt_dest = new JButton("열기");
		bt_copy = new JButton("복사시작");
		p_center = new JPanel();
		p_south = new JPanel();
		chooser = new JFileChooser("C:/html_workspace/images");
		//디자인 
		t_ori.setBackground(Color.YELLOW);
		t_ori.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		
		t_dest.setBackground(Color.YELLOW);
		t_dest.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		
		p_center.add(la_ori);
		p_center.add(t_ori);
		p_center.add(bt_ori);
		p_center.add(la_dest);
		p_center.add(t_dest);
		p_center.add(bt_dest);		
		
		p_south.add(bt_copy);
		
		add(p_center);
		add(p_south, BorderLayout.SOUTH);
		
		//이벤트 구현
		bt_ori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result=chooser.showOpenDialog(getParent());
				//열기를 누르면 -> t_ori에 경로에 출력
				if(result==chooser.APPROVE_OPTION){
					File file = chooser.getSelectedFile();
					String path = file.getAbsolutePath();//절대경로반환
					t_ori.setText(path);
				}
			}
		});
		bt_dest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result =chooser.showSaveDialog(getParent());
				
				if(result==chooser.APPROVE_OPTION){
					File file = chooser.getSelectedFile();
					String path = file.getAbsolutePath();//절대경로반환
					t_dest.setText(path);
				}
			}
		});
		
		//복사 실행
		bt_copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copy();
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(450, 150);
	}
	//복사실행메서드 : 입력스트림으로 읽어들인 파일의 data를 출력 스트림으로 파일에 출력하는것
	public void copy(){
		
		try {
			fis = new FileInputStream(t_ori.getText());
			fos = new FileOutputStream(t_dest.getText());
			//데이터 읽어들이기 시작
			int data;
			while((data =fis.read())!=-1){
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this, "복사 완료");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(this, "입출력에러");
			e.printStackTrace();
		} finally{
			//모든 연결되어있는 스트립 자원 닫기
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new GUICopy();
	}

}
