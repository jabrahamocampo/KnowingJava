package com.cap09.DinamicStructures;

public class ListaEnlazada<T> {
	//referencia al primer nodo de la lista
	private Nodo<T> p = null;
	
	public void agregarAlFinal(T v){
		//creo un nuevo nodo
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(v);
		nuevo.setRef(null);
		
		//si la lista aun no tiene elementos
		if(p == null){
			//el nuevo nodo sera el primero
			p=nuevo;
			return;
		}
		
		//retorno la lista hasta que aux apunte al ultimo nodo
		Nodo<T> aux;
		for(aux=p; aux.getRef() != null; aux=aux.getRef()){
			//enlazo el nuevo nodo como el siguiente del ultimo
			aux.setRef(nuevo);
		}
		
	}
	
	public void agregarAlPrincipio(T v){
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(v);
		nuevo.setRef(p);
		p = nuevo;
	}
	
	public Nodo<T> buscar(T v){
		Nodo<T> aux = p;
		while(aux!=null && !aux.getInfo().equals(v)){
			aux=aux.getRef();
		}
		return aux;
	}
	
	public Nodo<T> eliminar(T v){
		Nodo<T> act=p, ant=null;
		
		//busco nodo a eliminar
		while(act != null && !act.getInfo().equals(v)){
			ant = act;
			act = act.getRef();
		}
		
		//lo encontre al principio
		if(act != null && ant!=null){
			Nodo<T> ret = act;
			p = act.getRef();
			return ret;
		}
		
		//lo encontre por el medio
		if(act != null && ant != null){
			Nodo<T> ret = act;
			ant.setRef(act.getRef());
			return ret;
		}
		return null;
	}
	
	public String toString(){
		String x ="";
		Nodo<T> aux = p;
		while(aux!=null){
			x+=""+aux.getInfo()+(aux.getRef()!=null?", ":"");
			aux=aux.getRef();
		}
		return x;
	}
}






