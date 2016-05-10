package Servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Hilo_Cliente extends Thread {
	
	DataOutputStream salida;
	DataInputStream entrada;
	BufferedReader datos;
	public Hilo_Cliente(Socket s) {
		try {
			System.out.println(s.getInetAddress()+":"+s.getPort());
			salida = new DataOutputStream(s.getOutputStream());
			entrada = new DataInputStream(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while (true) {
			try {
				if ((Servidor.buffer = entrada.readLine()) != null) {
					for (int i = 0; i < Servidor.clientes; i++) {
						Servidor.hilo_cliente[i].salida.writeChars(Servidor.buffer);
						System.out.println(Servidor.buffer);
						Servidor.buffer = null;
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
