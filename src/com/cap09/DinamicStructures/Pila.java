package com.cap09.DinamicStructures;

public class Pila<T> {
	Nodo<T> p;
	
	public void apilar(T v){
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(v);
		nuevo.setRef(p);
		p=nuevo;
	}
	
	public Nodo<T> desapilar(){
		Nodo<T> ret=p;
		if(p!=null){
			p=p.getRef();
		}
		return ret;
	}
	
	
}
