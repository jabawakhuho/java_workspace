/*
	������ �����͸� ��Ƽ� �����Ҷ����� �ݵ�� ������ ��Ե� �������� �뷮�� ǥ���ؾ� �ϴµ�,
	�� �뷮ǥ�ø� �ڷ����̶� �Ѵ�.
	�����ڰ� �����ϱ�� ������, �����ڰ� �޸� �뷮�� �����������ִ�.(���� ������ ����)

	1. ���� : char (2byte)
	2. ���� : byte(1byte)< short(2byte)< int(4byte) , <long(8byte)
	3. ���� : boolean(1byte)
*/
class DataType{
	public static void main(String[] args){
		//���� �ڷ���!! (�ɸ�����
		char c='��';//���ڿ��� �ƴ� �ϳ��� ���ڴ� Ȭ����ǥ
		//byte ¥�� �����Ͱ� �� 4�� Ȯ�� = 8byte;
		char[] arr=new char[4];
		arr[0]='��';
		arr[1]='��';
		arr[2]='��';
		arr[3]='��';
		for(int i=0; i<arr.length;i++){
			System.out.println("c�� ���� "+arr[i]);
		}

		char[] arr2={'��','��','��','ī'};
		
		for(int i=0; i<arr2.length;i++){
			System.out.print(arr2[i]);
		}

		//
		boolean m=true;
	}
}