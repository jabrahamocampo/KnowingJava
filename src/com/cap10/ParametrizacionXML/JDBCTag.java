package com.cap10.ParametrizacionXML;

import java.util.Enumeration;
import java.util.Hashtable;

public class JDBCTag {
	private Hashtable<String, ConnectionTag> connection;
	
	public JDBCTag(){
		connection = new Hashtable<String, ConnectionTag>();
		
		
	}
	
	public ConnectionTag getConnectionTag(String name){
		return connection.get(name);
	}
	
	public void addConnectionTag(ConnectionTag c){
		connection.put(c.getName(),c);
	}
	
	public String toString(){
		String x = "";
		
		ConnectionTag aux;
		Enumeration<String> e = connection.keys();
		while(e.hasMoreElements()){
			aux = connection.get(e.nextElement());
			x+=aux.toString()+"/n";
		}
		return x;
	}
}
