package com.cap10.ParametrizacionXML;

import org.xml.sax.helpers.DefaultHandler;

public class ConnectionPoolTag extends DefaultHandler{
	private JDBCTag jdbc;
	private PoolsTag pools;
	
	private static ConnectionPoolTag instancia = null;
	
	private ConnectionPoolTag(){
		jdbc = new JDBCTag();
		pools = new PoolsTag();
	}
	
	public String toString(){
		String x="";
		x+="-- JDBC --jdbc.toString()--POOLes--"+pools.toString();
	}
}
