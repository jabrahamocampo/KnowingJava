package com.cap12.FrameworkDBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cap12.FrameworkXMLReader.XMLFactory;
import com.cap12.FrameworkXMLReader.XTag;


public class XFactory {
	
	private static XFactory instancia;
	private XSession session;
	private XConnectionPool connectionPool;
	
	public Object findByPrimaryKey(Class dtoClass, Object pk){
		//Obtengo el pool de conexiones
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		
		//Obtengo una conexion
		Connection con = pool.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			//armo el query
			String sql = "";
			sql += "select"+_obtenerListaDeCampos(dtoClass)+" ";
			
			//from de la tabla
			sql += "FROM"+_obtenerNombreDeTabla(dtoClass)+" ";
			
			//where campoPK = ?
			sql += "WHERE "+_obtenerClavePrimaria(dtoClass);
			
			//preparo la sentecia
			pstm = con.prepareStatement(sql);
			
			//seteo el parametro sobre la sentencia
			pstm.setObject(1, pk);
			
			//ejecuto el query
			rs = pstm.executeQuery();
			
			if(rs.next()){
				//obtengo una instancia del DTO
				//y seteo los datos del resultset
				Object dto = _obtenerInstancia(dtoClass);
				_invocarSetters(dto,rs,dtoClass);
				
				
				//si hay otra fila entonces hay inconsistencia de datos
				if(rs.next()){
					throw new RuntimeException("Hay mas de una fila wey!!");
				}
				
				//retorno el dto
				return dto;
			}
			return null;
			
		}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
		}finally{
				try{
					if(rs!=null) rs.close();
					if(pstm!=null) pstm.close();
					pool.releaseConnection(con);
				}catch(Exception ex){
					ex.printStackTrace();
					throw new RuntimeException();
				}
		}
	}
	
	private String _obtenerListaDeCampos(Class dto){
		XTag[] fields = UXml.getFieldsTAG(dto.getName());
		
		String ret = "";
		for(int i=0; i<fields.length; i++){
			ret+=fields[i].getAtts().get("name")+((i<fields.length-1)?", ":"");
		}
		return ret;
	}
	
	private String _obtenerNombreDeTabla(Class dto){
		XTag tt = UXml.getTableTag(dto.getName());
		return tt.getAtts().get("name");
	}
	
	private String _obtenerClavePrimaria(Class dto){
		XTag[] fields = UXml.getFieldsTAG(dto.getName());
		boolean isPk;
		String sPk;
		String ret = "";
		
		for(int i=0; i<fields.length; i++){
			sPk =  fields[i].getAtts().get("pk");
			isPk = sPk!=null?sPk.equals("true"):false;
			if(isPk){
				if(i>0){
					ret+=", ";
				}
				ret+=fields[i].getAtts().get("name")+" = ? ";
			}
		}
		return ret;
	}
	
	private Object _obtenerInstancia(){
		try{
			return dtoClass.newInstance();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	private void _invocarSetters(Object dto, ResultSet rs, Class dtoClass){
		try{
			//obtengo la lista de tags<fields> de la tabla
			XTag[] fields = UXml.getFieldsTAG(dto.getClass().getName());
			
			//por cada campo voy a invocar a setX en cada dto
			for(int i=0; i<fields.length; i++){
				attName = fields[i].getAtts().get("att");
				value = rs.getObject(fields[i].getAtts().get("name"));
				
				//invoco al setter
				UBean.invoqueSetter(dto,attName,value);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	private XFactory(){
		session = new XSession();
		connectionPool = new XConnectionPool();
	}

	public static XFactory getInstancia() {
		if(instancia == null){
			instancia = new XFactory();
		}
		
		return instancia;
	}

	public static void setInstancia(XFactory instancia) {
		XFactory.instancia = instancia;
	}

	public XSession getSession() {
		return session;
	}

	public void setSession(XSession session) {
		this.session = session;
	}

	public XConnectionPool getConnectionPool() {
		return connectionPool;
	}

	public void setConnectionPool(XConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}
	
	
	
}
