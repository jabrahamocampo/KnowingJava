package com.cap04.DisenoDeApp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.cap03.DBConnectionDemo.UConnection;

public class EmpDAOSQLDBImplementation extends EmpDAOAbstract{

	@Override
	public Collection<EmpDTO> buscarUltimosEmpleados(int n) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			con = UConnection.getConnection();
			
			String sql = "select * from emp order by hiredate desc limit ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, n);
			
			rs = pstm.executeQuery();
			
			Vector<EmpDTO> ret = new Vector<EmpDTO>();
			
			EmpDTO empno = null;
			while(rs.next()){
				empno = new EmpDTO();
				empno.setEmpno(rs.getInt("empno"));
				empno.setEname(rs.getString("ename"));
				empno.setDeptno(rs.getInt("deptno"));
				empno.setDate(rs.getDate("hiredate"));
				ret.addElement(empno);
			}
		
		return ret;
	}catch(Exception ex){
		ex.printStackTrace();
		throw new RuntimeException(ex);
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstm!=null) pstm.close();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		}
	}

}
