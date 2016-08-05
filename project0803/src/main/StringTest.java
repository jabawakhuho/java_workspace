/*
String 클래스의 특징
- 불변이므로 많이 선언시 메모리 효율성을 떨어트린다.
- 이러한 것을 막기위해 contants pool을 이용하여 재활용을 한다 단, String이 암묵적 묵시적 생성시에만.....
*/
/*
자바의 모든 클래스는 (개발자가 정의한 클래스건 sun이 제공하는 api건 모두 Object라는 최상위 객체를 상속받는다!!!
*/
package main;
class StringTest{
	public void test(){
		boolean b = this.equals("대한민국");
	}
	public static void main(String[] args) 
	{
		String a="대한민국";
		String b="대한민국";

		System.out.println(a.equals(b));
	}
}
