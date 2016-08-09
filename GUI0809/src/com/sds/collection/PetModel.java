/*
 * JTable에 보여질 데이터중 , 애견관련 데이터를 처리하는 TableModel
 * */

package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel{
	String[] column={"이름","종류","성별"};
	String[][] data={
			{"뽀삐","강아지","숫컷"},
			{"톰","고양이","숫컷"},
			{"가시","고슴도치","암컷"}
	};
	
	//아래의 모든 메서드는 개발자를 위한게 아니다!!!!Jtable이 호출하는 메서드이다.
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
