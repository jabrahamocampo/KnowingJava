package com.cap02.excepciones;

public class TestLogin {
	public static void main(String[] args){
		try{
			Application app = new Application();
			
			//intento el login
			Usuario u = app.login("juan","juan123sito");
			
			//Muestro el resultado
			System.out.println(u);
		}
		catch(Exception ex){
			
			//Ocurrio un error
			System.out.print("servicio temporalmente interrumpido: ");
			System.out.println(ex.getMessage());
		}
	}
}
