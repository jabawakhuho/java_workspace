class Duck {
	/*이름, 나이*/

	String name="도날드";
	//int age=3;
	static int age=3; //클래스 변수(인스턴스에 소속되지 않고 클래스 원본에 소속된다고 하여.....)

	public void test(){
		System.out.println("오리의 나이는"+age);
	}
	
	public static void test2(){
		System.out.println("오리의 이름은"+name);
	}

	public static void main(String[] args) 
	{
		int x=3;
		int y=5;
		Duck d1= new Duck();
		Duck d2= new Duck();
		

	//	d1.age=5;
	//	System.out.println(d2.age);
		d1.test2(); // static에선 class변수가 아닌 인스턴스 변수는 reference없이는 참조할수없다.
	//	Duck.age=7; //거푸집이 보유한 변수이므로, 이런 표현이 가능~
	}
}
