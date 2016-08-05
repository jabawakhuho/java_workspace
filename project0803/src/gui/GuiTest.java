/*--------------------------------------------------------------
자바도 다른 응용프로그램처럼, GUI를 지원한다.
예) window,button, checkbox, TextArea 등등을 지원~

자바에서 GUI 컴포넌트는 awt 패키지에서 지원한다.
API 문서 보기

>Constructors(생성자)>
--------------------------------------------------------------*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Choice;


class  GuiTest{
	public static void main(String[] args)	{
		//모든 GUI 컴포넌트가 올려질 window 창
		//자바에서 프레임은 디폴트 속성이 존재하는데, 기본이 보이지않는 속성을 가지고 있다.
		//따라서 보이게 하자!!
		Frame win = new Frame();
		win.setVisible(true); //보이게 하기
		win.setSize(300,400);
		win.setTitle("내꺼");

		Button bt = new Button("눌러");
		//자바 언어도 HTML처럼 각 컴포넌트를 부착하기에 앞서 어디에 어떻게 붙일지에 대한 디자인 기능이 지원된다.
		// 이 예제에서는 무시하고 가겠다.
		FlowLayout flow = new FlowLayout();
		win.setLayout(flow); //배치방법을 결정하는 메서드..

		//버튼을 프레임에 부착하자!!!!
		win.add(bt);

		//checkbox
		//자바에서는 객체형도 자료형이다.. 따라서 배열도 얼마든지 가능하다.
		Checkbox[] ch= new Checkbox[20];
		
		for(int i =0; i < ch.length ; i++){
			Checkbox c = new Checkbox(i+"번째박스");
			ch[i] = c;
			win.add(ch[i]);
		}

		//TextField
		TextField tf = new TextField("1234",40); 
		win.add(tf);

		//TextArea
		TextArea ta = new TextArea(5,10);
		win.add(ta);
		
		Choice c1 = new Choice();
		for(int i=1; i <= 12 ; i++){
		

		c1.add(Integer.toString(i)); // i를 String으로 변환 시켜줘야한다. 왜냐하면 Choice의 add(String A)메서드의 인수가 String 을 원하기 때문 API문서 참조!!!

		}

		win.add(c1);

	}
}
