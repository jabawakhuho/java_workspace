package music;
class UseMusic{
	public static void main(String[] args) 	{
		//실습: 추상클래스는 메모리에 올릴수있는가?
		// MusicDevice is abstract; cannot be instantiated
		//결론 : 인스턴스화 될수없다.
		//해결책 : 상속관계에서 자식의 인스턴스가 생성되기 직전에 부모의 인스턴스가 메모리에 먼저 올라가는 현상을 이용한다.
		//			즉, 자식에 의해서만 올릴수있다... 자식이 구현을 완료한후 인스턴스화 될때 같이 올라간다.!!
		//			-> 자식에서 미완성인 부모 메서드를 오버라이징 해줘야한다.
		//MusicDevice md = new MusicDevice();

	}
}
