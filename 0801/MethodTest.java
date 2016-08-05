/*
	클래스를 구성하는 요소는 단 2가지 뿐이 없다.
	메서드에 대해 학습한다.
*/

class MethodTest{
	/*
		자바의 메서드의 표기법은 총 3단계로 구성된다.
		맨압 : 접근 제한자
		가운데 : 반환여부를 표기
					반환값이 없는 메서드의 경우엔 반드시 void를 표기한다.
		맨끝 : 메서드명
	*/

	public void sum(){
	
	}
	
	//반환값 있는 메서드 정의 : 리턴값에 맞는 자료형을 표기한다.
	//java의 자료형은 문자,숫자,논리값, 객체 자료형 총 4가지가 있다.
	public int sum2(){
		return 3;
	}

	public boolean sum3(){
		return true;
	}

	public char sum4(){
		return 'a';
	}

	//자바도 다른 언어와 마찬가지로 매개변수를 지원한다.
	//매개변수를 선언할때는 자바의 변수와 같이 해당 변수의 자료형을 선언하여 준다
	public void sum5(int a){

	}
}
