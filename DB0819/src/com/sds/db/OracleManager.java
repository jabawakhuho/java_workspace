/*
 * ���� ����Ŭ ������ ���̽��� ���� ������ ���� ��簴ü!!!
 * */
package com.sds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleManager {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public OracleManager(Connection con) {
		this.con = con;
	}
	
	//��� ���ڵ� ��ȸ
	public void selectAll(){		
		String sql="Select*from member2";
		try {
			pstmt = con.prepareStatement(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
