/*
���ϴ� Ŭ������ �����ϵ� �Ʒ��� ���ǿ� �°� �Ͻÿ�
1. 2�� �̻��� ��� ���� ����
2. 2�� �̻��� ��� �޼��� ����
3. ��Ű���� com.iot.main�� �ֱ�
4. main �޼��� ���� �����ϱ�
5. class�� public���� �����ϱ�
*/

package  com.iot.main;

public class Phone{
	private String number="010-3919-6132";
	private String model="G pro";
	
	public String getNumber(){
		return number;
	}
	public void setNumber(String number){
		this.number=number;
	}
	
	public String getModel(){
		return model;
	}
	public void setModel(String model){
		this.model=model;
	}
}
