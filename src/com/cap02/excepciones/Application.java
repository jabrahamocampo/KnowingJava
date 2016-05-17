package com.cap02.excepciones;

import java.util.*;

public class Application {
	
	public Usuario login(String username, String password){
		
		try{
			//leemos el archivo de propiedades que debe estar ubicado en el package root
			ResourceBundle rb = ResourceBundle.getBundle("usuario");
		
			String usr = rb.getString("username");
			String pwd = rb.getString("password");
			
			//Definimos la variable de retorno
			Usuario u = null;
			
			if(usr.equals(username) && (pwd.equals(password))){
				//instancio y seteo los datos
				u = new Usuario();
				u.setUsername(usr);
				u.setPassword(pwd);
			}
			//Retorno la instancia de Usuario si no entro al if
			return u;
		}
		catch(Exception ex){
			//Cualquier error salgo por excepcion 
			throw new RuntimeException("Error verificando datos", ex);
		}
	}
}
