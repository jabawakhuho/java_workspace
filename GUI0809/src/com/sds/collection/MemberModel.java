/*
 * JTable에 보여질 데이터중, 회원 관련된 데이터를 처리하는 TableModel
 * 주의 ) TableModel이 보유한 모든 메서드는 개발자가 호출하는것이 아니라 JTable이 화면에 보여질때 스스로 호출한다!
 * 즉 시스템이 호출한다.!!!!
 * */
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel{
	String[] column = {"번호","이름","비밀번호","이메일"};
	String[][] data ={
			{"1","이현호","0000","lee@gmail.com"},
			{"2","박상균","0002","park@gmail.com"},
			{"3","김기덕","0003","kim@gmail.com"}
	};
	//총컬럼의 갯수
	@Override
	public int getColumnCount() {
		return column.length;
	}
	//총 레코드 수
	@Override
	public int getRowCount() {
		return data.length;
	}
	public String getColumnName(int col){
		System.out.println(col+"번째 재목은"+column[col]);
		return column[col];
	}
	//각 항목에 보여질 데이터
	@Override
	public Object getValueAt(int row, int col) {
			return data[row][col];
	}

}
