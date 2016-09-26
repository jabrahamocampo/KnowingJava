package com.cap13.IOStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Demo5 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader("demo.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));
		
		int c = br.read();
		while(c != -1){
			bw.write(c);
			c = br.read();
		}
		
		bw.close();
		br.close();
	}
}
