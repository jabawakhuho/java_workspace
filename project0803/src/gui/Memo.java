/*
�޸����� �����θ� ��������!!!!!
*/

package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;

class Memo{
	public static void main(String[] args) {
		//�޸��� ������ ����Frame
		Frame frame = new Frame();
		

		//�޴��� ����MenuBar
		MenuBar bar = new MenuBar();
		
		//�޴���...
		Menu[] menus = new Menu[5];
		String[] menuTitle = {"����","����","����","����","����"}; 

		for( int i=0; i < menus.length ; i++){
			menus[i] = new Menu(menuTitle[i]);
			bar.add(menus[i]); 
		}
		//�����쿡 �޴��� ����
		frame.setMenuBar(bar);
		
		//�޴� �����۵�....
		MenuItem[] fileItem = new MenuItem[5];
		String[] itemTitle = {"���θ����","����","����","�ٸ��̸���������","������"};

		for(int i = 0; i < fileItem.length ; i++){
			fileItem[i] = new MenuItem(itemTitle[i]);
			menus[0].add(fileItem[i]);
		}



		//TextArea ����
		TextArea area = new TextArea(30,40);
		frame.add(area);
		
		//������ ũ��, ���̰� �ϱ�!!!
		frame.setSize(600,500);
		frame.setVisible(true);
	}
}
