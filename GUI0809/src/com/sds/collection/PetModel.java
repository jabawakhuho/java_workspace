/*
 * JTable�� ������ �������� , �ְ߰��� �����͸� ó���ϴ� TableModel
 * */

package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel{
	String[] column={"�̸�","����","����"};
	String[][] data={
			{"�ǻ�","������","����"},
			{"��","�����","����"},
			{"����","����ġ","����"}
	};
	
	//�Ʒ��� ��� �޼���� �����ڸ� ���Ѱ� �ƴϴ�!!!!Jtable�� ȣ���ϴ� �޼����̴�.
	@Override
	public int getColumnCount() {
		return column.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public String getColumnName(int col){
		return column[col];
	}
	
}
