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
import br.edu.fatec.bean.Filme;
import br.edu.fatec.dao.ReservaDAO;

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
	private JTextField txtCodFilme;
	private JLabel lbNumCarterinha;
	private JLabel lbDataNasc;
	private JLabel lbEmail;
	private JLabel lbNome;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblNCarterinha;
	private JLabel lblDataNasc;
	private JLabel lblTitulo;
	private JLabel lblGnero;
	private JLabel lblDiretor;
	private JLabel lblAno;
	private JLabel lbTituloFilme;
	private JLabel lbDiretorFilme;
	private JButton btnProcurarFilmeReserva;
	private Cliente cliente;
	private Filme filme;

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
		
		txtCodFilme = new JTextField();
		txtCodFilme.setBounds(871, 69, 141, 20);
		contentPane.add(txtCodFilme);
		txtCodFilme.setColumns(10);
		
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
					cliente  = clientes.get(0);
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
		
		lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(751, 153, 75, 14);
		contentPane.add(lblTitulo);
		
		lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGnero.setBounds(751, 261, 75, 14);
		contentPane.add(lblGnero);
		
		lblDiretor = new JLabel("Diretor:");
		lblDiretor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiretor.setBounds(751, 196, 75, 14);
		contentPane.add(lblDiretor);
		
		lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAno.setBounds(751, 234, 46, 14);
		contentPane.add(lblAno);
		
		lbTituloFilme = new JLabel("");
		lbTituloFilme.setBounds(836, 153, 176, 14);
		contentPane.add(lbTituloFilme);
		
		lbDiretorFilme = new JLabel("");
		lbDiretorFilme.setBounds(836, 197, 176, 14);
		contentPane.add(lbDiretorFilme);
		
		final JLabel lbAnoFilme = new JLabel("");
		lbAnoFilme.setBounds(836, 235, 176, 14);
		contentPane.add(lbAnoFilme);
		
		final JLabel lbGeneroFilme = new JLabel("");
		lbGeneroFilme.setBounds(836, 261, 176, 14);
		contentPane.add(lbGeneroFilme);
		
		btnProcurarFilmeReserva = new JButton("");
		btnProcurarFilmeReserva.setIcon(new ImageIcon(TelaReserva.class.getResource("/br/tcc/sbtk/imagens/find-icon.png")));
		btnProcurarFilmeReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Filme> filmes  = (List<Filme>) consultaBD(txtCodFilme.getText(), 1);
			
				if (!filmes.isEmpty() && filmes.size() > 0){
					filme  = filmes.get(0);
					lbTituloFilme.setText(filme.getTitulo());
					lbDiretorFilme.setText(filme.getDiretor());
					lbAnoFilme.setText(filme.getAno());
					lbGeneroFilme.setText(filme.getGenero());
					
					if(filme.getReservado().equals("S")){
						JOptionPane.showMessageDialog(null, "Filme já Reservado!");
						//TODO setar o botão fazer reserva como desabilitado
					}
					
				} else {
					JOptionPane.showConfirmDialog(null, "Filme não encontrado");
					
				}
			
			}
		});
		btnProcurarFilmeReserva.setBounds(1022, 68, 89, 23);
		contentPane.add(btnProcurarFilmeReserva);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					ReservaDAO dao = new ReservaDAO();
					dao.salvar(cliente, filme);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		btnReservar.setBounds(865, 622, 89, 23);
		contentPane.add(btnReservar);
	}
}
