/* 
 JTable�� �����ο� �Ұ��ϱ� ������ �������� ���̺� ���� ������ ���� �����Ѵ�.
 * */

package com.sds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String[] columTitle = {"BOOK_ID"
			,"SUBCATEGORY_ID"
			,"BOOKNAME"
			,"PUBLISHER"
			,"AUTHOR"
			,"PRICE"
			,"REGDATE"};
	//ū �迭�� �÷��� �����ӿ����� ��ü����!! �����ϴϱ�..
	ArrayList<String[]> data = new ArrayList<String[]>();
	
	public MyModel(Connection con) {
		this.con = con;
		selectAll();
	}
	
	//��� ���ڵ� ��������
	public void selectAll(){
		data.removeAll(data);//��������Ÿ ����
		String sql="select*from book order by book_id asc";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String[] arr =new String[columTitle.length];
				arr[0] = Integer.toString(rs.getInt("book_id"));
				arr[1] = Integer.toString(rs.getInt("subcategory_id"));
				arr[2] = rs.getString("bookname");
				arr[3] = rs.getString("publisher");
				arr[4] = rs.getString("author");
				arr[5] = Integer.toString(rs.getInt("price"));
				arr[6] = rs.getString("regdate");
				data.add(arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	//Record 1�� �����ϱ�
	public int deleteBook(int book_id){
		int result =0;
		String sql = "delete from book where book_id ="+book_id;
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	@Override
	public int getColumnCount() {
		return columTitle.length;
	}

	@Override
	public String getColumnName(int col) {
		return columTitle[col];
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		String[] record = data.get(row);
		return record[col];
	}
	
	

}
