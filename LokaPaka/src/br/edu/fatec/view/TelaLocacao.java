package br.edu.fatec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaLocacao extends TelaConsulta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodFilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLocacao frame = new TelaLocacao();
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
	public TelaLocacao() {
		
		setBounds(100, 100, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlugarFilme = new JLabel("ALUGAR FILME");
		lblAlugarFilme.setForeground(Color.WHITE);
		lblAlugarFilme.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlugarFilme.setBounds(568, 23, 209, 20);
		contentPane.add(lblAlugarFilme);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, 1366, 84);
		contentPane.add(panel);
		
		JLabel label = new JLabel("C\u00F3digo filme:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(941, 275, 110, 14);
		contentPane.add(label);
		
		textFieldCodFilme = new JTextField();
		textFieldCodFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCodFilme.setColumns(10);
		textFieldCodFilme.setBounds(1061, 272, 141, 20);
		contentPane.add(textFieldCodFilme);
		
		JLabel label_1 = new JLabel("Titulo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(941, 345, 75, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("G\u00EAnero:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(941, 483, 75, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Diretor:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(941, 384, 75, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Ano:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(941, 435, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(1061, 345, 141, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(1061, 384, 141, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(1061, 435, 141, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(1061, 483, 141, 14);
		contentPane.add(label_8);
		
		JButton button = new JButton("");
		button.setBounds(1212, 272, 46, 23);
		contentPane.add(button);
	}
}
