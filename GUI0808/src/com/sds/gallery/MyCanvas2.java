/*
 * 컴포넌트 중 Canvas를 상속받아 개발자가 주도하여 그림을 그려보도록 한다!!!
 * paint 메서드 재정의 해보자!!!
 * */
package com.sds.gallery;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class MyCanvas2 extends Canvas {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Image[] imgs;
	String[] path = { "C:/java_workspace/GUI0808/res/ball1.png", "C:/java_workspace/GUI0808/res/ball2.png",
			"C:/java_workspace/GUI0808/res/ball3.png", "C:/java_workspace/GUI0808/res/ball4.png",
			"C:/java_workspace/GUI0808/res/ball5.png", "C:/java_workspace/GUI0808/res/ball6.png",
			"C:/java_workspace/GUI0808/res/ball7.png", "C:/java_workspace/GUI0808/res/ball8.png",
			"C:/java_workspace/GUI0808/res/ball9.png", "C:/java_workspace/GUI0808/res/ball10.png" };
	int count = 0;
	Gallery gallery;

	public MyCanvas2() {
		imgs = new Image[path.length];
		// getSrc();
		for (int i = 0; i < imgs.length; i++) {
			imgs[i] = kit.getImage(path[i]);
		}
		
	
	}
	


	public void Paint(Graphics g) {
		g.drawImage(imgs[count], 0, 0, 700, 600, this);
	}
}
