/*
java.exe ����� ������ ������ �� �����͸� �Ѱܼ� �μ��� ���� ���ϴ� ���α׷�

�Ϲ������� java���� �⺻ �ڷ���(����,����, ����)�� ���� ����ȯ�� ��ü���� ����ȯ�� �����ϰ� �ִ�.
������, �⺻�ڷ����� ��ü�ڷ������� ����ȯ�� �����ұ�???
�����ϴ� ��, �⺻�ڷ������� ��ȯ�ɼ��ִ� ��� ����

"ture" --> true (String --> boolean)
"2"---> 2 (String ---> int)
Dog(��ü) ---> 1 (�Ұ��� �ϴ�...)
"3" --> '3' (String ---> char)

�ڹپ����� ��� �ڷ������� 1:1�� �����ϴ� Wrapper Ŭ������ ���� ��ü�ڷ����� �⺻�ڷ������� ����ȭ�� �����ϰ� �ִ�.

���� 
byte  :Byte
short : Short
int		:Integer
long  :Long
---------------------
�Ǽ�
float : Float
double : Double
----------------------
����
boolean : Boolean
*/

package main;
class Cal{
	public static void main(String[] args) 	{
		String n1=args[0]; // "1" --> 1 // String�� ��ü �ڷ��� -> �⺻�ڷ��� 
		String n2=args[1];
		
		int a=Integer.parseInt(n1); //���ڿ��� ����ȭ ��Ŵ
		int b=Integer.parseInt(n2); //���ڿ��� ����ȭ ��Ŵ
		System.out.println(n1+"��"+n2+"�� ����"+(a+b));
	}
}
