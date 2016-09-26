package com.cap12.FrameworkXMLReader;

public class TestXML2 {
	public static void main(String[] args){
			
			//leermos el archivo y lo cargamos en memoria
			XMLFactory.load("FrameworkXML.xml");
			
			//accedo al tag especificando su ruta y attributo
			String path = "/framework/data-access/mapping/table";
			String attName = "name";
			String attValue = "EMP";
			XTag tag = XMLFactory.getByAttribute(path, attName, attValue);
			
			//accedo a los valores delos atributos
			String type = tag.getAtts().get("type");
			System.out.println(type);
			
			//accedo a los valores de sus subtags (field)
			XTag[] fields = tag.getSubtags("field");
			for(int i=0; i<fields.length; i++){
				System.out.println(fields[i]);
			}
			
			
	}	
}
