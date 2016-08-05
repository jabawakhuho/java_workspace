/*
실행을 위한 클래스이며 사물을 표현하지 않음..
String 클래스에 대해 알아보자!!!
참고) String 클래스는 우리가 정의하지 않은 외부 클래스이며 특히 sun에서 제공하는 javaSE의 기본 객체이다.
		하지만, 현재 클래스와는 별도의 패키지에 존재하므로 원칙상 import하여 그 위치를 명시해야 한다..
		but 에러 나지 않는 이유는??/
		java.lang 패키지는 개발자가 명시하지 않더라도 이미 시스템적으로 경로가 인식되어져있다..
		따라서 import 대상이 아니다!!!!!!
		java.lang 패키지는 프로그램 언어 작성시 상당히 비중이 높고 자주 사용하는 주요 객체들을 담아놓은 패키지이기때문...
*/
package com.iot.main;

class UseString{
	public static void main(String[] args){
		//암시적, 묵시적(implicit) 생성법 <<>> 명시적 (explicit) 생성법
		String s="korea";		
		
		//명시적 (explicit) 생성법
		String s1 = new String("korea");
		
		for(int i =0; i < s.length() ; i++){
			System.out.println(s.charAt(i));
		}

	}
}
