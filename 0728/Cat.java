/*-----------------------------------------------------------------------------------
1.Cat이라는 이름의 고양이 클래스를 정의하되, 
  이름 나이 종과를 멤버로 보유하시오.

2.종과는 static으로 선언하시오

3.현제 클래스에 main 실행부를 두되 고양이의 이름, 나이 종류를 출력하시오

--------------------------------------------------------------------------------------*/

class  Cat{
	String name="나비";
	int age=3;
	static String type="고양이과";


	public static void main(String[] args){
		Cat c = new Cat();
		System.out.println("이름:"+c.name);
		System.out.println("나이:"+c.age);
		System.out.println("과 :"+Cat.type);
	}
}
