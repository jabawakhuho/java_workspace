package animal;

class UseBird {
	public static void main(String[] args) 	{
		Duck d = new Duck();
		Bird b = new Bird();

		//������ ����� ���������� �ڹٿ����� ���� ��ü�� ���� ��ü�� ����Ű�� ���� �����ϴ�..1
		Bird bird = new Sparrow();
		System.out.println(bird.name);
		bird.wing();
	}
}
