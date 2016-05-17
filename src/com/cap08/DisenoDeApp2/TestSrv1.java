package com.cap08.DisenoDeApp2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TestSrv1 {
	public static void main(String[] args) throws Exception {
		
		Socket s = new Socket("127.0.0.1", 5432);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		//solicito el servicio codigo 1
		dos.writeInt(1);
		
		//el server me indica cuantos deptos va a enviar
		int n = dis.readInt();
		
		for(int i=0; i<n; i++){
			System.out.println(dis.readUTF());
		}
		
		dis.close();
		dos.close();
		s.close();
	}
}
