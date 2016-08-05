package com.iot.main;

class UseString2{

	

	public static void main(String[] args) {
		String s1 = new String("apple");
		String s2= "apple";
		String s3="apple";
		String s4=new String("apple");
		
		//String은 객체이므로 , s2와 s3는 레퍼런스변수이다.
		//따라서 아래의 코드는 내용비교가 아니라 주소 비교이다!!
		// 아래의 코드가 true가 나오는 이유는 상수풀이라는 영역에 생성되기 때문이다.
		// 상수풀의 특징!! 중복된 상수가 있다면 재생성하지 않는다.
		System.out.println(s2==s3);

		
		System.out.println(s1==s2);
		System.out.println(s1==s4);

		//String 객체의 불변(immuterble=편집불가)의 특징으로 인하여 자바의 String에는 누적이라는 개념이 존재하지 않는다.
		String k="korea";
		k=k+"fighting";
		System.out.println(k);

		//해결책??? 편집가능한 객체를 이용하는것..
		//주의 String 클래스가 아님!!1
		StringBuffer b = new StringBuffer();
		b.append("korea");
		b.append("fighting");
		
		//String 이 아니기 때문에 toString()메서드로 변환시킨후 출력하자!!!
		System.out.println(b.toString());
	}
}
