package vista;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameChatCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtMsg;
	public JButton btnEnviar;
	public JTextArea txtChat;
	public JButton btnSalir;
	public JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public FrameChatCliente() {
		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Cliente Chat");
		setVisible(true);
		pack();
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(700, 550));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(contentPane);
		
		txtMsg = new JTextField();
		txtMsg.setPreferredSize(new Dimension(600, 20));
		contentPane.add(txtMsg);
		
		btnEnviar = new JButton("Enviar");
		contentPane.add(btnEnviar);
		
		txtChat = new JTextArea();
		txtChat.setEditable(false);
		scrollPane = new JScrollPane(txtChat);
		scrollPane.setPreferredSize(new Dimension(650, 500));
		contentPane.add(scrollPane);
		
		btnSalir = new JButton("Salir");
		contentPane.add(btnSalir);
		
	}

}
