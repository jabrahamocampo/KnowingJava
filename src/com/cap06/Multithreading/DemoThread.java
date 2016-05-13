package com.cap06.Multithreading;

public class DemoThread extends Thread{
	
	private String name;
	
	public DemoThread(String name){
		this.name = name;
	}
	
	public void run(){
		try{
			int x = (int)(Math.random()*5000);
			Thread.sleep(x);
			System.out.println("Hola soy: "+name+" ("+x+")");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		DemoThread thread1 = new DemoThread("JOSELO");
		DemoThread thread2 = new DemoThread("BERE");
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println("Finalizo el programa");
	}

}
