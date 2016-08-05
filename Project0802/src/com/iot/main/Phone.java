/*
원하는 클래스를 정의하되 아래의 조건에 맞게 하시오
1. 2개 이상의 멤버 변수 정의
2. 2개 이상의 멤버 메서드 정의
3. 패키지는 com.iot.main에 넣기
4. main 메서드 없이 정의하기
5. class는 public으로 공개하기
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
