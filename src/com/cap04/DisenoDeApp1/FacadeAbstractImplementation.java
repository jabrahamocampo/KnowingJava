package com.cap04.DisenoDeApp1;

import java.util.Collection;

public class FacadeAbstractImplementation {
	
	public Collection<EmpDTO> obtenerUltimosEmpleados(int n){
		EmpDAOSQLDBImplementation empDao = (EmpDAOSQLDBImplementation)FactoryMethod.getInstancia("EMP");
		return empDao.buscarUltimosEmpleados(n);
	}
	
	public Collection<DeptDTO> getDeptos(){
		DeptDAO deptos = new DeptDAO();
		return deptos.getDeptos();
	}
	
	public Collection<EmpDTO> getEmployees(int deptno){
		EmpDAO employee = new EmpDAO();
		return employee.getEmployees(deptno);
	}
}
