package study.gui;

import java.awt.Frame;

public class Test {
	private String name;
	private int price;
	
	/*��Ŭ������ �����ϴ���*/
	
	public Test() {
	
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public static void main(String[] args) {
//		����� ���� ��ɾ� ctrl +shift+l
		Frame f=new Frame("������");
		f.setVisible(true);
		f.setSize(300, 400);
		
	}

}
