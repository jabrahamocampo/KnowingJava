package com.cap09.DinamicStructures;

public class Nodo<T> {
	
	private T info;
	private Nodo<T> ref;
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Nodo<T> getRef() {
		return ref;
	}
	public void setRef(Nodo<T> ref) {
		this.ref = ref;
	}
	
	
}
