package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	static Socket s;
	static String ip,nombre_usuario,mensaje;
	static int puerto;
	static Scanner sc;
	static DataOutputStream salida;
	static Hilo hilo;
	DataInputStream entrada;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Ip: ");
		ip = sc.next();
		puerto = 18888;
		System.out.print("Usuario: ");
		nombre_usuario = sc.next();
		
		try {
			s = new Socket(ip, puerto);
			hilo = new Hilo(new DataInputStream(s.getInputStream()));
			hilo.start();
			salida = new DataOutputStream(s.getOutputStream());
			while (true) {
				if ((mensaje = sc.next()) != null) {
					salida.writeChars(nombre_usuario+":"+mensaje);
					mensaje = null;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
