package edu.upc.eetac.dsa.rlorenzo.ThreadsRunnable;

//import org.omg.PortableServer.ThreadPolicyOperations;

public class CuentaAtras implements Runnable {
	Thread t;
	String nombre;
	static String ultimo;
	int num;

	public CuentaAtras(String nombre, int num){
		this.nombre=nombre;
		this.num = num;
		t=new Thread(this,"Thread");
	}
	
	public void start(){
		this.t.start();
	}
	
	public void run() {
		int aux=num;
		try{
			while(num != 0){
				System.out.println(nombre+" - "+num+" - Ultima escritura "+ultimo);
				ultimo = nombre;
				Thread.sleep(1000);
				num--;
				
			}
			System.out.println(nombre+" - "+num+" - Ultima escritura "+ultimo);
			if(num ==0){
				System.out.println("Ultima escritura "+nombre+" - "+(Thread.activeCount()-2)+" Threads activos");
				//System.out.println(Thread.activeCount()); tengo 3 hilos abiertos, pues segun este comando me salen 4	
			}
		}catch (InterruptedException e){
			System.out.println(e.toString());
		}	
	}
}
