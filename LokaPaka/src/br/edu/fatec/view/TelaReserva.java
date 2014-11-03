package br.edu.fatec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaReserva extends TelaConsulta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReserva frame = new TelaReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDoCliente = new JLabel("CPF do Cliente:");
		lblCdigoDoCliente.setBounds(64, 72, 116, 14);
		contentPane.add(lblCdigoDoCliente);
		
		textField = new JTextField();
		textField.setBounds(190, 69, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblReservarFilme = new JLabel("Reservar Filme");
		lblReservarFilme.setBounds(250, 11, 126, 14);
		contentPane.add(lblReservarFilme);
		
		JLabel lblCdigoFilme = new JLabel("C\u00F3digo filme:");
		lblCdigoFilme.setBounds(751, 72, 110, 14);
		contentPane.add(lblCdigoFilme);
		
		textField_1 = new JTextField();
		textField_1.setBounds(871, 69, 141, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
