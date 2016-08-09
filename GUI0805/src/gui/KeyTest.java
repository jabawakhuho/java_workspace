/*�ڹٱ���� ���ø����̼��� �̺�Ʈ ���� ����
 	1�ܰ�- �˸´� ������ �����ϱ�!!!
 	2�ܰ�- �������� �޼��� �������ϱ�!!!(�ҿ����� �޼��� �ϼ�)
 	3�ܰ�- �̺�Ʈ �ҽ�(�̺�Ʈ ����Ų ���۳�Ʈ)�� �����ʿ��� ����!! 
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyTest extends JFrame implements ActionListener, KeyListener{
	
	JTextField txt;
	JButton bt;
	
	public KeyTest() {
		setLayout(new FlowLayout());
		txt= new JTextField(15);
		bt= new JButton("��ư");
		
		//����Ŭ������ ����������, �������̹Ƿ� this�� ǥ���� �����ϴ�
		bt.addActionListener(this);
		txt.addKeyListener(this);
		
		add(txt);
		add(bt);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("�� ������");
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	











	public static void main(String[] args) {
		new KeyTest();
		
	}

}
