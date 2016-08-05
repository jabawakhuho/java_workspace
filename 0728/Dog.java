class Dog{
	String name="바둑이";
	/*인스턴스 초기화 블럭!!!
		-이 클래스로부터 생성되는 인스턴스가 있을때마다 이 영역이 수행됨!!
	*/

	/*	class가 최초에 로드되어질때 수행	*/
	static{
		System.out.println("static 초기화 블럭 수행");
	}
	/*	클래스로 부터 인스턴스가 생성될때마다 수행	*/
	{
		System.out.println("인스턴스가 초기화 블럭 수행");
	}

	public static void main(String[] args) {
		new Dog();//이름 (레퍼런스변수)이 없으면 이후 라인에서 제어할수없다.
		Dog d  = new Dog();
		System.out.println(d.name);
	}
}
