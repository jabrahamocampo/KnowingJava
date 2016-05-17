package com.cap02.POO;
import java.util.*;
import com.cap02.POO.Fecha;

public class TestFecha {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("Ingresa Fecha Dia Mes y Año");
		
		int dia = scanner.nextInt();
		int mes = scanner.nextInt();
		int anio = scanner.nextInt();
		
		Fecha f1 = new Fecha(dia,mes,anio);
		
		System.out.print("Ingresa la segunda Fecha");
		
		dia = scanner.nextInt();
		mes = scanner.nextInt();
		anio = scanner.nextInt();
		
		Fecha f2 = new Fecha(dia,mes,anio);
		
		System.out.println("Fecha 1 = "+f1);
		System.out.println("Fecha 2 = "+f2);
		
		if(f1.equals(f2)){
			System.out.println("Son iguales wey...");
		}else{
			System.out.println("Ni madres no son iguales");
		}
		
	}
}
