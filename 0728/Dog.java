class Dog{
	String name="�ٵ���";
	/*�ν��Ͻ� �ʱ�ȭ ��!!!
		-�� Ŭ�����κ��� �����Ǵ� �ν��Ͻ��� ���������� �� ������ �����!!
	*/

	/*	class�� ���ʿ� �ε�Ǿ����� ����	*/
	static{
		System.out.println("static �ʱ�ȭ �� ����");
	}
	/*	Ŭ������ ���� �ν��Ͻ��� �����ɶ����� ����	*/
	{
		System.out.println("�ν��Ͻ��� �ʱ�ȭ �� ����");
	}

	public static void main(String[] args) {
		new Dog();//�̸� (���۷�������)�� ������ ���� ���ο��� �����Ҽ�����.
		Dog d  = new Dog();
		System.out.println(d.name);
	}
}
