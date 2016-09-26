package com.cap13.IOStream;

import java.io.Serializable;

public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int edad;
	private String nombre;
	private String dni;
	
	public Persona(int e, String n, String d){
		edad = e;
		nombre = n;
		dni = d;
	}
	
	public String toString(){
		return nombre + ", " + edad +", "+dni;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	
}
