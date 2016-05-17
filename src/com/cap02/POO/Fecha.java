package com.cap02.POO;

public class Fecha {
	private int dia, mes, anio;
	
	public Fecha(int dia, int mes, int anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}



	public int getDia() {
		return dia;
	}



	public void setDia(int dia) {
		this.dia = dia;
	}



	public int getMes() {
		return mes;
	}



	public void setMes(int mes) {
		this.mes = mes;
	}



	public int getAnio() {
		return anio;
	}



	public void setAnio(int anio) {
		this.anio = anio;
	}



	public String toString(){
		return dia+"/"+mes+"/"+anio;
	}

	@Override
	public boolean equals(Object obj) {
		Fecha otra = (Fecha)obj;
		
		return (dia == otra.dia) && (mes == otra.mes) && (anio == otra.anio);
	}
	
	
}
