/*
main() �޼����� �μ��� args�� ����غ���
main�� �����ڰ� ���Ҷ� ������� ȣ���Ҽ��ִ� �޼��尡 �ƴ϶�, ���ø����̼��� ���۵ɶ� ���� �ѹ� ȣ��Ǵ� �޼����̴�.
�� �� �޼���� java.exe�� ���� �ڵ� ȣ��ȴ�.
*/
package main;
class  MainTest{

	public static void main(String[] args) 	{
		System.out.println("���α׷� ����� �Ѱܹ��� �μ��� ������"+args.length);
		System.out.print("�Ѱܹ��� ������ ");
		for(int i=0; i< args.length ; i++){
			System.out.print(args[i]+" ");
		}
		System.out.println("�Դϴ�.");

	}
}
