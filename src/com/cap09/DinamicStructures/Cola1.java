package com.cap09.DinamicStructures;

public class Cola1<T> {
	
	private Nodo<T> p = null;
	private Nodo<T> q = null;
	
	public void encolar(T v){
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(v);
		nuevo.setRef(null);
		
		//si la cola esta vacia
		if(p==null){
			p = nuevo;
		}else{
			q.setRef(nuevo);
		}
		q = nuevo;
	}
	
	public Nodo<T> desencolar(){
		Nodo<T> ret = p;
		
		if(p!=q){
			p = p.getRef();
		}else{
			p=null;
			q=null;
		}
		return ret;
	}
}
