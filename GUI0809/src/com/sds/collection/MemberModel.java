/*
 * JTable�� ������ ��������, ȸ�� ���õ� �����͸� ó���ϴ� TableModel
 * ���� ) TableModel�� ������ ��� �޼���� �����ڰ� ȣ���ϴ°��� �ƴ϶� JTable�� ȭ�鿡 �������� ������ ȣ���Ѵ�!
 * �� �ý����� ȣ���Ѵ�.!!!!
 * */
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel{
	String[] column = {"��ȣ","�̸�","��й�ȣ","�̸���"};
	String[][] data ={
			{"1","����ȣ","0000","lee@gmail.com"},
			{"2","�ڻ��","0002","park@gmail.com"},
			{"3","����","0003","kim@gmail.com"}
	};
	//���÷��� ����
	@Override
	public int getColumnCount() {
		return column.length;
	}
	//�� ���ڵ� ��
	@Override
	public int getRowCount() {
		return data.length;
	}
	public String getColumnName(int col){
		System.out.println(col+"��° �����"+column[col]);
		return column[col];
	}
	//�� �׸� ������ ������
	@Override
	public Object getValueAt(int row, int col) {
			return data[row][col];
	}

}
