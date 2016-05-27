package com.cap11.Introspeccion;

import java.lang.reflect.Method;

public class Demo1 {
	public static void main(String[] args){
		try{
			//definimos el nombre de la clase incluyendo el paquete
			String sClass = "com.cap04.DisenoDeApp1.DeptDAO";
					
			//Obtendo una instancia de Class apuntando a la clase
			Class clazz = Class.forName(sClass);
			
			//obtengo la lista de metodos de la clase
			Method mtdos[] = clazz.getDeclaredMethods();
			
			//Recorro la lista de metodos y muestro sus nombres
			for(Method mtd:mtdos){
				System.out.println(mtd.getName());
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
