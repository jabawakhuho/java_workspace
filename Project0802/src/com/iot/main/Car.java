/*
������ �ڵ����� ����� ����� ������
*/

package com.iot.main;
/*
Ŭ������ ������ ������ ��ü�ڷ����� ��� 
Car has a Wheel : has a ����
*/
public class Car{
	//����,����, �ڵ�
	private Wheel w; //����� ���� �� Wheel���̴�
	private Engine e; //�ʱ�ȭ ���� ������ null�� �ʱ�ȭ�� : ���۷����� �������� ����
	private Handle h;
	private int price;

	//�����ڸ� �����Ͽ� �ʱ�ȭ �۾��� ��������!
	public Car(){
		w= new Wheel();
		e= new Engine();
		h=new Handle();
	}
	
	public void getCar(){
		w.roll();
		e.bound();
		h.control();
	}
	
}
