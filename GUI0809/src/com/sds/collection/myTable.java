package com.sds.collection;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class myTable extends AbstractTableModel{
	String[] column = {"ID","이름","비밀번호"};
	private ArrayList<String[]> list = new ArrayList<String[]>();
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return column.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return list.get(row)[col];
	}

	public String getColumnName(int col){
		return column[col];
	}
	
	public void setListTest(String[] txt){
		System.out.println(txt[0]);
		list.add(txt);	
	}
}
