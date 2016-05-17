package com.cap02.POO;
import com.cap02.*;
public class TestOrdenar {
	public static void main(String[] args){
		Alumno arr[] = {new Alumno("Juan", 20,8.5)
						,new Alumno("Josele",24,9.5)
						,new Alumno("Bere",25,10.0)};
	
	Util.ordenar(arr);
	
	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]);
	}
	}
}
