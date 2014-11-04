package br.edu.fatec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.edu.fatec.bean.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaReserva extends TelaConsulta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpfPesquisa;
	private JTextField textField_1;
	private JLabel lbNumCarterinha;
	private JLabel lbDataNasc;
	private JLabel lbEmail;
	private JLabel lbNome;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblNCarterinha;
	private JLabel lblDataNasc;
	private JButton btnProcurarFilmeReserva;

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
	 * @throws ParseException 
	 */
	public TelaReserva() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDoCliente = new JLabel("CPF do Cliente:");
		lblCdigoDoCliente.setBounds(64, 72, 116, 14);
		contentPane.add(lblCdigoDoCliente);
		
		txtCpfPesquisa = new JTextField();
		txtCpfPesquisa = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpfPesquisa.setBounds(190, 69, 116, 20);
		contentPane.add(txtCpfPesquisa);
		txtCpfPesquisa.setColumns(10);
		
		JLabel lblReservarFilme = new JLabel("Reservar Filme");
		lblReservarFilme.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReservarFilme.setForeground(Color.WHITE);
		lblReservarFilme.setBounds(250, 11, 166, 32);
		contentPane.add(lblReservarFilme);
		
		JLabel lblCdigoFilme = new JLabel("C\u00F3digo filme:");
		lblCdigoFilme.setBounds(751, 72, 110, 14);
		contentPane.add(lblCdigoFilme);
		
		textField_1 = new JTextField();
		textField_1.setBounds(871, 69, 141, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lbNome = new JLabel("");
		lbNome.setForeground(Color.GRAY);
		lbNome.setBounds(158, 215, 242, 14);
		contentPane.add(lbNome);
		
		lbEmail = new JLabel("");
		lbEmail.setForeground(Color.GRAY);
		lbEmail.setBounds(158, 308, 242, 14);
		contentPane.add(lbEmail);
		
		lbNumCarterinha = new JLabel("");
		lbNumCarterinha.setForeground(Color.GRAY);
		lbNumCarterinha.setBounds(158, 153, 242, 14);
		contentPane.add(lbNumCarterinha);
		
		lbDataNasc = new JLabel("");
		lbDataNasc.setForeground(Color.GRAY);
		lbDataNasc.setBounds(158, 261, 242, 14);
		contentPane.add(lbDataNasc);
		
		JButton btnProcurarClienteReserva = new JButton("");
		btnProcurarClienteReserva.setIcon(new ImageIcon(TelaReserva.class.getResource("/br/edu/fatec/icons/zoom.png")));
		btnProcurarClienteReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				List<Cliente> clientes  = (List<Cliente>) consultaBD(txtCpfPesquisa.getText(), 0);
				
				if (!clientes.isEmpty() && clientes.size() > 0){
					Cliente cliente  = clientes.get(0);
					lbNome.setText(cliente.getNomeCliente());
					lbNumCarterinha.setText(cliente.getNumCarterinha());
					lbDataNasc.setText(cliente.getDataNasci());
					lbEmail.setText(cliente.getEmail());
					
				} else {
					int resposta = JOptionPane.showConfirmDialog(null, "Cliente não cadastrado. Deseja cadastrar?");
					if (resposta == JOptionPane.YES_OPTION){
						try {
							new TelaCadastroCliente().setVisible(true);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						txtCpfPesquisa.setText("");
						lbNome.setText("");
						lbNumCarterinha.setText("");
						lbDataNasc.setText("");
						lbEmail.setText("");
					}
				}
			}
		});
		btnProcurarClienteReserva.setBounds(311, 68, 40, 23);
		contentPane.add(btnProcurarClienteReserva);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(64, 215, 70, 14);
		contentPane.add(lblNome);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(64, 308, 70, 14);
		contentPane.add(lblEmail);
		
		lblNCarterinha = new JLabel("N\u00BA Carterinha:");
		lblNCarterinha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNCarterinha.setBounds(64, 153, 116, 14);
		contentPane.add(lblNCarterinha);
		
		lblDataNasc = new JLabel("Data Nasc:");
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataNasc.setBounds(64, 261, 84, 14);
		contentPane.add(lblDataNasc);
		
		btnProcurarFilmeReserva = new JButton("");
		btnProcurarFilmeReserva.setIcon(new ImageIcon(TelaReserva.class.getResource("/br/edu/fatec/icons/zoom.png")));
		btnProcurarFilmeReserva.setBounds(1017, 68, 40, 23);
		contentPane.add(btnProcurarFilmeReserva);
	}
}
