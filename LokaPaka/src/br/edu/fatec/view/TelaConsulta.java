package br.edu.fatec.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.dao.ClienteDAO;
import br.edu.fatec.dao.FilmeDAO;
import br.edu.fatec.util.ConsultaTableModelCliente;
import br.edu.fatec.util.ConsultaTableModelFilme;
import br.edu.fatec.util.SetaTamanhoTela;

import javax.swing.ScrollPaneConstants;

import org.omg.CORBA.Object;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaConsulta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelTable;
	private JTextField textFieldPesquisa;
	private JTable table;
	private JScrollPane scrollpane;
	private JComboBox<?> comboBoxEscolhaPesquisa;
	private int row;
	private JButton btnAlterar;
	private JLabel labelMensagemPesquisa;
	private JComboBox comboBox;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
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
	public TelaConsulta() {

		SetaTamanhoTela tela = new SetaTamanhoTela(this);
		int x = tela.WIDTH();
		int y = tela.HEIGHT();

		// desabilita o bot�o para n�o ser clicaco
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setForeground(Color.WHITE);
		lblPesquisa.setBounds(23, 26, 79, 14);
		contentPane.add(lblPesquisa);

		textFieldPesquisa = new JTextField();
		textFieldPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textFieldPesquisa.setText("");
				textFieldPesquisa.setForeground(Color.BLACK);
			}
		});
		textFieldPesquisa.setForeground(Color.LIGHT_GRAY);
		textFieldPesquisa.setText("C\u00F3digo Nome ou CPF");
		textFieldPesquisa.setToolTipText("");
		textFieldPesquisa.setBounds(104, 23, 623, 20);
		contentPane.add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);

		panelTable = new JPanel();
		panelTable.setBorder(BorderFactory
				.createTitledBorder("Lista de consulta"));
		panelTable.setBounds(10, 95, 1340, 573);

		JButton btnPequisar = new JButton("Pesquisar");
		btnPequisar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				consultarTable();

			}
		});
		btnPequisar.setBounds(760, 22, 114, 23);
		contentPane.add(btnPequisar);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				table.getModel();
				int col = table.getSelectedColumn();
				row = table.getSelectedRow();
				String txt = table.getValueAt(row, col).toString();
				System.out.println("Valorteste = " + txt);
			}
		});
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.WHITE);

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(30, 119, 1300, 515);
		contentPane.add(scrollpane);

		JScrollPane scrollPane = new JScrollPane();
		scrollpane.setColumnHeaderView(scrollPane);
		contentPane.add(panelTable);

		comboBoxEscolhaPesquisa = new JComboBox();
		comboBoxEscolhaPesquisa.setModel(new DefaultComboBoxModel(new String[] {
				"Cliente", "Filme" }));
		comboBoxEscolhaPesquisa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textFieldPesquisa.setForeground(Color.LIGHT_GRAY);

				if (comboBoxEscolhaPesquisa.getSelectedIndex() == 0) {
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
					textFieldPesquisa.setText("C�digo Nome ou CPF");
					btnCadastrar.setText("Cadastrar Cliente");
				} else {
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "A\u00E7\u00E3o", "Anima\u00E7\u00E3o", "Aventura", "Com\u00E9dia", "Com\u00E9dia rom\u00E2ntica", "Com\u00E9dia dram\u00E1tica", "Com\u00E9dia de a\u00E7\u00E3o", "Dan\u00E7a", "Document\u00E1rios ", "Drama", "Espionagem", "Fantasia", "Faroeste ", "Fic\u00E7\u00E3o cient\u00EDfica", "Franchise/S\u00E9ries", "Guerra", "Musical", "Filme noir", "Policial", "Pornogr\u00E1fico", "Romance", "Suspense", "Terror "}));
					textFieldPesquisa.setText("C�digo ou T�tulo");
					btnCadastrar.setText("Cadastrar Filme");
				}
			}
		});
		comboBoxEscolhaPesquisa.setBounds(760, 67, 114, 20);
		contentPane.add(comboBoxEscolhaPesquisa);

		JLabel lblPesquisarPor = new JLabel("Pesquisar por: ");
		lblPesquisarPor.setForeground(Color.WHITE);
		lblPesquisarPor.setBounds(625, 70, 102, 14);
		contentPane.add(lblPesquisarPor);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// new MainLayout().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(TelaConsulta.class
				.getResource("/br/edu/fatec/icons/arrow_left.png")));
		button.setBounds(53, 714, 49, 23);
		contentPane.add(button);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				alterarTable();
			}
		});
		btnAlterar.setIcon(new ImageIcon(TelaConsulta.class
				.getResource("/br/edu/fatec/icons/pencil.png")));
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(603, 714, 114, 23);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				excluirRowTable();
			}
		});
		btnExcluir.setIcon(new ImageIcon(TelaConsulta.class
				.getResource("/br/edu/fatec/icons/delete.png")));
		btnExcluir.setBounds(760, 714, 124, 23);
		contentPane.add(btnExcluir);
		
		labelMensagemPesquisa = new JLabel("");
		labelMensagemPesquisa.setBounds(129, 714, 226, 23);
		contentPane.add(labelMensagemPesquisa);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		comboBox.setBounds(922, 67, 124, 20);
		contentPane.add(comboBox);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(922, 26, 46, 14);
		contentPane.add(lblFiltro);
		
		btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setSelectedIcon(new ImageIcon(TelaConsulta.class.getResource("/br/edu/fatec/icons/add.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxEscolhaPesquisa.getSelectedIndex() == 0) {
					try {
						new TelaCadastroCliente().setVisible(true);;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else {
					new TelaCadastroFilme().setVisible(true);
				}
			}
		});
		
		btnCadastrar.setBounds(1190, 714, 160, 23);
		contentPane.add(btnCadastrar);
	}
	
	/**
	 *  M�todo para fazer a consulta na tabela
	 */
	private void consultarTable(){
		labelMensagemPesquisa.setText("");
		if (comboBoxEscolhaPesquisa.getSelectedIndex() == 0) {

			try {
				List<Cliente> clientes = new ArrayList<Cliente>();
				Cliente cliente = new Cliente();
				cliente.setCpf(textFieldPesquisa.getText());
				cliente.setNomeCliente(textFieldPesquisa.getText());
				cliente.setNumCarterinha(textFieldPesquisa.getText());
				cliente.setUf(comboBox.getSelectedItem().toString());
				ClienteDAO dao = new ClienteDAO();

				clientes = dao.consultar(cliente);

				table.setModel(new ConsultaTableModelCliente(clientes));

//				JOptionPane.showMessageDialog(null,
//						"Consulta com sucesso");
				
				verificaLista(clientes);
				btnAlterar.setEnabled(true);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Consulta inv�lida. Digite novamente");

			}
		} else {
			try {

				List<Filme> filmes = new ArrayList<Filme>();
				Filme filme = new Filme();
				filme.setCodCliente(textFieldPesquisa.getText());
				filme.setTitulo(textFieldPesquisa.getText());
				filme.setGenero(comboBox.getSelectedItem().toString());
				FilmeDAO dao = new FilmeDAO();

				filmes = dao.consultar(filme);

				// apresentar os dados

				table.setModel(new ConsultaTableModelFilme(filmes));

				// JOptionPane.showMessageDialog(null,
				// "Consulta com sucesso");
				verificaLista(filmes);
				btnAlterar.setEnabled(true);
			} catch (Exception ex) {
				labelMensagemPesquisa.setText("");
				JOptionPane.showMessageDialog(null,
						"Consulta inv�lida. Digite novamente");
			}
		}
	}
	
	/**
	 * M�todo para alterar um valor selecionado na tabel
	 */
	private void alterarTable(){
		table.getModel();
		System.out.println("Valor = "
				+ table.getValueAt(0, 1).toString());
		if (comboBoxEscolhaPesquisa.getSelectedIndex() == 0) {
			try {

				Cliente cliente = new Cliente();
				// table.getModel();

				System.out.println("Valor = "
						+ table.getValueAt(0, 1).toString());

				// cliente.setNomeCliente(table.getValueAt(0,
				// 1).toString());
				cliente.setNumCarterinha(table.getValueAt(row, 0)
						.toString());
				cliente.setNomeCliente(table.getValueAt(row, 1)
						.toString());
				cliente.setDataNasci(table.getValueAt(row, 2)
						.toString());
				cliente.setSexo(table.getValueAt(row, 3).toString());
				cliente.setRg(table.getValueAt(row, 4).toString());
				cliente.setCpf(table.getValueAt(row, 5).toString());
				cliente.setEndereco(table.getValueAt(row, 6).toString());
				cliente.setNumCasa(table.getValueAt(row, 7).toString());
				cliente.setComplemento(table.getValueAt(row, 8)
						.toString());
				cliente.setBairro(table.getValueAt(row, 9).toString());
				cliente.setCidade(table.getValueAt(row, 10).toString());
				cliente.setUf(table.getValueAt(row, 11).toString());
				cliente.setTelRes(table.getValueAt(row, 12).toString());
				cliente.setTelCel(table.getValueAt(row, 13).toString());
				cliente.setEmail(table.getValueAt(row, 14).toString());

				ClienteDAO dao = new ClienteDAO();
				dao.alterar(cliente);
				JOptionPane.showMessageDialog(null,
						"Alterado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane
						.showMessageDialog(null,
								"N�o foi poss�vel fazer a altera��o, tente mais tarde!");

			}
		} else {
			try {

				Filme filme = new Filme();
				filme.setCodCliente(table.getValueAt(row, 0).toString());
				filme.setTitulo(table.getValueAt(row, 1).toString());
				filme.setDiretor(table.getValueAt(row, 2).toString());
				filme.setAno(table.getValueAt(row, 3).toString());
				filme.setGenero(table.getValueAt(row, 4).toString());

				System.out.println("ValorLast = "
						+ table.getValueAt(0, 1).toString());
				FilmeDAO dao = new FilmeDAO();
				dao.alterar(filme);

				JOptionPane.showMessageDialog(null,
						"Alterado com sucesso!");
			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null,
								"N�o foi poss�vel fazer a altera��o, tente mais tarde!");
			}

		}
	}
	
	/**
	 * M�todo para excluir a linha selecionada da tabela
	 */
	private void excluirRowTable(){
		if (comboBoxEscolhaPesquisa.getSelectedIndex() == 0) {
			try {
				Cliente cliente = new Cliente();
				cliente.setNumCarterinha(table.getValueAt(row, 0).toString());
				ClienteDAO dao = new ClienteDAO();

				dao.excluir(cliente);

				
				//JOptionPane.showMessageDialog(null,"Excluido com sucesso");
				
				
			} catch (Exception ex) {
				JOptionPane
						.showMessageDialog(null,
								"N�o foi poss�vel fazer a exclus�o, tente mais tarde!");
			} finally {
				consultarTable();
			}

		} else {
			try {
				Filme filme = new Filme();
				filme.setCodCliente(table.getValueAt(row, 0).toString());
				FilmeDAO dao = new FilmeDAO();

				dao.excluir(filme);

				//JOptionPane.showMessageDialog(null, "Excluido com sucesso");
				
			} catch (Exception ex) {
				JOptionPane
						.showMessageDialog(null,
								"N�o foi poss�vel fazer a exclus�o, tente mais tarde!");
			} finally {
				consultarTable();
			}

		}
	}
	
	private void verificaLista(List<?> list){
		if(list.isEmpty()){
			labelMensagemPesquisa.setForeground(Color.RED);
			labelMensagemPesquisa.setText("Valor(es) n�o encontrado");
		} else {
			labelMensagemPesquisa.setForeground(Color.green);
			if(list.size() > 1) {
				labelMensagemPesquisa.setText(String.format("%s valores encontrado", list.size()));
			} else {				
				labelMensagemPesquisa.setText("Consulta com sucesso");
			}
		}
	}
}
