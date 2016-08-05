/*java�� �����Ͽ� ��κ��� �������α׷������� GUI ������Ʈ�� �����쿡 �÷�������
 * ��ġ����� �������� ���ִ� ����� �����Ѵ�.
 * �ڹٴ� LayoutManager��� ��ü�� �����ϰ� ������ ���� ������ �˸´� ��ġ�����ڸ�
 * �����ؼ� ����ϸ� �ȴ�.
 * 
 * 1.BorderLayout - �������� ������ ������ �����Ǵ� ��ġ������
 * 2.FlowLayout -������Ʈ���� �������� ũ�������� ���� �帣���� ó���ϴ� ��ġ������
 * 3.GridLayout - ����(Grid)������� ������Ʈ�� ��ġ�ϴ� ��ġ������
 * 4.GridBarLayout - GridLayout�� ����� ���� ���������� ó���ϴ� ��ġ������
 * 5.CardLayout - ȭ�鿡 ������ ������Ʈ�� ���� �ϳ��� �����Ű�� ��ġ������ 
 * 
 * */

package study.gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.TextField;

public class WindowTest {
	
	public static void main(String[] args) {
		//	�α��� ȭ�� �����ϱ�
		Frame f=new Frame();
		Label la_id=new Label("ID");
		Label la_pw= new Label("PW");
		TextField t_id= new TextField(15);
		TextField t_pw = new TextField(15);
		Button bt= new Button("�α���");
		
		Checkbox cb= new Checkbox("��ƺ�");
		Choice ch= new Choice();
		for(int i=0; i < 10 ; i++){
			ch.add(Integer.toString(i));
		}
		MenuBar bar = new MenuBar();
		Menu m = new Menu("����");
		bar.add(m);//�޴��ٿ� �޴� ���̱�
		f.setMenuBar(bar); // Frame�� Menubar ���̱�
		
		//Frame�� FlowLayout�� ��������
		FlowLayout flow= new FlowLayout();
		f.setLayout(flow);
		
		f.add(la_id);//�����쿡 ID ���� ����
		f.add(t_id);//�����쿡 id �ؽ�Ʈ�ʵ� ����
		f.add(la_pw);//�����쿡 PW ���� ����
		f.add(t_pw);//�����쿡 PW�ؽ�Ʈ�ʵ� ����
		f.add(bt);//�����쿡 bt����
		f.add(cb);
		f.add(ch);
		
		f.setSize(200,120);//������ ũ�� ����
		f.setVisible(true);//������ ���̰� �ϱ�
		
	}
}
