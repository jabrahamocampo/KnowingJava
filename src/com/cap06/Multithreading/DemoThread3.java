package com.cap06.Multithreading;

public class DemoThread3{
	public static void main(String[] args){
		MiThread My1 = new MiThread("JOSELO");
		MiThread My2 = new MiThread("BERE");
		
		My2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		
		My1.start();
		My2.start();
	}
	
	static class MiThread extends Thread{
		String nom;
		
		public MiThread(String nom){
			this.nom = nom;
		}
		
		public void run(){
			for(int i=0; i<=5; i++){
				System.out.println(nom + " - "+i);
				yield();
			}
		}
	}
}
