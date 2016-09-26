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
	
	public Collection<DeptDTO> getDeptosByName(String deptoName){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			con = UConnection.getConnection();
			
			String sql = "select * from dept where dname = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(2, deptoName);
			rs = pstm.executeQuery();
			
			Vector<DeptDTO> result = new Vector<>();
			
			DeptDTO depto = null;
			while(rs.next()){
				depto = new DeptDTO();
				depto.setDeptNo(rs.getInt("deptno"));
				depto.setdName(rs.getString("dname"));
				depto.setLoc(rs.getString("loc"));
				result.add(depto);
			}
			return result;
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
