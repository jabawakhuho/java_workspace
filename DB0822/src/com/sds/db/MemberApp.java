package com.sds.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class MemberApp{
	String url="jdbc:mariadb://localhost:3306/iot";
	String user="root";
	String password="";
	Connection con; //접속후, 그 접속 정보를 보유한 객체!!!
	PreparedStatement pstmt; //쿼리문 수행 객체
	ResultSet rs; //table의 정보를 보유한 객체

	public MemberApp(){
		//데이터 (DML) 넣기, 수정, 삭제 , 조회 (select)
		//조회하기 만들기!!!!!!!!
		
		
		try{
			//mariadb 용 jdbc 드라이버 (static 영역)로드
			Class.forName("org.mariadb.jdbc.Driver");
			
			//마리아 DB에 접속
			con =DriverManager.getConnection(url,user,password);
			if(con != null){
				System.out.println("접속성공");	
				//select문을 실행!!!
				String sql="select*from member2";
				pstmt = con.prepareStatement(sql);
				rs=pstmt.executeQuery(); //쿼리 실행후 결과 받기!!
				while(rs.next()){
					System.out.println(rs.getString("name")+", 나이 : "+rs.getInt("age"));
				}
			}else{
				System.out.println("접속실패");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();	
		} finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
				}
			}
			if(pstmt!=null){
				try{
					pstmt.close();
				}catch(SQLException e){
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(SQLException e){
				}
			}
		}
	}

	public static void main(String[] args) 	{

		new MemberApp();
	}
}
