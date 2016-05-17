package com.cap09.DinamicStructures;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashTable {
	
	public static void main(String[] args){
		
		Personas p1 = new Personas("Joselo", "Español", 36);
		Personas p2 = new Personas("Berenice", "Italiana", 31);
		
		//Creamos la tabla hash
		Hashtable<String, Personas> tabla = new Hashtable<String, Personas>();
		
		//agrego las personas a la tabla tomando su nombre como clave
		tabla.put(p1.getNombre(), p1);
		tabla.put(p2.getNombre(), p2);
		
		//acceso a cada elemento de la tabla usando su clave
		System.out.println(tabla.get("Joselo"));
		System.out.println(tabla.get("Berenice"));
		
		//Obtengo una enumeracion de todos los elementos que existen en la tabla
		//la recorro y por cada una accedo al elemento asociado para
		//mostrar clave=valor
		String aux;
		Enumeration<String> keys = tabla.keys();
		
		while(keys.hasMoreElements()){
			aux = keys.nextElement();
			System.out.println(aux+ " = "+tabla.get(aux).getNacionalidad());
		}
	}
}
