package Servidor;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {

	public static int clientes = 0;
	public static String buffer;
	public static Hilo_Cliente[] hilo_cliente;
	
	static ServerSocket ss;
	static Hilos hilo;
	
	public static void main(String[] args) {
        hilo_cliente = new Hilo_Cliente[20];
		try {
			ss = new ServerSocket(18888);
			hilo = new Hilos(ss);
			hilo.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
