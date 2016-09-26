package com.cap13.IOStream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Demo2 {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = null;
		PrintStream stdError = null;
		
		try{
		//Abro el archivo y redirecciono la standard error
		 fos = new FileOutputStream("Errores.txt");
		 stdError = new PrintStream(fos);
		
		System.setErr(stdError);
		
		int[] arr = new int[5];
		
		//error cuando sea mayor que 4
		for(int i=0; i<10; i++){
			arr[i] = 0;
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				//cierro todo
				if(stdError != null) stdError.close();
				if(fos != null) fos.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

	}
}
