package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Hilos extends Thread{

	ServerSocket ss;
	static Socket s;
	static boolean temp = true;
	
	public Hilos(ServerSocket ss) {
		this.ss = ss;
		run(ss);
	}
	
	public void run(ServerSocket ss) {
		System.out.println("Servidor iniciado.");
		this.ss = ss;
		while (true) {
			try {
				while (temp) {
					if ((s = ss.accept()) != null) {
				        Servidor.hilo_cliente[Servidor.clientes] = new Hilo_Cliente(s);
						Servidor.hilo_cliente[Servidor.clientes].start();
						Servidor.clientes++;
						temp = false;
					}
				}
				
				temp = true;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
