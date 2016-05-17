package com.cap01.Introduccion;

import java.util.*;

public class ParOImpar {
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		//pedimos el valor al usuario
		System.out.print("Ingrese valor: ");
		int valor = scanner.nextInt();
		
		//verificamos si es par o impar
		int resto = valor % 2;
		
		//para preguntar por igual verificamos
		if(resto == 0){
			System.out.println(valor +" es par");
		}else{
			System.out.println(valor +" es impar");
		}
		
		//utilizando if inline
		String msg = (resto == 0) ? "es par": "es impar";
		System.out.println(msg);
	}
	
}
