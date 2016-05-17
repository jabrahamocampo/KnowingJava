package com.cap03.DBConnectionDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionDemo {

	public static void main(String[] args){
		//Establecemos los parametros de la conexion
		//Test
		final String usr = "root";
		final String pwd = "";
		final String driver = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://localhost/emp";
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			/**
			 * Paso #1 
			 * Levantamos el driver
			 */
			Class.forName(driver);
			
			/**
			 * Paso #2
			 * Establecemos la conexion pasando los parametros
			 * url, usr y pwd
			 */
			con = DriverManager.getConnection(url, usr, pwd);
			
			/**
			 * Paso #3
			 * Definimos un query, preparamos la sentencia y lo ejecutamos
			 */
			String sql = "Select * from emp";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			/**
			 * Paso #4
			 * iteramos sobre los resultados obtenidos
			 * y los mostramos 
			 */
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
				/**
				 * Paso #5
				 * cierro todos los recursos en orden inverso
				 */
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
