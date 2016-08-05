/*Frame(300,400)
 *��ư
 **/
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*//�ڹٿ����� ���콺 ������ �̺�Ʈ�� Click�̶�� �θ��� �ʴ´�.
// ActionEvent�� �Ѵ�.
//GUI ���۳�Ʈ�󿡼� Ŭ���̺�Ʈ�� �߻��ϸ�, ���ϸ��� OS�� �����Ͽ� 
  �˸´� ������ JVM�� ������, �������� JVM�� �ش� �̺�Ʈ�� �˸´� Event ��ü�� �޸𸮿� �ø���.
 ���콺 Ŭ�� -> Window���� -> jvm ���� -> ActionEvent ��ü�ν��Ͻ� ���� -> �����ʿ� ����
*/
public class EventTest extends JFrame implements ActionListener{
	JButton bt;
		
	public EventTest(){
		setLayout(new FlowLayout());	
		bt = new JButton("����ư");
		add(bt);	
		
		//��ư�� �����ʿ��� ����!!!!
		bt.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
	
	//jdk 5���� �����ϴ� ������̼��̶�� �ּ�!!!
	//�Ϲ� �ּ��� Ʋ����? ���α׷� ����� ���� ���ִ� �ּ�
	@Override
	
	//�Ʒ��� �޼���� ����ڰ� actionEvent�� ����ų������ ȣ��ȴ�!! �׸��� �Ű�������
	//�ش� ActionEvent �ν��Ͻ��� ���޵ȴ�!!!
	public void actionPerformed(ActionEvent e) {
		System.out.println("�� ������");
	}

	public static void main(String[] args) {
		EventTest et = new EventTest();
	}
}
