/*
������ ���� Ŭ�����̸� �繰�� ǥ������ ����..
String Ŭ������ ���� �˾ƺ���!!!
����) String Ŭ������ �츮�� �������� ���� �ܺ� Ŭ�����̸� Ư�� sun���� �����ϴ� javaSE�� �⺻ ��ü�̴�.
		������, ���� Ŭ�����ʹ� ������ ��Ű���� �����ϹǷ� ��Ģ�� import�Ͽ� �� ��ġ�� ����ؾ� �Ѵ�..
		but ���� ���� �ʴ� ������??/
		java.lang ��Ű���� �����ڰ� ������� �ʴ��� �̹� �ý��������� ��ΰ� �νĵǾ����ִ�..
		���� import ����� �ƴϴ�!!!!!!
		java.lang ��Ű���� ���α׷� ��� �ۼ��� ����� ������ ���� ���� ����ϴ� �ֿ� ��ü���� ��Ƴ��� ��Ű���̱⶧��...
*/
package com.iot.main;

class UseString{
	public static void main(String[] args){
		//�Ͻ���, ������(implicit) ������ <<>> ����� (explicit) ������
		String s="korea";		
		
		//����� (explicit) ������
		String s1 = new String("korea");
		
		for(int i =0; i < s.length() ; i++){
			System.out.println(s.charAt(i));
		}

	}
}
