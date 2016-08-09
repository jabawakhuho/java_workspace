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
	JButton bt2;
			
	public EventTest(){
		setLayout(new FlowLayout());
		
		bt = new JButton("���ʹ�ư");
		bt2 = new JButton("������ư");
		add(bt);	
		add(bt2);	
		
		//��ư�� �����ʿ��� ����!!!!
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		setVisible(true);
	}
	
	//jdk 5���� �����ϴ� ������̼��̶�� �ּ�!!!
	//�Ϲ� �ּ��� Ʋ����? ���α׷� ����� ���� ���ִ� �ּ�
	@Override
	
	//�Ʒ��� �޼���� ����ڰ� actionEvent�� ����ų������ ȣ��ȴ�!! �׸��� �Ű�������
	//�ش� ActionEvent �ν��Ͻ��� ���޵ȴ�!!!
	
	//�̺�Ʈ�� ����Ų ��ü ������Ʈ�� �ڹٿ����� �̺�Ʈ�ҽ��� �Ѵ�.
	//���� ���� action �̺�Ʈ�� ����Ų ��ü�� ��ư�̹Ƿ�, ��ư�� �̺�Ʈ�ҽ��� �ȴ�.
	public void actionPerformed(ActionEvent e) {
		//Action �̺�Ʈ�� �ݵ�� ��ư���� ����Ȱ���ִ� �̺�Ʈ�� �ƴ϶� �ٸ� ������Ʈ�� ActionEvent�� ����ų���ִ�.
		//���� sun������ ���� �߻��� �̺�Ʈ�� ��ư�� ���Ѱ�����, �ٸ� ������Ʈ�� ���� ������ �����Ҽ������Ƿ�,
		// ���� ������ Object ������ �޾ƹ�����..
		Object obj=e.getSource();
		JButton btn=(JButton)obj;
		//System.out.println(btn.getActionCommand()+"����");
		if(btn==bt){
			System.out.println("������ư ����");
		}else if(btn==bt2){
			System.out.println("������ư ����");
		}
	}

	public static void main(String[] args) {
		EventTest et = new EventTest();
	}
}
