package com.cap02.POO;

import java.util.*;

public class TestVector {
	public static void main(String[] args){
		Collection<String> coll = UNombres.obtenerLista();
		
		for(String values:coll){
			System.out.println(values);
		}
	}
}
