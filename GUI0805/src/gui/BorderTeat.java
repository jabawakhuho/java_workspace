/*
 자바의 GUI관련 API들은 java.awt 패키지 에서 지원한다.
 특히 윈도우와 같이 다른 컴포넌트들을 포함할수있는 객체는
 배치의 문제를 고민해야 하며, 이 배치의 종류엔 5가지가 있다.
 그중 BorderLayout을 학습한다.
 borderLayout : 동,서,남,북,센터 5가지 
  */
package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class BorderTeat {

	public static void main(String[] args) {
		Frame frame=new Frame();
		
		Button bt_north= new Button("북쪽");
		Button bt_west= new Button("서쪽");
		Button bt_center= new Button("가운데");
		Button bt_east= new Button("동쪽");
		Button bt_south= new Button("남쪽");
		
		//BorderLayout을 적용하자!!
		BorderLayout layout = new BorderLayout();
		
		//frame에 layout을 적용하자
		//개발자가 layout을 정하지 않으면, 해당 객체의 디폴트 배치관리자가 적용되고,
		//Frame의 경우 디폴트 배치관리자는 BorderLayout 이다!!! 
		//또한BorderLayout 개발자가 방위를 지정하지 않으면 CENTER이다!!!
		frame.setLayout(layout);
		
		frame.add(bt_north, BorderLayout.NORTH);
		//버튼의 크기를 조정하는 Class > Dimension
		bt_west.setPreferredSize(new Dimension(100, 400));
		frame.add(bt_west, BorderLayout.WEST);
		frame.add(bt_center, BorderLayout.CENTER);
		frame.add(bt_east, BorderLayout.EAST);
		frame.add(bt_south, BorderLayout.SOUTH);
		
	
		frame.setSize(500,400);
		frame.setVisible(true);
		
	}

}
