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

public class FrameServidor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txtNumConexiones;
	public JTextArea txtChat;
	public JButton btnSalir;
	public JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public FrameServidor() {
		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Servidor");
		setVisible(true);
		pack();
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(700, 350));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(contentPane);
		
		txtNumConexiones = new JTextField();
		txtNumConexiones.setPreferredSize(new Dimension(650, 20));
		txtNumConexiones.setEnabled(false);
		contentPane.add(txtNumConexiones);
		
		txtChat = new JTextArea();
		txtChat.setEditable(false);
		scrollPane = new JScrollPane(txtChat);
		scrollPane.setPreferredSize(new Dimension(600, 500));
		contentPane.add(scrollPane);
		
		btnSalir = new JButton("Salir");
		contentPane.add(btnSalir);
	}

}
