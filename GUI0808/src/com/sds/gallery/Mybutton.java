/*�������� �ƴ�����, JButton�� ��ӹ޾ƺ���!!
 * �� �׷���? ��� ������Ʈ�� �����ϰ��ִ� paint �޼����� ���縦 �˱�����
 * */
package com.sds.gallery;

import java.awt.Graphics;

import javax.swing.JButton;

public class Mybutton extends JButton{

	public Mybutton(String title){
		super(title);
	}
	/*��ư�� �׷����� ȣ��Ǵ� paint �޼��带 ������!!*/
	@Override
	public void paint(Graphics g) {
		//System.out.println("paintȣ��");
		super.paint(g);
	}
	
}
