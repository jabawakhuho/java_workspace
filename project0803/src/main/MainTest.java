/*
main() 메서드의 인수인 args를 사용해본다
main은 개발자가 원할때 마음대로 호출할수있는 메서드가 아니라, 어플리케이션이 시작될때 최초 한번 호출되는 메서드이다.
또 이 메서드는 java.exe에 의해 자동 호출된다.
*/
package main;
class  MainTest{

	public static void main(String[] args) 	{
		System.out.println("프로그램 실행시 넘겨받은 인수의 갯수는"+args.length);
		System.out.print("넘겨받은 과일은 ");
		for(int i=0; i< args.length ; i++){
			System.out.print(args[i]+" ");
		}
		System.out.println("입니다.");

	}
}
