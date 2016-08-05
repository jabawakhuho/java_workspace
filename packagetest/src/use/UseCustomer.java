/*
	클래스로 부터 생성되는 인스턴스간 무조건 서로 데이터를 접근할경우 보안상 문제가 발생할수 있으므로,
	자바 언어에서는 총4가지의 보안 등급을 지원한다!!!

	public < protected < default < private (보안 강도 순위)

	public : 아예 보안을 처리하지 않는 접근 제한자!!!
	protected : 같은 package 혹은 상속관계에 있는 인스턴스간 접근을 허용
	default : 오직 같은 package 내에 있는 인스턴스만 접근 허용
	private : 외부의 모든 인스턴스의 접근을 허용하지 않는 가장 강한 접근제한

*/
package use;
import bank.Customer;

class UseCustomer{
	public static void main(String[] args) 	{
	//고객의 현금 보유액을 100으로 바꾸자!!

		Customer c = new Customer();
		c.total=100;

		System.out.println(c.total);
	}
}
