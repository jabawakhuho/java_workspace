/*
 * 오직 오라클 데이터 베이스에 대한 쿼리문 수행 담당객체!!!
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
	
	//모든 레코드 조회
	public void selectAll(){		
		String sql="Select*from member2";
		try {
			pstmt = con.prepareStatement(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
