class  Computer{
	int memory=256;
	
	public void trunOn(){
		System.out.println("��ǻ�͸� �մϴ�.!!");
	}

	public static void main(String[] args){
		int k=5;
		Computer c=new Computer();
		System.out.println("k�� ����"+k);

		//c�� k�ʹ� Ʋ���� Data�� ���� ���� �ʰ�, ��ü�������� �޸𸮻��� ��ġ �� �ּҰ����� �����ϰ� �ִٰ� �Ͽ�,
		//referenece(����)������ �Ѵ�!!!!
		System.out.println("c�� ����"+c);

		c.trunOn();
	}
}
