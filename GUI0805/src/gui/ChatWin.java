/*
java.awt는 OS 플랫폼(window,mac, linux)마다 디자인이 틀리다.
따라서 이를 보완한 API인 Swing을 사용해본다.

 Swing 특징
 - javax.swing 패키지에서 지원
 - 컴포넌트가 awt 거의 동일 ex) Button->JButton
 
 주의!!! - awt를 욕해서는 안된다!!
 			왜? 눈에 보여지는것 이외에는 아직도 사용된다!!
 			결론) GUI 프로그램 개발시 swing+ awt 조합!!
 
 자바의 GUI 컴퍼넌트의 종류는 크게 2가지가 있다.
 1.Container(남을 포함하는 컴포넌트) 
 	- JFrame(BorderLayout)
 	- JPanel(FlowLayout) : 
 	컨테이너 이다.하지만 단독으로 존재할수없고, 반드시 프레임 안에 소속되어있다.
 	특징 - 눈에 보이지 않는다.(html의 div흡사)
 	주용도 - Frame 내에서 별도의 개병적 레이아웃을 적용시키고 싶을때 사용
 	
 	- Applet(FlowLayout)등
 	 
 2.Visual Component(포함당하는 컴포넌트)
 	- JButton, JCheckbox,JTextArea등등

 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWin extends JFrame{
	JTextArea ta;
	JTextField tf ;
	JButton bt;
	JPanel pan;
	
	public ChatWin(String a){
		super(a);
		ta = new JTextArea();
		tf = new JTextField(15);
		bt = new JButton("전송");
		pan = new JPanel();
		
		pan.add(tf);
		pan.add(bt);
		
		add(ta,BorderLayout.CENTER);
		add(pan,BorderLayout.SOUTH);
		
		//윈도우 창을 닫으면, 프로세스도 죽이기!!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {

			ChatWin ch= new ChatWin("111");
			ChatWin ch2= new ChatWin("2");
			ChatWin ch3= new ChatWin("3");
		
		

	}

}
