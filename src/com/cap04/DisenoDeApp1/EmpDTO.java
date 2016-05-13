package com.cap04.DisenoDeApp1;


import java.util.Date;

public class EmpDTO {
	private int empno;
	private String ename;
	private int deptno;
	private Date hiredate;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public Date getDate() {
		return hiredate;
	}
	public void setDate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	public String toString(){
		return empno+", "+ename+", "+hiredate+", "+deptno; 
	}
}
