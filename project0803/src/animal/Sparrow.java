package animal;
public class Sparrow extends Bird{

	/*
	��ӽ�, �ڽ� Ŭ������ �θ�Ŭ������ �޼��带 ������ �����ϰ� �������Ҽ��ִ� �޼��� ���� ����� ������ override�� �Ѵ�.
	�����ε�(overload) - ��Ŭ���������� �޼������ �����ϰ� �ۼ��ϴ� ���
	�������̵� - ��Ӱ��迡�� �θ� �޼��带 ������
	*/
	boolean isBury=true;
	String name="����";
	public void wing(){
		System.out.println("������ �������ϴ�");
	}
}
