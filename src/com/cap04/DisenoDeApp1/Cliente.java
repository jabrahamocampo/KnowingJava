package com.cap04.DisenoDeApp1;

import java.util.Collection;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args){
		Facade fachada = new Facade();
		FacadeAbstractImplementation fachadaAbs = new FacadeAbstractImplementation();
		
		Collection<DeptDTO> collectionDepts = fachada.getDeptos();
		
		//Muestro los departamentos
		_mostrarDepartamentos(collectionDepts);
		
		//pido al usuario que ingrese un numero de depto
		Scanner scanner = new Scanner(System.in);
		int deptno = scanner.nextInt();
		
		Collection<EmpDTO> collEmps = fachada.getEmployees(deptno);
		
		//muestro los empleados del depto elegido
		_mostrarEmpleados(collEmps, deptno);
		
		//Pedimos los ultimos empleados en un departamento
		Scanner scanner2 = new Scanner(System.in);
		int n = scanner2.nextInt();
		Collection<EmpDTO> ultimosEmpl = fachadaAbs.obtenerUltimosEmpleados(n);
		
		_mostrarUltimosEmpleados(ultimosEmpl);
	}

		private static void _mostrarDepartamentos(Collection<DeptDTO> collectionDepts){
			System.out.println("DEPARTAMENTOS: ");
			System.out.println("----------------------------");
			for(DeptDTO dto:collectionDepts){
				System.out.println("  "+dto.getDeptNo()+" ");
				System.out.println("  "+dto.getdName()+" ");
				System.out.println("  "+dto.getLoc()+"  ");
			}
			
			System.out.println("<------------------------------>");
			System.out.println("Ingrese numero de departamento: ");
		}
		
		private static void
		_mostrarEmpleados(Collection<EmpDTO> collEmps, int deptno){
			System.out.println("EMPLEADOS DEL DEPARTAMENTO: ");
			System.out.println("----------------------------");
			for(EmpDTO dto:collEmps){
				System.out.println("  "+dto.getDeptno()+" ");
				System.out.println("  "+dto.getEmpno()+" ");
				System.out.println("  "+dto.getEname()+"  ");
				System.out.println("  "+dto.getDate()+"  ");
			}
			
			System.out.println("<------------------------------>");
			
			System.out.println("Trae los dos ultimos empleados contratados:");
		}
	
		private static void
		_mostrarUltimosEmpleados(Collection<EmpDTO> ultimosEmpl){
			System.out.println("ULTIMOS EMPLEADOS: ");
			System.out.println("----------------------------");
			for(EmpDTO empl : ultimosEmpl){
				System.out.println("  "+empl.getDeptno()+" ");
				System.out.println("  "+empl.getEmpno()+" ");
				System.out.println("  "+empl.getEname()+"  ");
				System.out.println("  "+empl.getDate()+"  ");
			}
		}

}
