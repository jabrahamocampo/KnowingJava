package com.cap01.Introduccion;

import java.util.*;

public class HolaMundoNombre {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		//mensaje para el usuario
		System.out.print("Ingresa tu edad, nombre y altura: ");
		
		//leemos nombre
		String nom = scanner.next();
		
		//leemos edad
		int edad = scanner.nextInt();
		
		//leemos la altura
		double altura = scanner.nextDouble();
		
		//y...mostramos los datos en consola :)
		System.out.println("Nombre: "+nom + "Edad: "+edad+" Altura: "+altura);
	}

}
