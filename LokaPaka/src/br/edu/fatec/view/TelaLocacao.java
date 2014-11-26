package br.edu.fatec.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.bean.Funcionario;
import br.edu.fatec.bean.Locacao;
import br.edu.fatec.bean.Reserva;
import br.edu.fatec.dao.LocacaoDAO;
import br.edu.fatec.dao.ReservaDAO;
import br.edu.fatec.util.Dispatcher;
import br.edu.fatec.util.Listener;

public class TelaLocacao extends TelaConsulta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodFilme;
	private JLabel lblDataDevolucao;
	private JLabel lbNome;
	private JButton btnAlugar;
	private Funcionario funcionario;
	private JFormattedTextField txtCarterinha;
	private Filme filme;
	private Cliente cliente;
	private JLabel lblDataAtual;
	private JTextField textField;
	private JTextField textFieldDevRealizada;

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

	public void setFuncionario(Funcionario func) {
		funcionario = func;
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public TelaLocacao() throws ParseException {

		setBounds(100, 100, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlugarFilme = new JLabel("ALUGAR OU DEVOLVER FILME");
		lblAlugarFilme.setForeground(Color.WHITE);
		lblAlugarFilme.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlugarFilme.setBounds(568, 23, 335, 20);
		contentPane.add(lblAlugarFilme);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, 1366, 84);
		contentPane.add(panel);

		JLabel label = new JLabel("C\u00F3digo filme:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(843, 201, 110, 14);
		contentPane.add(label);

		txtCodFilme = new JTextField();
		txtCodFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCodFilme.setColumns(10);
		txtCodFilme.setBounds(963, 198, 141, 20);
		contentPane.add(txtCodFilme);

		JLabel label_1 = new JLabel("Titulo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(843, 271, 75, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("G\u00EAnero:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(843, 409, 75, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Diretor:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(843, 310, 75, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Ano:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(843, 361, 46, 14);
		contentPane.add(label_4);

		final JLabel lbTitulo = new JLabel("");
		lbTitulo.setForeground(Color.GRAY);
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTitulo.setBounds(963, 271, 197, 14);
		contentPane.add(lbTitulo);

		final JLabel lbDiretor = new JLabel("");
		lbDiretor.setForeground(Color.GRAY);
		lbDiretor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDiretor.setBounds(963, 310, 197, 14);
		contentPane.add(lbDiretor);

		final JLabel lbAno = new JLabel("");
		lbAno.setForeground(Color.GRAY);
		lbAno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbAno.setBounds(963, 361, 197, 14);
		contentPane.add(lbAno);

		final JLabel lbGenero = new JLabel("");
		lbGenero.setForeground(Color.GRAY);
		lbGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbGenero.setBounds(963, 409, 197, 14);
		contentPane.add(lbGenero);

		JButton btnPesquisarFilme = new JButton("");
		btnPesquisarFilme.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				List<Filme> filmes = (List<Filme>) consultaBD(
						txtCodFilme.getText(), 1);

				if (!filmes.isEmpty() && filmes.size() > 0) {
					filme = filmes.get(0);
					lbTitulo.setText(filme.getTitulo());
					lbDiretor.setText(filme.getDiretor());
					lbAno.setText(filme.getAno());
					lbGenero.setText(filme.getGenero());

					if ((lbNome.getText().equals(""))
							|| (lbTitulo.getText().equals(""))) {
						btnAlugar.setEnabled(false);
					} else {
						btnAlugar.setEnabled(true);
					}
					if (filme.getReservado().equals("S")) {
						JOptionPane.showMessageDialog(null,
								"Filme já Reservado!");
						// TODO setar o botão fazer reserva como desabilitado
						btnAlugar.setEnabled(false);
					}

				} else {
					JOptionPane.showConfirmDialog(null, "Filme não encontrado");

				}
			}
		});
		btnPesquisarFilme.setIcon(new ImageIcon(TelaLocacao.class
				.getResource("/br/edu/fatec/icons/zoom.png")));
		btnPesquisarFilme.setBounds(1114, 198, 46, 23);
		contentPane.add(btnPesquisarFilme);

		JLabel label_9 = new JLabel("CPF do Cliente:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(133, 271, 207, 14);
		contentPane.add(label_9);

		txtCarterinha = new JFormattedTextField();
		txtCarterinha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCarterinha.setColumns(10);
		txtCarterinha.setBounds(298, 195, 225, 20);
		contentPane.add(txtCarterinha);

		lbNome = new JLabel("");
		lbNome.setForeground(Color.GRAY);
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbNome.setBounds(298, 309, 275, 14);
		contentPane.add(lbNome);

		final JLabel lbEmail = new JLabel("");
		lbEmail.setForeground(Color.GRAY);
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbEmail.setBounds(298, 408, 275, 14);
		contentPane.add(lbEmail);

		final JLabel lbCpf = new JLabel("");
		lbCpf.setForeground(Color.GRAY);
		lbCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbCpf.setBounds(298, 270, 275, 14);
		contentPane.add(lbCpf);

		final JLabel lbDataNasc = new JLabel("");
		lbDataNasc.setForeground(Color.GRAY);
		lbDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDataNasc.setBounds(298, 360, 275, 14);
		contentPane.add(lbDataNasc);

		JButton btnPesquisarCliente = new JButton("");
		btnPesquisarCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				List<Cliente> clientes = (List<Cliente>) consultaBD(
						txtCarterinha.getText(), 0);

				if (!clientes.isEmpty() && clientes.size() > 0) {
					cliente = clientes.get(0);
					lbNome.setText(cliente.getNomeCliente());
					lbCpf.setText(cliente.getCpf());
					lbDataNasc.setText(cliente.getDataNasci());
					lbEmail.setText(cliente.getEmail());

				} else {
					int resposta = JOptionPane.showConfirmDialog(null,
							"Cliente não cadastrado. Deseja cadastrar?");
					if (resposta == JOptionPane.YES_OPTION) {
						try {
							Listener listener = new TelaCadastroCliente();
							TelaCadastroCliente t = (TelaCadastroCliente) listener;
							t.setVisible(true);

							// Dispatcher.getInstance().

							Dispatcher.getInstance().addListener(
									new Listener() {

										@Override
										public void onClienteCadastrado(
												Cliente cliente) {
											if (cliente != null) {
												txtCarterinha.setText(cliente
														.getNumCarterinha());
												lbNome.setText(cliente
														.getNomeCliente());
												lbCpf.setText(cliente.getCpf());
												lbDataNasc.setText(cliente
														.getDataNasci());
												lbEmail.setText(cliente
														.getEmail());
											}
										}

									});

							if (cliente != null) {
								txtCarterinha.setText(cliente
										.getNumCarterinha());
								lbNome.setText(cliente.getNomeCliente());
								lbCpf.setText(cliente.getCpf());
								lbDataNasc.setText(cliente.getDataNasci());
								lbEmail.setText(cliente.getEmail());
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						txtCarterinha.setText("");
						lbNome.setText("");
						lbCpf.setText("");
						lbDataNasc.setText("");
						lbEmail.setText("");
					}
				}
			}
		});
		btnPesquisarCliente.setIcon(new ImageIcon(TelaLocacao.class
				.getResource("/br/edu/fatec/icons/zoom.png")));
		btnPesquisarCliente.setBounds(533, 194, 40, 23);
		contentPane.add(btnPesquisarCliente);

		JLabel label_14 = new JLabel("Nome:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_14.setBounds(133, 309, 70, 14);
		contentPane.add(label_14);

		JLabel label_15 = new JLabel("Email:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_15.setBounds(133, 408, 70, 14);
		contentPane.add(label_15);

		JLabel label_16 = new JLabel("N\u00BA Carterinha:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_16.setBounds(133, 201, 159, 14);
		contentPane.add(label_16);

		JLabel label_17 = new JLabel("Data Nasc:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_17.setBounds(133, 360, 130, 14);
		contentPane.add(label_17);

		btnAlugar = new JButton("Alugar");
		btnAlugar.setEnabled(false);
		btnAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Locacao locacao = new Locacao();
				locacao.setCodFilme(txtCodFilme.getText());
				locacao.setCodFuncionario(funcionario.getCodFunc());
				locacao.setNumCarterinha(txtCarterinha.getText());
				locacao.setDataLocacao(lblDataAtual.getText());
				locacao.setDataDevolucao(lblDataDevolucao.getText());
				
				boolean dadosOk = verificaDisponibilidade(locacao);
				
				if(dadosOk){
				LocacaoDAO dao2;
				try {
					dao2 = new LocacaoDAO();
					dao2.locar(locacao);
					
					JOptionPane.showMessageDialog(null,
							"Locação efetuada com sucesso!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Não é possível fazer a locação");
				}
				
				} else {
					
						int resposta = JOptionPane.showConfirmDialog(null, "Filme indisponível, Deseja reservar o filme?");
						btnAlugar.setEnabled(false);
						if(resposta == JOptionPane.YES_OPTION){
							dispose();
							try {
								new TelaReserva().setVisible(true);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					
				}
				
				
				/*
				try {
					dao2 = new LocacaoDAO();
					if (!dao2.alugado(locacao)) {
						try {

							dao2.locar(locacao);

							JOptionPane.showMessageDialog(null,
									"Locação efetuada com sucesso!");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null,
									"Não é possível fazer a locação");
						}
					} else {
						int resposta = JOptionPane.showConfirmDialog(null, "Filme indisponível, Deseja reservar o filme?");
						btnAlugar.setEnabled(false);
						if(resposta == JOptionPane.YES_OPTION){
							dispose();
							new TelaReserva().setVisible(true);
						}
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/

			}
		});
		btnAlugar.setIcon(new ImageIcon(TelaLocacao.class
				.getResource("/br/edu/fatec/icons/accept.png")));
		btnAlugar.setBounds(1148, 612, 141, 51);
		contentPane.add(btnAlugar);

		JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o:");
		lblDataDeDevoluo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataDeDevoluo.setBounds(759, 586, 159, 14);
		contentPane.add(lblDataDeDevoluo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Filme"));
		panel_2.setBounds(722, 147, 597, 326);
		contentPane.add(panel_2);

		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		String d = form.format(date);
		String data[] = d.split("/");
		int day = Integer.parseInt(data[0]);
		// int month = Integer.parseInt(data[1]);
		// int year = Integer.parseInt(data[2]);
		day += 7;
		date.setDate(day);
		String d2 = form.format(date);
		lblDataDevolucao = new JLabel(d2);
		lblDataDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDevolucao.setBounds(945, 586, 159, 14);
		contentPane.add(lblDataDevolucao);

		lblDataAtual = new JLabel(d);
		lblDataAtual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataAtual.setBounds(945, 546, 85, 14);
		contentPane.add(lblDataAtual);

		JLabel lblDataAtual_1 = new JLabel("Data Atual:");
		lblDataAtual_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataAtual_1.setBounds(759, 546, 159, 14);
		contentPane.add(lblDataAtual_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Cliente"));
		panel_1.setBounds(80, 147, 597, 326);
		contentPane.add(panel_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(TelaLocacao.class.getResource("/br/edu/fatec/icons/arrow_left.png")));
		button.setBounds(20, 723, 89, 23);
		contentPane.add(button);
		
		JLabel lblFilmeDevolvidoEm = new JLabel("Filme Devolvido em:");
		lblFilmeDevolvidoEm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFilmeDevolvidoEm.setBounds(128, 564, 225, 14);
		contentPane.add(lblFilmeDevolvidoEm);
		
		textField = new JTextField();
		textFieldDevRealizada = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textFieldDevRealizada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDevRealizada.setBounds(363, 561, 134, 20);
		contentPane.add(textFieldDevRealizada);
		textFieldDevRealizada.setColumns(10);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setIcon(new ImageIcon(TelaLocacao.class.getResource("/br/edu/fatec/icons/arrow_down.png")));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Locacao locacao = new Locacao();
				locacao.setCodFilme(txtCodFilme.getText());
				locacao.setCodFuncionario(funcionario.getCodFunc());
				locacao.setNumCarterinha(txtCarterinha.getText());
				locacao.setDataLocacao(lblDataAtual.getText());
				locacao.setDataDevolucao(lblDataDevolucao.getText());
				locacao.setDataDevRealizada(textFieldDevRealizada.getText());
				LocacaoDAO dao4;
				
				
				try {
					dao4 = new LocacaoDAO();
					dao4.devolver(locacao);
					
					JOptionPane.showMessageDialog(null,
							"Filme devolvido com sucesso!");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Não foi possível fazer a devolução!");
				}
				
			}
		});
		btnDevolver.setBounds(533, 612, 130, 51);
		contentPane.add(btnDevolver);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(BorderFactory.createTitledBorder("Devolver"));
		panel_3.setBounds(80, 499, 597, 210);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(BorderFactory.createTitledBorder("Alugar"));
		panel_4.setBounds(722, 499, 597, 210);
		contentPane.add(panel_4);
	}
	
	public boolean verificaDisponibilidade(Locacao locacao){
		
		try {
			LocacaoDAO dao3 = new LocacaoDAO();
			boolean dadosOk = dao3.alugar(locacao);
			if(dadosOk){
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
