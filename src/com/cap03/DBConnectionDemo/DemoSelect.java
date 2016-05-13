package com.cap03.DBConnectionDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoSelect {
	
	public static void main(String[] args){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			//establecemos la conexion
			con = UConnection.getConnection();
			
			String sql = "select * from emp";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt("empno"));
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getDate("hiredate"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			try{
				//Cerramos todos los recursos
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
				
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
