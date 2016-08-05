/*
메모장의 디자인만 따라하자!!!!!
*/

package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;

class Memo{
	public static void main(String[] args) {
		//메모장 윈도우 선언Frame
		Frame frame = new Frame();
		

		//메뉴바 선언MenuBar
		MenuBar bar = new MenuBar();
		
		//메뉴들...
		Menu[] menus = new Menu[5];
		String[] menuTitle = {"파일","편집","서식","보기","도움말"}; 

		for( int i=0; i < menus.length ; i++){
			menus[i] = new Menu(menuTitle[i]);
			bar.add(menus[i]); 
		}
		//위도우에 메뉴바 부착
		frame.setMenuBar(bar);
		
		//메뉴 아이템들....
		MenuItem[] fileItem = new MenuItem[5];
		String[] itemTitle = {"새로만들기","열기","저장","다른이름으로저장","끝내기"};

		for(int i = 0; i < fileItem.length ; i++){
			fileItem[i] = new MenuItem(itemTitle[i]);
			menus[0].add(fileItem[i]);
		}



		//TextArea 부착
		TextArea area = new TextArea(30,40);
		frame.add(area);
		
		//위도우 크기, 보이게 하기!!!
		frame.setSize(600,500);
		frame.setVisible(true);
	}
}
