package com.iot.main;
//���� ��Ű���� �ֱ� ������ import �� �ʿ䰡 ����
//import com.iot.main.Account;

class UseAccount{
	public static void main(String[] args) 
	{
		//������ �ܰ� ���
		Account a = new Account();
		System.out.println("�Ѿ��� :"+a.getTotal());
		
		a.setTotal(780000);

		System.out.println("�Ѿ��� :"+a.getTotal());
	}
}
