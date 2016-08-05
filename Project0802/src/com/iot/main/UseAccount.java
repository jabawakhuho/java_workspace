package com.iot.main;
//같은 패키지에 있기 때문에 import 할 필요가 없음
//import com.iot.main.Account;

class UseAccount{
	public static void main(String[] args) 
	{
		//계좌의 잔고 출력
		Account a = new Account();
		System.out.println("총액은 :"+a.getTotal());
		
		a.setTotal(780000);

		System.out.println("총액은 :"+a.getTotal());
	}
}
