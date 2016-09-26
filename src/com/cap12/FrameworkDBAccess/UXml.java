package com.cap12.FrameworkDBAccess;

import com.cap12.FrameworkXMLReader.XMLFactory;
import com.cap12.FrameworkXMLReader.XTag;

public class UXml {
	public static XTag getTableTag(String dtoName){
		
		String path = "/framework/data-access/mapping/table";
		String attname = "type";
		String attvalue = dtoName;
		return XMLFactory.getByAttribute(path, attname, attvalue);

	}
	
	public static XTag[] getFieldsTAG(String dtoName){
		return getTableTAG(dtoName).getSubtags("field");
	}
	
	public static XTag getConnectionPoolTAG(){
		String path = "/framework/data-access/connection-pool";
		return XMLFactory.getByPath(path);
	}
}
