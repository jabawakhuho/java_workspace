/*
 5가지 배치관리자중  GridLayout 을 학습한다.
 grid : 격자(모눈종이 Table형태), row(가로) , colum(세로)
 
 java.awt 패키지는 os 플랫폼에 따라 디자인이 제각각이라서 이를 보완한 GUI 패키지를 사용한다.
 */
package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setLayout(new GridLayout(4,5));
		
		//button 20개를 생성하여 제목은 버튼 1,2ㅗ 하시오
		Button[] bt = new Button[20];
		
		for(int i = 0; i < bt.length; i++){
			bt[i]=new Button("버튼"+(i+1));
			frame.add(bt[i]);
			
		}
		
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

}
