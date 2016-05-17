package com.cap08.DisenoDeApp2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

import com.cap03.DBConnectionDemo.UConnection;
import com.cap04.DisenoDeApp1.DeptDAO;
import com.cap04.DisenoDeApp1.DeptDTO;
import com.cap04.DisenoDeApp1.EmpDAO;
import com.cap04.DisenoDeApp1.EmpDTO;
import com.cap04.DisenoDeApp1.FactoryMethod;

public class ServerTCP extends Thread{
	public static final int OBTENER_DEPARTAMENTOS = 1;
	public static final int OBTENER_EMPLEADOS = 2;
	
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	public ServerTCP(Socket s){
		this.socket = s;
	}
	
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(5432);
		Socket s;
		
		while(true){
			s = ss.accept();
			new ServerTCP(s).start();
		}
	}
	
	public void run(){
		try{
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			//leo el codigo del servicio
			int codserv = dis.readInt();
			
			switch(codserv){
				case OBTENER_DEPARTAMENTOS: _obtenerDepartamentos(dis,dos); break;
				case OBTENER_EMPLEADOS: _obtenerEmpleados(dis,dos); break;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			try{
				if(dos!=null) dos.close();
				if(dis!=null) dis.close();
				if(socket != null) socket.close();
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
	
	private void _obtenerDepartamentos(DataInputStream dis, DataOutputStream out){
		try{
			DeptDAO dao = (DeptDAO)FactoryMethod.getInstancia("DEPT");
			
			//obtengo la coleccion de deptos
			Collection<DeptDTO> collDepts = dao.getDeptos();
			
			//envio el size al cliente
			int size = collDepts.size();
			dos.writeInt(size);
			
			//envio la coleccion de departamentos
			for(DeptDTO dto:collDepts){
				dos.writeUTF(dto.toString());
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	private void _obtenerEmpleados(DataInputStream dis, DataOutputStream out){
		try{
			EmpDAO dao = (EmpDAO)FactoryMethod.getInstancia("EMP");
			
			
			//leo el depto
			int deptno = dis.readInt();
			
			//obtengo la coleccion de los empleados
			Collection<EmpDTO> collEmp = dao.getEmployees(deptno);
			
			//envio el size al cliente
			int size = collEmp.size();
			dos.writeInt(size);
			
			//envio la coleccion de empleados
			for(EmpDTO dto:collEmp){
				dos.writeUTF(dto.toString());
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
