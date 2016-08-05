package animal;

class UseBird {
	public static void main(String[] args) 	{
		Duck d = new Duck();
		Bird b = new Bird();

		//현실의 개념과 마찬가지로 자바에서도 상위 객체로 하위 객체를 가리키는 것이 가능하다..1
		Bird bird = new Sparrow();
		System.out.println(bird.name);
		bird.wing();
	}
}
