class Duck {
	/*�̸�, ����*/

	String name="������";
	//int age=3;
	static int age=3; //Ŭ���� ����(�ν��Ͻ��� �Ҽӵ��� �ʰ� Ŭ���� ������ �Ҽӵȴٰ� �Ͽ�.....)

	public void test(){
		System.out.println("������ ���̴�"+age);
	}
	
	public static void test2(){
		System.out.println("������ �̸���"+name);
	}

	public static void main(String[] args) 
	{
		int x=3;
		int y=5;
		Duck d1= new Duck();
		Duck d2= new Duck();
		

	//	d1.age=5;
	//	System.out.println(d2.age);
		d1.test2(); // static���� class������ �ƴ� �ν��Ͻ� ������ reference���̴� �����Ҽ�����.
	//	Duck.age=7; //��Ǫ���� ������ �����̹Ƿ�, �̷� ǥ���� ����~
	}
}
