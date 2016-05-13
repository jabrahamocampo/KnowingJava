package com.cap03.DBConnectionDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoInsert {
	
	public static void main(String[] args){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
		//establecemos la conexion
		con = UConnection.getConnection();
		
		String sql = "";
		sql += "insert into dept (deptno, dname, loc)";
		sql += "values(?,?,?)";
		
		pstm = con.prepareStatement(sql);
		
		//seteamos los valores de los parametros
		pstm.setInt(1, 4);
		pstm.setString(2, "Logistica");
		pstm.setString(3, "Queretaro");
		int rtdo = pstm.executeUpdate();
		
		if(rtdo == 1){
			System.out.println("1 Fila correctamente insertada");
		}else{
			throw new RuntimeException("No se pudo insertar la fila");
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
