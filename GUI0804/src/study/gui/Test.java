package study.gui;

import java.awt.Frame;

public class Test {
	private String name;
	private int price;
	
	/*이클래스를 공부하는중*/
	
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
//		단축기 보는 명령어 ctrl +shift+l
		Frame f=new Frame("나제목");
		f.setVisible(true);
		f.setSize(300, 400);
		
	}

}
