package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.SocketHandler;
import vista.FrameIntroCliente;

public class Cliente implements ActionListener {

	private static final String HOST = "localhost";
	private static final int PORT = 5000;
	private SocketHandler skHandler;
	private FrameIntroCliente frameIntro;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Cliente cliente = new Cliente();
	}
	
	public Cliente() {
		frameIntro = new FrameIntroCliente();
		frameIntro.btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Aceptar": conectarServidor();
		}
	}

	private void conectarServidor() {
		if(frameIntro.txtNick.getText().equals("")) {
			frameIntro.lblMsgError.setText("El nick no puede estar vacio");
		}else {
			try {
				skHandler = new SocketHandler(HOST, PORT);
				System.out.println("Conectado en puerto " + PORT);
				Thread.sleep(200);
				skHandler.writeStream(frameIntro.txtNick.getText());
				System.out.println("Escribiendo nick...");
				String nickDisponible = skHandler.readStream();
				System.out.println("disponible = " + nickDisponible);
				if(nickDisponible.equals("0")) {
					frameIntro.lblMsgError.setText("El nick ya existe");
					skHandler.closeSocket();
				}else
					frameIntro.dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
