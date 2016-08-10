/*
 JTable�� �����⿡ �Ұ��ϱ� ������ ���� �����͸� ������ ��ü�� TableModel�� �����Ͽ�, ȸ������ ���α׷���
 ����� JTable�� ������ �����͸� ó���غ���!!!!!
*/
package com.sds.collection;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel {
	String[] column = { "���̵�", "��й�ȣ", "�̸�" };
	// String[][] data =new String[0][0];

	// �迭�� �� ũ�Ⱑ �����Ǿ� �����Ƿ�, �÷��� �����ӿ��� �̿��Ͽ� ����� ��������!!!
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

	// Table�� �������� ���θ� Ȯ���ϴ� �޼���~~~~ 
	@Override
	public boolean isCellEditable(int row, int col) {
		// System.out.println(row + ":" + col + "�����ϴ�?");
		boolean bln;
		if (col == 1) {
			return false;
		} else {
			return true;
		}
	}
	//Table�� ���� ��ɿ� ���� ����� ���� �ش� ��ġ�� �ִ� �޼���~~~~
	@Override
	public void setValueAt(Object aV, int row, int col) {
		//System.out.println(aV + "����" + row + "," + col+"�� ��������!!");
		list.get(row)[col] = (String)aV;
	}
}
