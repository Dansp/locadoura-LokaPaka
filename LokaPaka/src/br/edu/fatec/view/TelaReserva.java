package br.edu.fatec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.dao.FilmeDAO;
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
	private JTextField txtCpfPesquisa_1;
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
	private JButton btnReservar;
	private JPanel panel_1;
	private JPanel panel_2;

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
		lblCdigoDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCdigoDoCliente.setBounds(64, 236, 207, 14);
		contentPane.add(lblCdigoDoCliente);
		
		txtCpfPesquisa = new JTextField();
		txtCpfPesquisa_1 = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpfPesquisa_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCpfPesquisa_1.setBounds(229, 233, 225, 20);
		contentPane.add(txtCpfPesquisa_1);
		txtCpfPesquisa_1.setColumns(10);
		
		JLabel lblCdigoFilme = new JLabel("C\u00F3digo filme:");
		lblCdigoFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCdigoFilme.setBounds(751, 238, 110, 14);
		contentPane.add(lblCdigoFilme);
		
		txtCodFilme = new JTextField();
		txtCodFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCodFilme.setBounds(871, 235, 141, 20);
		contentPane.add(txtCodFilme);
		txtCodFilme.setColumns(10);
		
		lbNome = new JLabel("");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbNome.setForeground(Color.GRAY);
		lbNome.setBounds(229, 347, 227, 14);
		contentPane.add(lbNome);
		
		lbEmail = new JLabel("");
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbEmail.setForeground(Color.GRAY);
		lbEmail.setBounds(229, 446, 225, 14);
		contentPane.add(lbEmail);
		
		lbNumCarterinha = new JLabel("");
		lbNumCarterinha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbNumCarterinha.setForeground(Color.GRAY);
		lbNumCarterinha.setBounds(229, 308, 225, 14);
		contentPane.add(lbNumCarterinha);
		
		lbDataNasc = new JLabel("");
		lbDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDataNasc.setForeground(Color.GRAY);
		lbDataNasc.setBounds(229, 398, 225, 14);
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
		btnProcurarClienteReserva.setBounds(464, 232, 40, 23);
		contentPane.add(btnProcurarClienteReserva);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(64, 347, 70, 14);
		contentPane.add(lblNome);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(64, 446, 70, 14);
		contentPane.add(lblEmail);
		
		lblNCarterinha = new JLabel("N\u00BA Carterinha:");
		lblNCarterinha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNCarterinha.setBounds(64, 308, 159, 14);
		contentPane.add(lblNCarterinha);
		
		lblDataNasc = new JLabel("Data Nasc:");
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataNasc.setBounds(64, 398, 130, 14);
		contentPane.add(lblDataNasc);
		
		lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(751, 308, 75, 14);
		contentPane.add(lblTitulo);
		
		lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGnero.setBounds(751, 446, 75, 14);
		contentPane.add(lblGnero);
		
		lblDiretor = new JLabel("Diretor:");
		lblDiretor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiretor.setBounds(751, 347, 75, 14);
		contentPane.add(lblDiretor);
		
		lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAno.setBounds(751, 398, 46, 14);
		contentPane.add(lblAno);
		
		lbTituloFilme = new JLabel("");
		lbTituloFilme.setForeground(Color.GRAY);
		lbTituloFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTituloFilme.setBounds(871, 308, 141, 14);
		contentPane.add(lbTituloFilme);
		
		lbDiretorFilme = new JLabel("");
		lbDiretorFilme.setForeground(Color.GRAY);
		lbDiretorFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDiretorFilme.setBounds(871, 347, 141, 14);
		contentPane.add(lbDiretorFilme);
		
		final JLabel lbAnoFilme = new JLabel("");
		lbAnoFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbAnoFilme.setForeground(Color.GRAY);
		lbAnoFilme.setBounds(871, 398, 141, 14);
		contentPane.add(lbAnoFilme);
		
		final JLabel lbGeneroFilme = new JLabel("");
		lbGeneroFilme.setForeground(Color.GRAY);
		lbGeneroFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbGeneroFilme.setBounds(871, 446, 141, 14);
		contentPane.add(lbGeneroFilme);
		
		btnProcurarFilmeReserva = new JButton("");
		btnProcurarFilmeReserva.setIcon(new ImageIcon(TelaReserva.class.getResource("/br/edu/fatec/icons/zoom.png")));
		btnProcurarFilmeReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Filme> filmes  = (List<Filme>) consultaBD(txtCodFilme.getText(), 1);
			
				if (!filmes.isEmpty() && filmes.size() > 0){
					filme  = filmes.get(0);
					lbTituloFilme.setText(filme.getTitulo());
					lbDiretorFilme.setText(filme.getDiretor());
					lbAnoFilme.setText(filme.getAno());
					lbGeneroFilme.setText(filme.getGenero());
					
					if((lbNome.getText().equals("")) && (lbTituloFilme.getText().equals(""))){
						btnReservar.setEnabled(false);
					} else {
						btnReservar.setEnabled(true);
					}
					if(filme.getReservado().equals("S")){
						JOptionPane.showMessageDialog(null, "Filme já Reservado!");
						//TODO setar o botão fazer reserva como desabilitado
						btnReservar.setEnabled(false);
					}
					
				} else {
					JOptionPane.showConfirmDialog(null, "Filme não encontrado");
					
				}
			
			}
		});
		btnProcurarFilmeReserva.setBounds(1018, 232, 46, 23);
		contentPane.add(btnProcurarFilmeReserva);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setIcon(new ImageIcon(TelaReserva.class.getResource("/br/edu/fatec/icons/accept.png")));
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReservar.setEnabled(false);
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					ReservaDAO dao = new ReservaDAO();
					filme.setReservado("S");
					dao.salvar(cliente, filme);
					FilmeDAO dao2 = new FilmeDAO();
					dao2.alterar(filme);
				JOptionPane.showMessageDialog(null, "Reservado com sucesso!");
					
				} catch (Exception e) {
					filme.setReservado("N");
					e.printStackTrace();
				}
				
				
			}
		});
		btnReservar.setBounds(1108, 657, 199, 58);
		contentPane.add(btnReservar);
		
		JLabel lblReservarFilme = new JLabel("RESERVAR FILME");
		lblReservarFilme.setBounds(588, 23, 209, 20);
		contentPane.add(lblReservarFilme);
		lblReservarFilme.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReservarFilme.setForeground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 84);
		panel.setBackground(new Color(1, 162, 237));
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Cliente"));
		panel_1.setBounds(24, 177, 597, 326);
		contentPane.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Filme"));
		panel_2.setBounds(710, 177, 597, 326);
		contentPane.add(panel_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(TelaReserva.class.getResource("/br/edu/fatec/icons/arrow_left.png")));
		button.setBounds(24, 692, 89, 23);
		contentPane.add(button);
		
	
	}
}
