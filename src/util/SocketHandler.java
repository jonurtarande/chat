package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler {

	private Socket socket;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;

	public SocketHandler(String host, int port) {
		openSocketCliente(host, port);
	}

	public SocketHandler(Socket socket) {
		this.socket = socket;
		try {
			salida = new ObjectOutputStream(socket.getOutputStream());
			//salida.flush();
			entrada = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isSocketOpened() {
		if (socket != null)
			return true;
		else
			return false;
	}

	public boolean openSocketCliente(String host, int port) {
		if (!isSocketOpened()) {
			try {
				socket = new Socket(host, port);
				salida = new ObjectOutputStream(socket.getOutputStream());
				entrada = new ObjectInputStream(socket.getInputStream());
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	public String readStream() {
		if (isSocketOpened()) {
			try {
				return entrada.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}return null;
	}

	public void writeStream(String stream) {
		if (isSocketOpened()) {
			try {
				salida.writeUTF(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean closeSocket() {
		if (isSocketOpened()) {
			try {
				salida.close();
				entrada.close();
				socket.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

}
