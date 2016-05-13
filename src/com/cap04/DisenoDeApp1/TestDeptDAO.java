package com.cap04.DisenoDeApp1;

import java.util.Collection;

public class TestDeptDAO {
	
	public static void main(String[] args){
		DeptDAO deptos = new DeptDAO();
		
		Collection<DeptDTO> deptosCollection = deptos.getDeptos();
		
		for(DeptDTO depto:deptosCollection){
			System.out.println(depto);
		}
	}
	
}
