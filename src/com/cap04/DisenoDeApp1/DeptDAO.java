package com.cap04.DisenoDeApp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.cap03.DBConnectionDemo.UConnection;

public class DeptDAO {
	
	public Collection<DeptDTO> getDeptos(){
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			con = UConnection.getConnection();
			String sql = "Select * from dept";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Vector<DeptDTO> ret = new Vector<DeptDTO>();
			
			DeptDTO dto = null;
			while(rs.next()){
				dto = new DeptDTO();
				dto.setDeptNo(rs.getInt("deptno"));
				dto.setdName(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				ret.add(dto);
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
