/*Frame(300,400)
 *버튼
 **/
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*//자바에서는 마우스 누르는 이벤트를 Click이라고 부르지 않는다.
// ActionEvent라 한다.
//GUI 컴퍼넌트상에서 클릭이벤트가 발생하면, 제일먼저 OS가 감지하여 
  알맞는 정보를 JVM에 넘지면, 이제서야 JVM은 해당 이벤트에 알맞는 Event 객체를 메모리에 올린다.
 마우스 클릭 -> Window감지 -> jvm 전달 -> ActionEvent 객체인스턴스 생성 -> 리스너에 전달
*/
public class EventTest extends JFrame implements ActionListener{
	JButton bt;
	JButton bt2;
			
	public EventTest(){
		setLayout(new FlowLayout());
		
		bt = new JButton("왼쪽버튼");
		bt2 = new JButton("우측버튼");
		add(bt);	
		add(bt2);	
		
		//버튼과 리스너와의 연결!!!!
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
	
	//jdk 5부터 지원하는 어노테이션이라는 주석!!!
	//일반 주석과 틀린점? 프로그램 실행시 사용될 수있는 주석
	@Override
	
	//아래의 메서드는 사용자가 actionEvent를 일으킬때마다 호출된다!! 그리고 매개변수로
	//해당 ActionEvent 인스턴스가 전달된다!!!
	
	//이벤트를 일으킨 주체 컴포넌트를 자바에서는 이벤트소스라 한다.
	//따라서 현재 action 이벤트를 일으킨 주체는 버튼이므로, 버튼이 이벤트소스가 된다.
	public void actionPerformed(ActionEvent e) {
		//Action 이벤트는 반드시 버튼에만 적용활수있는 이벤트가 아니라 다른 컴포넌트도 ActionEvent를 일으킬수있다.
		//따라서 sun에서는 현재 발생한 이벤트가 버튼에 의한것인지, 다른 컴포넌트에 의한 것인지 예측할수없으므로,
		// 가장 상위인 Object 형으로 받아버린다..
		Object obj=e.getSource();
		JButton btn=(JButton)obj;
		//System.out.println(btn.getActionCommand()+"누름");
		if(btn==bt){
			System.out.println("좌측버튼 누름");
		}else if(btn==bt2){
			System.out.println("우측버튼 누름");
		}
	}

	public static void main(String[] args) {
		EventTest et = new EventTest();
	}
}
