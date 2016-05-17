package com.cap02.POO;

public class Util {
	@SuppressWarnings("unchecked")
	public static void ordenar(Comparable arr[]){
		boolean ordenado = false;
		while(!ordenado){
			ordenado = true;
			for(int i=0; i<arr.length-1; i++){
				if(arr[i+1].compareTo(arr[i])<0){
					Comparable aux = arr[i];
					arr[i] = arr[i+1];
					ordenado = false;
				}
			}
		}
	}
}
