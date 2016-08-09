/*
 java로 이미지 제어하기
 그림이 그려지기
 현실  : 그림그릴사람(주체) -> 도구1(붓),도구2(파렛트) -> 그려질 대상
Com :  컴퍼넌트스스로(자기자신을 그림) ->메서드(매개변수)-> 컴퍼넌트(자기자신) 
 ----------------------------------------------------------------------------
 JAVA의 모든 GUI 컴포넌트는 스스로 그림의 주체가 되어 스스로를 그린다. 이때 그림 그리는 행위는 Paint 메서드로
 표현되며, 이 Paint 메서드의 매개변수로 팔레트 역활의 객체인 Graphics 객체가 인수로 전달되어진다.
 ex)버튼이 소스로 그림을 증명...
 */
package com.sds.gallery;

import java.awt.Canvas;//아무것도 그려져 있지 않은 도화지 켄버스

import javax.swing.JFrame;

public class ImageTest extends JFrame {
	Mybutton bt;
	MyCanvas can;
	
	public ImageTest() {
		bt = new Mybutton("커스텀 버튼");
		can =new MyCanvas();
		add(can);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageTest();
	}

}
