package com.cap02.excepciones;

public class DemoFinally {
	public static void main(String[] args) throws Exception{ 
		try{
			int i = Integer.parseInt("Esto no es un numero");
		}catch(NumberFormatException ex){
			System.out.print("Entre al catch");
		}finally{
			System.out.print("...Pero antes entro al finally! =)");
			//Finally es ideal para cerrar archivos, bases de datos
		}
	}
}
