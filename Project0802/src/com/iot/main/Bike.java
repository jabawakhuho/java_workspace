package com.iot.main;

//package에 넣은 class는 공개하지 않으면 절대로 접근할수없다!!

/*
자바의 보안 4단계 등급(접근 제한자)
public < protected < default < private
public : 보안을 처리하지 않고 공개하는 접근제한자
			모든 객체의 접근을 허용해준다.
protected : 상속관계의 객체와 같은 패키지내에 있는 객체에게 접근을 허용
default : 오직 같은 패키지내에 있는 객체에게만 접근을 허용
private : 어떤 누구에게도 접근을 허용하지 않음..

*/
public class Bike{
	String name="혼다";
	public int price=2000;
	private int cc=1200;

	public void run(){
		System.out.println("바이크 출발");
	}


}
