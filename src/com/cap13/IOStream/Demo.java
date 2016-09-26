package com.cap13.IOStream;

import java.io.FileInputStream;
import java.util.Scanner;

public class Demo {
	
	public static void main(String[] args) throws Exception{
		//abre el archivo
		FileInputStream fis = new FileInputStream("demo.txt");
		
		//instancio el scanner pasandole el fileinputstream
		Scanner sc = new Scanner(fis);
		
		int i = sc.nextInt();
		String n = sc.next();
		
		while(!n.equals("FIN")){
			System.out.println(i + " " + n);
			i = sc.nextInt();
			n = sc.next();
		}
		
		//Cierro el archivo
		fis.close();
		
	}

}
