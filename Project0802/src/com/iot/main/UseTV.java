package com.iot.main;
class UseTV{

	public void getInfo(TV tv, int k){
		//�Ű����� tv�� �ν��Ͻ� �ϳ��� �Ѱܼ� �ش� tv�� ������ ����غ���
		tv.price=k;
		tv.printPrice();
	}
	
	public void test(boolean b, int k){
		System.out.println(b+","+k);
	}

	public void showPrice(){
		TV tv=new TV();
		tv.printPrice();
	}

	public static void main(String[] args) {
		UseTV usetv = new UseTV();
		usetv.showPrice();
		usetv.test(true, 4);

		TV tv1= new TV();
		usetv.getInfo(tv1,2000);
	}
}
