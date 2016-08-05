/*문자 자료형에 대한 학습*/
class CharTest{
	public static void main(String[] args){
		//문자 자료형이란 사실상 존재하지 않는다. 
		// 왜? 어차피 문자는 곧 숫자로 바귀니깐...
		// 단 , 이 숫자의 목적은 연산 수행이 아닌 키코드값과 매핑 목적으로 사용해야한다.
		char x='a';
		char y=3; //가장좋아함!!
		char k=9;
		char z=-1;//키코드 맴핑이 목적임으로 음수는 지원하지 않는다!!!!!!!!!!

		System.out.println(y+k);
	}
}