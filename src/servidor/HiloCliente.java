package servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.SocketHandler;
import vista.FrameChatCliente;

public class HiloCliente implements Runnable, ActionListener {

	private boolean alive;
	private FrameChatCliente frameChat;
	private SocketHandler skHandler;
	private Servidor servidor;

	public HiloCliente(SocketHandler skHandler, Servidor servidor) {
		frameChat = new FrameChatCliente();
		frameChat.btnEnviar.addActionListener(this);
		frameChat.btnSalir.addActionListener(this);

		this.skHandler = skHandler;
		this.servidor = servidor;
	}

	@Override
	public void run() {
		alive = true;
		while (alive) {
			String newMsgs = skHandler.readStream();
			frameChat.txtChat.append(newMsgs);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Enviar":
			enviarMensaje(frameChat.txtMsg.getText());
			servidor.broadcast();
			borrarTexto();
			break;
		case "Salir":
			cerrarCliente();
			break;
		default:
			System.out.println("Error");
		}
	}

	private void borrarTexto() {
		frameChat.txtMsg.setText("");
	}

	private void enviarMensaje(String text) {
		skHandler.writeStream(text);
	}

	private void cerrarCliente() {
		alive = false;
		skHandler.closeSocket();
	}

}
