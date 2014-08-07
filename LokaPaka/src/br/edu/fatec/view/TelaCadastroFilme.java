package br.edu.fatec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtAno;
	private JTextField txtNomeFilme;
	private JTextField txtDiretor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFilme frame = new TelaCadastroFilme();
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
	public TelaCadastroFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 434, 41);
		contentPane.add(panel);
		
		JLabel lblCadastroDeFilme = new JLabel("CADASTRO DE FILME");
		lblCadastroDeFilme.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblCadastroDeFilme);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(35, 100, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setBounds(35, 125, 46, 14);
		contentPane.add(lblDiretor);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(35, 156, 46, 14);
		contentPane.add(lblAno);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A\u00E7\u00E3o", "Anima\u00E7\u00E3o", "Aventura", "Chanchada", "Cinema cat\u00E1strofe", "Com\u00E9dia", "Com\u00E9dia rom\u00E2ntica", "Com\u00E9dia dram\u00E1tica", "Com\u00E9dia de a\u00E7\u00E3o", "Cult", "Dan\u00E7a", "Document\u00E1rios ", "Drama", "Espionagem", "Er\u00F3tico", "Fantasia", "Faroeste ", "Fic\u00E7\u00E3o cient\u00EDfica", "Franchise/S\u00E9ries", "Guerra", "Machinima", "Masala", "Musical", "Filme noir", "Policial", "Pornochanchada", "Pornogr\u00E1fico", "Romance", "Suspense", "Terror ", "Trash"}));
		comboBox.setBounds(264, 153, 138, 20);
		contentPane.add(comboBox);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setBounds(195, 156, 46, 14);
		contentPane.add(lblGenero);
		
		txtAno = new JTextField();
		txtAno.setBounds(84, 153, 86, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		txtNomeFilme = new JTextField();
		txtNomeFilme.setBounds(84, 97, 318, 20);
		contentPane.add(txtNomeFilme);
		txtNomeFilme.setColumns(10);
		
		txtDiretor = new JTextField();
		txtDiretor.setBounds(84, 122, 318, 20);
		contentPane.add(txtDiretor);
		txtDiretor.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(313, 203, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MainLayout().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(81, 203, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblCdigoDoFilme = new JLabel("C\u00F3digo do Filme:");
		lblCdigoDoFilme.setBounds(35, 61, 97, 14);
		contentPane.add(lblCdigoDoFilme);
		
		textField = new JTextField();
		textField.setBounds(128, 58, 274, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(208, 203, 89, 23);
		contentPane.add(btnAlterar);
	}
}
