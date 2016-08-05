class MyName{
	/*
	자바 스크립트와는 달리 변수에 의해 메모리에 올라갈 데이터는 반드시 그 크기가 명시되어야 한다.
	 = 자료형이라 한다.
	 */
	String name="이현호";
	int age= 31; 

	/*자바와 같은 컴파일 과정이 있는 모든 응용프로그램은 반드시 실행하기 위해서는 실행부라 불리는 시작 함수가 있어야한다.*/
	public static void main(String[] args){
		for(int i=0;i<20;i++){
			System.out.println("이현호");
		}
	}
}