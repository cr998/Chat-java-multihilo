package Cliente;

import java.io.DataInputStream;
import java.io.IOException;

public class Hilo extends Thread {

	DataInputStream entrada;
	String buffer;
	
	public Hilo(DataInputStream entrada) {
		this.entrada = entrada;
		run();
	}
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while (true) {
			try {
				if ((buffer = entrada.readLine()) != null) {
					System.out.println(buffer);
					buffer = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
