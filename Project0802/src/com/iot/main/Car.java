/*
현실의 자동차를 만들되 제대로 만들자
*/

package com.iot.main;
/*
클래스가 보유한 변수가 객체자료형일 경우 
Car has a Wheel : has a 관계
*/
public class Car{
	//바퀴,엔진, 핸들
	private Wheel w; //사용자 정의 인 Wheel형이다
	private Engine e; //초기화 하지 않을시 null로 초기화함 : 레퍼런스가 존재하지 않음
	private Handle h;
	private int price;

	//생성자를 정의하여 초기화 작업을 진행하자!
	public Car(){
		w= new Wheel();
		e= new Engine();
		h=new Handle();
	}
	
	public void getCar(){
		w.roll();
		e.bound();
		h.control();
	}
	
}
