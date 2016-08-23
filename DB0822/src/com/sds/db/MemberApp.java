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
	Connection con; //������, �� ���� ������ ������ ��ü!!!
	PreparedStatement pstmt; //������ ���� ��ü
	ResultSet rs; //table�� ������ ������ ��ü

	public MemberApp(){
		//������ (DML) �ֱ�, ����, ���� , ��ȸ (select)
		//��ȸ�ϱ� �����!!!!!!!!
		
		
		try{
			//mariadb �� jdbc ����̹� (static ����)�ε�
			Class.forName("org.mariadb.jdbc.Driver");
			
			//������ DB�� ����
			con =DriverManager.getConnection(url,user,password);
			if(con != null){
				System.out.println("���Ӽ���");	
				//select���� ����!!!
				String sql="select*from member2";
				pstmt = con.prepareStatement(sql);
				rs=pstmt.executeQuery(); //���� ������ ��� �ޱ�!!
				while(rs.next()){
					System.out.println(rs.getString("name")+", ���� : "+rs.getInt("age"));
				}
			}else{
				System.out.println("���ӽ���");
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
