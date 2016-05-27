package com.cap11.Introspection.Annotations;

public class TestAnnotations {
	
	public static void main(String[] args) throws Exception{
		
		String sClass = "com.cap11.Introspection.Annotations.Demo";
		Class<?> clazz = Class.forName(sClass);
		
		HolaMundo a = clazz.getMethod("unMetodo").getAnnotation(HolaMundo.class);
		
		System.out.println("nombre === "+a.nombre());
		
	}
	
}
