package servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import util.SocketHandler;
import vista.FrameServidor;

public class Servidor implements ActionListener{

	private static final int PORT = 5000;
	private ServerSocket skServer;
	private SocketHandler skHandler;
	private DefaultListModel<String> chat;
	private ArrayList<String> nombres;
	private ArrayList<HiloCliente> clientes;
	private FrameServidor frameServidor;
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Servidor servidor = new Servidor();
	}
	
	public Servidor() {
		chat = new DefaultListModel<String>();
		nombres = new ArrayList<String>();
		clientes = new ArrayList<HiloCliente>();
		frameServidor = new FrameServidor();
		frameServidor.btnSalir.addActionListener(this);
		
		try {
			skServer = new ServerSocket(PORT);
			System.out.println("Esperando conexiones en el puerto " + PORT + "...");
			while (true) {
				skHandler = new SocketHandler(skServer.accept());
				System.out.println("Atendiendo cliente...");
				String nick = skHandler.readStream();
				frameServidor.txtChat.append(nick);
				Thread.sleep(200);
				if (!isNickDisponible(nick)) {
					skHandler.writeStream("0");
					skHandler.closeSocket();
				}else {
					skHandler.writeStream("1");
					//iniciar hilo
					chat.addElement(nick);
					HiloCliente cliente = new HiloCliente(skHandler, this);
					Thread hilo = new Thread(cliente);
					clientes.add(cliente);
					hilo.start();
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean isNickDisponible(String newNick) {
		for(String nick:nombres) 
			if(nick.equals(newNick))
				return false;
		nombres.add(newNick);
		return true;
	}

	public void broadcast() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Salir":
			// Cerrar todo
			break;
		default:
			System.out.println("Error");
		}
	}
	
}
