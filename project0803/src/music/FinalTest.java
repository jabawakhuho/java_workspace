/*
final 수정자에 대해 알아보자

final 선언시 그후에는 변경이 불가능하다.
*/
package music;
class FinalTest{
	static int a =3;
	final int b =5;
	int c =5;

	public static void main(String[] args) 	{
		final int b=5;//이후의 문장에서는 더이상 변수의 값을 수정할수없다.
		b=10;
	}
}
