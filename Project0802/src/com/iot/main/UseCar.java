package com.iot.main;

class UseCar{
	public static void main(String[] args){
		//자동차 1대를 메모리에 올리고 그차의 모든 부품의 메서드를 호출

		Car c = new Car();

		//객체를 메모리에 올리지 않고 실행(사용하려고)하면 null point exception이 발생한다.
		
		//Car의 객체 변수인 w,e,h는 private으로 은릭화 되었기 때문에 메서드를 동해 접근해야한다.
		c.getCar();

	}
}
