/*버튼을 이용한 Image변환 할수있는 Gallery만들기*/

package com.sds.gallery;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gallery extends JFrame implements ActionListener{
	MyCanvas2 can; 
	JTextField txt;
	JButton undo;
	JButton redo;
	JPanel p;
		
	public Gallery() {
		super("Gallery");
		can = new MyCanvas2();
		txt = new JTextField(30);
		undo = new JButton("◀");
		redo = new JButton("▶");
		p = new JPanel();
		
		add(can);
		p.setLayout(new FlowLayout());
		
		p.add(undo);
		txt.setText(can.path[can.count]);
		p.add(txt);
		p.add(redo);
		
		undo.addActionListener(this);
		redo.addActionListener(this);
		
		
		add(p,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,650);
		setVisible(true);
	}
	
	//이전 이미지 보여주기
	public void prev(){
		//JOptionPane.showMessageDialog(this, "이전이미지");
		if(can.count <0){
			JOptionPane.showMessageDialog(this, "더이상이미지가없습니다.");
			can.count=0;
		}else{
			can.count--;
			can.repaint();
			txt.setText(can.path[can.count]);
		}
	}

	//다음 이미지 보여주기
	public void next(){
		//JOptionPane.showMessageDialog(this, "다음이미지");
		//MyCanvas2의 count변수를 바꿔준다
		if(can.count>can.imgs.length){
			JOptionPane.showMessageDialog(this, "더이상이미지가없습니다.");
			can.count=9;
		}else{
		can.count++;
		//다시 그려지기 요청 ~~ repaint()-->update() 화면 지우기--> paint() 다시 그림
		can.repaint();
		txt.setText(can.path[can.count]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj.equals(undo)){
			prev();
		}else if(obj == redo){
			next();
		}
		
	}
	
	public static void main(String[] args) {
		new Gallery();
	}


}
