/*
 클래스 안에 클래스를 둘수있는가?? 있다!!!!!
  
 */
/*
 내부익명클래스는 언제 필요할까?
 .java로 만드는 이유는 재사용을 하기 위해서 이다. 
 그렇기 때문에 해당 클래스내에서만 쓰고 다른 클래스들에서 쓸필요없는
 즉, 재사용성이 필요없는 것들은 해당 클래스의 익명 내부클래스로 만들어서 사용한다.
 
  */
package com.sds.ocjp;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonyTest extends JFrame{
	Canvas can;
	JButton bt1;
	JButton bt2;
		
	public AnonyTest() {
		//내부 익명 클래스..
		can = new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawLine(0, 0, 300, 400);
			}
		};
		
		add(can); //프레임의 센터에 켄버스 부착
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		
		bt1 = new JButton("버튼 1");
		bt2 = new JButton("버튼 2");
		//익명클래스 implements ActionListener{}
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("난버튼1");
			}
		});
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("난버튼2");
			}
		});
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new AnonyTest();
	}

}
