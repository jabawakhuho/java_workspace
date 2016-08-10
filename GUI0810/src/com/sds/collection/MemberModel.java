/*
 JTable은 껍데기에 불과하기 떄문에 실제 데이터를 연동한 객체인 TableModel을 정의하여, 회원관리 프로그램에
 출력할 JTable에 보여질 데이터를 처리해보자!!!!!
*/
package com.sds.collection;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel {
	String[] column = { "아이디", "비밀번호", "이름" };
	// String[][] data =new String[0][0];

	// 배열은 그 크기가 고정되어 있으므로, 컬렉션 프레임웍을 이용하여 기능을 개선하자!!!
	ArrayList<String[]> list = new ArrayList<String[]>();

	@Override
	public int getColumnCount() {
		return column.length;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		/*
		 * String[] record = list.get(row); return record[col];
		 */
		return list.get(row)[col];
	}

	@Override
	public String getColumnName(int col) {
		return column[col];
	}

	// Table의 편집가능 여부를 확인하는 메서드~~~~ 
	@Override
	public boolean isCellEditable(int row, int col) {
		// System.out.println(row + ":" + col + "편집하니?");
		boolean bln;
		if (col == 1) {
			return false;
		} else {
			return true;
		}
	}
	//Table의 편집 기능에 의해 변경된 값을 해당 위치에 넣는 메서드~~~~
	@Override
	public void setValueAt(Object aV, int row, int col) {
		//System.out.println(aV + "값을" + row + "," + col+"에 넣을께요!!");
		list.get(row)[col] = (String)aV;
	}
}
