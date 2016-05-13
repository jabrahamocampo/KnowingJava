package com.cap04.DisenoDeApp1;

import java.util.Collection;

public class TestEmpDAO {
	public static void main(String[] args){
		EmpDAO employee = new EmpDAO();
		
		Collection<EmpDTO> employees = employee.getEmployees(2);
		
		for(EmpDTO emp : employees){
			System.out.println(emp);
		}
	}
}
