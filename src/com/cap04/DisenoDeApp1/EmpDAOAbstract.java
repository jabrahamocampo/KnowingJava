package com.cap04.DisenoDeApp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.cap03.DBConnectionDemo.UConnection;

public abstract class EmpDAOAbstract {
	
	//metodo abstracto debe ser resuelto en las 
	//subclases
	
	public abstract Collection<EmpDTO> buscarUltimosEmpleados(int n);
	
	//Este metodo es comun a todas las bases de datos
	//por lo tanto no necesita ser abstracto
	public Collection<EmpDTO> buscarEmpEnDepto(int deptno){

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			
			
			con = UConnection.getConnection();
			
			String sql = "Select * from emp where deptno = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, deptno);
			rs = pstm.executeQuery();
			
			Vector<EmpDTO> employees = new Vector<EmpDTO>();
			EmpDTO employee = null;
			while(rs.next()){
				employee = new EmpDTO();
				employee.setEmpno(rs.getInt("empno"));
				employee.setEname(rs.getString("ename"));
				employee.setDeptno(rs.getInt("deptno"));
				employee.setDate(rs.getDate("hiredate"));
				employees.add(employee);
			}
			return employees;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
			}catch(Exception ex ){
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}	
	}
}


