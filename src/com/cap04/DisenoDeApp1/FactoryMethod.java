package com.cap04.DisenoDeApp1;

import java.util.ResourceBundle;

public class FactoryMethod {
	public static Object getInstancia(String objName){
		try{
			ResourceBundle rb = ResourceBundle.getBundle("factory");
			String sClassName = rb.getString(objName);
			Object ret = Class.forName(sClassName).newInstance();
			return ret;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
