/*
java.exe 실행시 연산을 수행할 두 데이터를 넘겨서 두수의 합을 구하는 프로그램

일반적으로 java언어는 기본 자료형(숫자,문자, 논리값)형 간의 형변환과 객체간의 형변환은 지원하고 있다.
하지만, 기본자료형과 객체자료형간의 형변환도 가능할까???
가능하다 단, 기본자료형으로 변환될수있는 대상만 가능

"ture" --> true (String --> boolean)
"2"---> 2 (String ---> int)
Dog(객체) ---> 1 (불가능 하다...)
"3" --> '3' (String ---> char)

자바언어에서는 모든 자료형마다 1:1로 대응하는 Wrapper 클래스를 통해 객체자료형과 기본자료형간의 형변화을 지원하고 있다.

정수 
byte  :Byte
short : Short
int		:Integer
long  :Long
---------------------
실수
float : Float
double : Double
----------------------
논리값
boolean : Boolean
*/

package main;
class Cal{
	public static void main(String[] args) 	{
		String n1=args[0]; // "1" --> 1 // String은 객체 자료형 -> 기본자료형 
		String n2=args[1];
		
		int a=Integer.parseInt(n1); //문자열을 정수화 시킴
		int b=Integer.parseInt(n2); //문자열을 정수화 시킴
		System.out.println(n1+"와"+n2+"의 합은"+(a+b));
	}
}
