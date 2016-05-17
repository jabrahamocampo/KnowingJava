package com.cap10.ParametrizacionXML;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestXML {
	
	public static void main(String[] args){
		try{
			//obtenemos el parser
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			
			//parseamos ak archivo
			sp.parse("connectionPool.xml", new ConnectionPoolHandler());
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}	
}
