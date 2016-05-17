package com.cap09.DinamicStructures;

public class Personas {
	
	private String nombre;
	private String nacionalidad;
	private int edad;
	
	public Personas(String nombre, String nacionalidad, int edad){
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
	}
	
	public String toString(){
		return "Nombre: "+nombre+"Edad: "+edad+"Nacionalidad: "+nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
