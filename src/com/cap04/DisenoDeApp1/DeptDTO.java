package com.cap04.DisenoDeApp1;

public class DeptDTO {
	private int deptNo;
	private String dName;
	private String loc;
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public String toString(){
		return deptNo+"  "+dName+",  "+loc;
	}
}
