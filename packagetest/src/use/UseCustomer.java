/*
	Ŭ������ ���� �����Ǵ� �ν��Ͻ��� ������ ���� �����͸� �����Ұ�� ���Ȼ� ������ �߻��Ҽ� �����Ƿ�,
	�ڹ� ������ ��4������ ���� ����� �����Ѵ�!!!

	public < protected < default < private (���� ���� ����)

	public : �ƿ� ������ ó������ �ʴ� ���� ������!!!
	protected : ���� package Ȥ�� ��Ӱ��迡 �ִ� �ν��Ͻ��� ������ ���
	default : ���� ���� package ���� �ִ� �ν��Ͻ��� ���� ���
	private : �ܺ��� ��� �ν��Ͻ��� ������ ������� �ʴ� ���� ���� ��������

*/
package use;
import bank.Customer;

class UseCustomer{
	public static void main(String[] args) 	{
	//���� ���� �������� 100���� �ٲ���!!

		Customer c = new Customer();
		c.total=100;

		System.out.println(c.total);
	}
}
