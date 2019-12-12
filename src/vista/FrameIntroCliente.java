package vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrameIntroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblIntroNick;
	public JTextField txtNick;
	public JLabel lblMsgError;
	public JButton btnAceptar;

	/**
	 * Create the frame.
	 */
	public FrameIntroCliente() {
		setPreferredSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Cliente Intro");
		setVisible(true);
		pack();
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(200, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(contentPane);
		
		lblIntroNick = new JLabel("Introduce tu nick:");
		lblIntroNick.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIntroNick.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIntroNick.setPreferredSize(new Dimension(180, 40));
		contentPane.add(lblIntroNick);
		
		txtNick = new JTextField();
		txtNick.setPreferredSize(new Dimension(180, 20));
		contentPane.add(txtNick);
		
		lblMsgError = new JLabel("");
		lblMsgError.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMsgError.setPreferredSize(new Dimension(180, 20));
		contentPane.add(lblMsgError);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setPreferredSize(new Dimension(120, 30));
		contentPane.add(btnAceptar);
	}

}
