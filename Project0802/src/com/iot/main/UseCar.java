package com.iot.main;

class UseCar{
	public static void main(String[] args){
		//�ڵ��� 1�븦 �޸𸮿� �ø��� ������ ��� ��ǰ�� �޼��带 ȣ��

		Car c = new Car();

		//��ü�� �޸𸮿� �ø��� �ʰ� ����(����Ϸ���)�ϸ� null point exception�� �߻��Ѵ�.
		
		//Car�� ��ü ������ w,e,h�� private���� ����ȭ �Ǿ��� ������ �޼��带 ���� �����ؾ��Ѵ�.
		c.getCar();

	}
}
