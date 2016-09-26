package com.cap12.FrameworkXMLReader;

public class TestXML1 {
	public static void main(String[] args){
		
		//leermos el archivo y lo cargamos en memoria
		XMLFactory.load("FrameworkXML.xml");
		
		//Accedo al tag especificando su ruta
		String path = "/framework/data-access/connection-pool";
		
		XTag tag = XMLFactory.getByPath(path);
		
		//accedo a los valores de los atributos
		String usr = tag.getAtts().get("user");
		String driver = tag.getAtts().get("driver");
		String url = tag.getAtts().get("url");
		
		System.out.println(usr);
		System.out.println(driver);
		System.out.println(url);
		
		
	}
}
