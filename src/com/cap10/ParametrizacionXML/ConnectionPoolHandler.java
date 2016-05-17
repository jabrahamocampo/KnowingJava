package com.cap10.ParametrizacionXML;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ConnectionPoolHandler extends DefaultHandler{
	
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
	
	public void endElement(String uri, String locName, String qName){
		System.out.println("Cierra: "+qName);
	}
}
