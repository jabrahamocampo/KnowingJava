package com.cap07.Networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServerB {
	
	public static final int BUFFER_LENGTH = 3;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Socket s = null;
		
		ServerSocket ss = new ServerSocket(5432);
		
		while(true){
			try{
				//espero la conexion
				s = ss.accept();
				
				//informacion en la consola
				System.out.println("Se conectaron desde la IP:"+s.getInetAddress());
				
				//enmascaro la entrada y salida de bytes
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				bw = new BufferedWriter(new PrintWriter(s.getOutputStream()));
				
				char bEnviar[];
				char bRecive[] = new char[BUFFER_LENGTH];
				
				StringBuffer sb = new StringBuffer();
				
				//leo el nombre que envia el cliente
				int n;
				while((n = br.read(bRecive))==BUFFER_LENGTH){
					sb.append(bRecive);
				}
				sb.append(bRecive,0,n);
				
				//armo el saludo personalizado
				String saludo = "Hola Mundo ("+sb+")"+System.currentTimeMillis();
				
				//envio el saludo al cliente
				bEnviar = saludo.toCharArray();
				bw.write(bEnviar);
				bw.flush();
				System.out.println("Saludo enviado...");
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(br != null) br.close();
					if(bw != null) bw.close();
					if(s != null) s.close();
					System.out.println("Conexion cerrada...");
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}
	
}
