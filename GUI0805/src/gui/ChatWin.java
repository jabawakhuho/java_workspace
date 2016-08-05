/*
java.awt�� OS �÷���(window,mac, linux)���� �������� Ʋ����.
���� �̸� ������ API�� Swing�� ����غ���.

 Swing Ư¡
 - javax.swing ��Ű������ ����
 - ������Ʈ�� awt ���� ���� ex) Button->JButton
 
 ����!!! - awt�� ���ؼ��� �ȵȴ�!!
 			��? ���� �������°� �̿ܿ��� ������ ���ȴ�!!
 			���) GUI ���α׷� ���߽� swing+ awt ����!!
 
 �ڹ��� GUI ���۳�Ʈ�� ������ ũ�� 2������ �ִ�.
 1.Container(���� �����ϴ� ������Ʈ) 
 	- JFrame(BorderLayout)
 	- JPanel(FlowLayout) : 
 	�����̳� �̴�.������ �ܵ����� �����Ҽ�����, �ݵ�� ������ �ȿ� �ҼӵǾ��ִ�.
 	Ư¡ - ���� ������ �ʴ´�.(html�� div���)
 	�ֿ뵵 - Frame ������ ������ ������ ���̾ƿ��� �����Ű�� ������ ���
 	
 	- Applet(FlowLayout)��
 	 
 2.Visual Component(���Դ��ϴ� ������Ʈ)
 	- JButton, JCheckbox,JTextArea���

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
		bt = new JButton("����");
		pan = new JPanel();
		
		pan.add(tf);
		pan.add(bt);
		
		add(ta,BorderLayout.CENTER);
		add(pan,BorderLayout.SOUTH);
		
		//������ â�� ������, ���μ����� ���̱�!!
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
