package com.cap13.IOStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Demo8 {
	public static void main(String[] args) throws Exception{
		String arch = "personas.dat";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(arch));
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(new Persona(10, "Pablo", "Milanes"));
		oos.writeObject(new Persona(20, "Pedro", "Navajas"));
		oos.writeObject(new Persona(30, "Juan", "Bananas"));
		
		oos.close();
		bos.close();
	}
}
