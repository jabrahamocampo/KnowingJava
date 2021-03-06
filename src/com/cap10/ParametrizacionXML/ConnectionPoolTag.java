package com.cap10.ParametrizacionXML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
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

	public JDBCTag getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBCTag jdbc) {
		this.jdbc = jdbc;
	}

	public PoolsTag getPools() {
		return pools;
	}

	public void setPools(PoolsTag pools) {
		this.pools = pools;
	}

	public static ConnectionPoolTag getInstancia() {
		return instancia;
	}

	public static void setInstancia(ConnectionPoolTag instancia) {
		ConnectionPoolTag.instancia = instancia;
	}

	@Override
	public void endElement(String uri, String locName, String qName){
		System.out.println("Cierra: "+qName);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		//muestro el nombre del tag
		System.out.println("Comienza tag:"+qName);
		
		//recorro la lista de atributos del tag
		for(int i=0; i<attributes.getLength(); i++){
			//muestro cada atributo del tag (atributo=valor)
			System.out.print("             "+attributes.getQName(i)+" = ");
			System.out.println(attributes.getValue(i));
		}
	}
	
	
}
