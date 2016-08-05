package car;
class UseCar{

	public static void main(String[] args){
		Truck t = new Truck();
		Bus b = new Bus();
		/*
		특정 (같은)자료형으로 호출한 메서드가 서로 다른 동작을 구현할때~~ 다형성이라 한다.!!!!
		*/
		Car c=t;
		c.go();//트럭

		Car c2=b;
		c2.go();//버스

	}
}
