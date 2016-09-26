package com.cap12.FrameworkDBAccess;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;

import com.cap12.FrameworkXMLReader.XTag;

public class UBean {
	public static void invoqueSetter(Object dto, String attName, Object value){
		try{
			//dado el attName obtengo el nombre del setter
			String mtdName = getSetterName(attName);
			
			Class[] argsType = null;
			
			Method mtd = null;
			
			try{
				//intento obtener el metodo
				argsType[0] = value.getClass();
				mtd = dto.getClass().getMethod(mtdName, argsType);
			}catch(NoSuchMethodException ex){
				//fallo...pruebo con el tipo primitivo
				argsType[0] = _wrapperToType(value.getClass());
				mtd = dto.getClass().getMethod(mtdName, argsType);
			}
			
			//invoco al setter
			mtd.invoke(dto, value);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	private static Class _wrapperToType(Class clazz){
		if(clazz.equals(Byte.class)) return Byte.TYPE;
		if(clazz.equals(Short.class)) return Short.TYPE;
		if(clazz.equals(Integer.class)) return Integer.TYPE;
		if(clazz.equals(Long.class)) return Long.TYPE;
		if(clazz.equals(Character.class)) return Character.TYPE;
		if(clazz.equals(Float.class)) return Float.TYPE;
		if(clazz.equals(Double.class)) return Double.TYPE;
	}
	
	public static String getSetterName(String attName){
		return UString.switchCase("set"+attName,3);
	}
	
	public int insert(Object dto){
		//obtengo el pool de conexones y le pido una conexion
		XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
		Connection con = pool.getConnection();
		PreparedStatement pstm = null;
		
		try{
			//armo el query
			String sql = "";
			sql += "Insert into ";
			sql += _obtenerNombreDeTabla(dto.getClass())+"( ";
			sql += _obtenerListaDeCampos(dto.getClass())+") ";
			sql += "VALUES (";
			sql += UString.replicate("?",cantCampos,",")+" )";
			
			//preparo la sentencia
			pstm = con.preparedStatement(sql);
			
			//seteo el parametro soble la sentencia
			_setearParametrosEnStatement(pstm,dto);
			
			//ejecuto el insert
			return pstm.executeUpdate();
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}finally{
			try{
				if(pstm!=null) pstm.close();
				pool.releaseConnection(con);
			}catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	private void _setearParametrosEnStatement(PreparedStatement pstm, Object dto){
		try{
			XTag[] fields = UXml.getFieldsTAG(dto.getClass().getName());
			Object value;
			for(int i=0; i<fields.length; i++){
				value = UBean.invoqueGetter(dto,fields[i].getAtts().get("att");
				pstm.setObject(i+1, value);
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public static Object invoqueGetter(Object dto, String attr){
		try{
			String mtdName = getGetterName(attr);
			Class[] parametersTypes = new Class[0];
			Method mtd = dto.getClass().getMethod(mtdName, parameterTypes);
			
			Object[] parameterValues = new Object[0];
			return mtd.invoke(dto,  parameterValues);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
