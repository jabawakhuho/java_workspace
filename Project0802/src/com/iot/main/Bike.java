package com.iot.main;

//package�� ���� class�� �������� ������ ����� �����Ҽ�����!!

/*
�ڹ��� ���� 4�ܰ� ���(���� ������)
public < protected < default < private
public : ������ ó������ �ʰ� �����ϴ� ����������
			��� ��ü�� ������ ������ش�.
protected : ��Ӱ����� ��ü�� ���� ��Ű������ �ִ� ��ü���� ������ ���
default : ���� ���� ��Ű������ �ִ� ��ü���Ը� ������ ���
private : � �������Ե� ������ ������� ����..

*/
public class Bike{
	String name="ȥ��";
	public int price=2000;
	private int cc=1200;

	public void run(){
		System.out.println("����ũ ���");
	}


}
