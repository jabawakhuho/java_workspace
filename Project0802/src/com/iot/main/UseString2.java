package com.iot.main;

class UseString2{

	

	public static void main(String[] args) {
		String s1 = new String("apple");
		String s2= "apple";
		String s3="apple";
		String s4=new String("apple");
		
		//String�� ��ü�̹Ƿ� , s2�� s3�� ���۷��������̴�.
		//���� �Ʒ��� �ڵ�� ����񱳰� �ƴ϶� �ּ� ���̴�!!
		// �Ʒ��� �ڵ尡 true�� ������ ������ ���Ǯ�̶�� ������ �����Ǳ� �����̴�.
		// ���Ǯ�� Ư¡!! �ߺ��� ����� �ִٸ� ��������� �ʴ´�.
		System.out.println(s2==s3);

		
		System.out.println(s1==s2);
		System.out.println(s1==s4);

		//String ��ü�� �Һ�(immuterble=�����Ұ�)�� Ư¡���� ���Ͽ� �ڹ��� String���� �����̶�� ������ �������� �ʴ´�.
		String k="korea";
		k=k+"fighting";
		System.out.println(k);

		//�ذ�å??? ���������� ��ü�� �̿��ϴ°�..
		//���� String Ŭ������ �ƴ�!!1
		StringBuffer b = new StringBuffer();
		b.append("korea");
		b.append("fighting");
		
		//String �� �ƴϱ� ������ toString()�޼���� ��ȯ��Ų�� �������!!!
		System.out.println(b.toString());
	}
}
