package com.cap03.DBConnectionDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoDelete {
	
	public static void main(String[] args){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			con = UConnection.getConnection();
			
			//seteamos el autocommit a false
			con.setAutoCommit(false);
			
			String sql = "";
			sql+="Delete from emp where empno = ?";
			
			pstm = con.prepareStatement(sql);
			
			//borramos el empleado cuyo numero es 20
			pstm.setInt(1, 20);
			
			int rtdo = pstm.executeUpdate();
			
			if(rtdo == 1){
				con.commit();
			}else{
				String msg ="Error "+rtdo+" filas eliminadas...";
				throw new RuntimeException(msg);
			}
		
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			try{
				
				if (rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(con != null) con.rollback();
				
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
			
		}
		
	}
	
}
