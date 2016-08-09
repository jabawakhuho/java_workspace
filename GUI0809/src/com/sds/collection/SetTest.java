/*
 순서 없이 모여있는 객체를 표현한 Set에 대하여 학습한다.
 Set의 하위 객체중 hashset을 학습하자!
 
 * */

package com.sds.collection;

import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;

public class SetTest {

	public static void main(String[] args) {
		// Generic Type : 컬렉션 프레임웍에 채워질 데이터형을 결정지을수있다. <자료형>으로 표현
		HashSet<JButton> set = new HashSet<JButton>();

		// auto boxing
		int x = 3;
		// Intger i = new Integer(3);
		/*
		 * set.add(x); //월래 에러나야 한다!!! 그런데 왜 안나나?? 컬렉션 프레임웍의 메서드인수로 int를 포함한
		 * 기본자료형을 명시하면 자동으로 Wrapper객체로 변환되어진다. 왜?? 개발자의 의도를 파악하여 번거롭지 않게 봐준것..
		 * 
		 * set.add("사과"); //String 객체가 들어감
		 */
		set.add(new JButton("나버튼"));
		set.add(new JButton("너버튼"));
		set.add(new JButton("요버튼"));

		//배경색을 모두 노란색으로
		Iterator it = set.iterator();//순서없는 Set을 하나씩 추출할수있도록 줄을 세움
		
		while(it.hasNext()){
			JButton bt=(JButton)it.next();
			System.out.println(bt.getText());
		}
	}

}
