package com.cap09.DinamicStructures;

public class TestListaEnlazada {
	public static void main(String[] args){
		
		//instancio una lista enlazada
		ListaEnlazada<Integer> listEnlazada = new ListaEnlazada<Integer>();
		
		//le agrego los elementos a la nueva lista
		listEnlazada.agregarAlFinal(9);
		listEnlazada.agregarAlFinal(8);
		listEnlazada.agregarAlFinal(7);
		listEnlazada.agregarAlFinal(6);
		
		listEnlazada.agregarAlPrincipio(3);
		listEnlazada.agregarAlPrincipio(2);
		listEnlazada.agregarAlPrincipio(1);
		
		//muestro el contenido de la lista
		System.out.println(listEnlazada);
		
		//verifico si existe un nodo con valor 6
		System.out.println(listEnlazada.buscar(6));
		
		//verifico si existe un nodo con valor 15
		System.out.println(listEnlazada.buscar(15));
				
		//elimino el nodo con valor 3
		System.out.println(listEnlazada.eliminar(3));
		
		//vuelvo a mostrar la lista
		System.out.println(listEnlazada);
	}
}
