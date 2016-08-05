/*--------------------------------------------------------------
�ڹٵ� �ٸ� �������α׷�ó��, GUI�� �����Ѵ�.
��) window,button, checkbox, TextArea ����� ����~

�ڹٿ��� GUI ������Ʈ�� awt ��Ű������ �����Ѵ�.
API ���� ����

>Constructors(������)>
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
		//��� GUI ������Ʈ�� �÷��� window â
		//�ڹٿ��� �������� ����Ʈ �Ӽ��� �����ϴµ�, �⺻�� �������ʴ� �Ӽ��� ������ �ִ�.
		//���� ���̰� ����!!
		Frame win = new Frame();
		win.setVisible(true); //���̰� �ϱ�
		win.setSize(300,400);
		win.setTitle("����");

		Button bt = new Button("����");
		//�ڹ� �� HTMLó�� �� ������Ʈ�� �����ϱ⿡ �ռ� ��� ��� �������� ���� ������ ����� �����ȴ�.
		// �� ���������� �����ϰ� ���ڴ�.
		FlowLayout flow = new FlowLayout();
		win.setLayout(flow); //��ġ����� �����ϴ� �޼���..

		//��ư�� �����ӿ� ��������!!!!
		win.add(bt);

		//checkbox
		//�ڹٿ����� ��ü���� �ڷ����̴�.. ���� �迭�� �󸶵��� �����ϴ�.
		Checkbox[] ch= new Checkbox[20];
		
		for(int i =0; i < ch.length ; i++){
			Checkbox c = new Checkbox(i+"��°�ڽ�");
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
		

		c1.add(Integer.toString(i)); // i�� String���� ��ȯ ��������Ѵ�. �ֳ��ϸ� Choice�� add(String A)�޼����� �μ��� String �� ���ϱ� ���� API���� ����!!!

		}

		win.add(c1);

	}
}
