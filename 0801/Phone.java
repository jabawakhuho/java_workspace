/*
	�Ϲ����� ���α׷��� ����, �����ڰ� �������� �޼������ ���Ҷ� ����� ������ �ϰ� �ȴ�..
	�������� �ο��ؾ� ���� ������ �������Ƿ�....(�� �ƴ� Ÿ �����ڰ� �ҽ��� ���� �����Ҽ������Ƿ�..)

	�̰�� ������) ����� ����� �����Կ��� �ұ��ϰ� �޼������ ������ �ٸ��� ����Ѵٸ�, �����ڴ� ������Ģ�� ���ϴ���
	����� �ð��� �����ϰ� �ɰ��̴�.. ���� ������ ȿ������ ������ ���̴�...

	�ذ�å) ����� ����� �����ϴٸ� �ż��� ���� �����ϰ� �����Ҽ��ִ� ����� ���ȴ�..

	C# �� �ڹ� ����� �̷��� �޼��� ���� ����� �����Ѽ� �޼��� �����ε�..(method overloading)- �޼��� ��ø�̶� �Ѵ�.
	
	������!!!!!! 
	�ż���� �Ӹ� �ƴ϶� �޼��� ������ü�� ���� �����ϸ� �װ��� ���� �����̴�.
	���� �����Ϸ��� �����Ҽ��ִ� ����� �����ؾ� �ϴµ�, �װ��� �޼����� �Ű������� ������ �ڷ����� Ʋ���� �ؾ���.
*/

class Phone{
	
	/*��ȭ�� �ɴ�*/
	public void call(){
		System.out.println("��ȭ�� �̴ϴ�.");
	}

	/*�ؿܷ� ��ȭ�� �ɴ�.*/
	public void call(){
		System.out.println("�ؿܷ� ��ȭ�ϴ�");
	}

	public static void main(String[] args){
		Phone p = new Phone();
		p.call();
	}
}