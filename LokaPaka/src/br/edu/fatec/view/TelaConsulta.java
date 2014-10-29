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

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.dao.ClienteDAO;
import br.edu.fatec.dao.FilmeDAO;
import br.edu.fatec.util.ConsultaTableModelCliente;
import br.edu.fatec.util.ConsultaTableModelFilme;
import br.edu.fatec.util.SetaTamanhoTela;
import javax.swing.ScrollPaneConstants;

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
	private JLabel labelMensagemPesquisa;
	
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
		
		//desabilita o botão para não ser clicaco
		//setResizable(false);
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
		panelTable.setBorder(BorderFactory.createTitledBorder("Lista de consulta"));
		panelTable.setBounds(10, 95, 1340, 573);
		
		JButton btnPequisar = new JButton("Pesquisar");
		btnPequisar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				if (comboBoxEscolhaPesquisa.getSelectedIndex() == 0){
					
					try {
						List<Cliente> clientes = new ArrayList<Cliente>();
						Cliente cliente = new Cliente();
						cliente.setCpf(textFieldPesquisa.getText());
						cliente.setNomeCliente(textFieldPesquisa.getText());
						cliente.setNumCarterinha(textFieldPesquisa.getText());
						ClienteDAO dao = new ClienteDAO();
						
						clientes = dao.consultar(cliente);
						
						table.setModel(new ConsultaTableModelCliente(clientes));
						
						JOptionPane.showMessageDialog(null, "Consulta com sucesso");
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Consulta inválida. Digite novamente");
					
					}
				} else {
				try {
					
					List<Filme> filmes = new ArrayList<Filme>();
					Filme filme = new Filme();
					filme.setCodCliente(textFieldPesquisa.getText());
					filme.setTitulo(textFieldPesquisa.getText());
					FilmeDAO dao = new FilmeDAO();

					filmes = dao.consultar(filme);

					// apresentar os dados
					
					
					table.setModel(new ConsultaTableModelFilme(filmes));
					

					//JOptionPane.showMessageDialog(null, "Consulta com sucesso");
					labelMensagemPesquisa.setText("Consulta com sucesso");
				} catch (Exception ex) {
					labelMensagemPesquisa.setText("");
					JOptionPane.showMessageDialog(null, "Consulta inválida. Digite novamente");
				}
			}
			
			}
		});
		btnPequisar.setBounds(760, 22, 114, 23);
		contentPane.add(btnPequisar);
		
		table = new JTable();
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
		comboBoxEscolhaPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Filme"}));
		comboBoxEscolhaPesquisa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textFieldPesquisa.setForeground(Color.LIGHT_GRAY);
				
				if(comboBoxEscolhaPesquisa.getSelectedIndex() == 0){
					
					textFieldPesquisa.setText("Código Nome ou CPF");
				} else {
			
					textFieldPesquisa.setText("Código ou Título");
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
				//new MainLayout().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(TelaConsulta.class.getResource("/br/edu/fatec/icons/arrow_left.png")));
		button.setBounds(53, 714, 49, 23);
		contentPane.add(button);
		
		labelMensagemPesquisa = new JLabel("");
		labelMensagemPesquisa.setForeground(Color.GREEN);
		labelMensagemPesquisa.setBounds(84, 446, 241, 14);
		contentPane.add(labelMensagemPesquisa);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.getModel();
				System.out.println("Valor = " + table.getValueAt(0, 1).toString());
				try {

					Cliente cliente = new Cliente();
					//table.getModel();
					
					System.out.println("Valor = " + table.getValueAt(0, 1).toString());
					
					//cliente.setNomeCliente(table.getValueAt(0, 1).toString());
					cliente.setNumCarterinha(table.getValueAt(0, 0).toString());
					cliente.setNomeCliente(table.getValueAt(0, 1).toString());
					cliente.setDataNasci(table.getValueAt(0, 2).toString());
					cliente.setSexo(table.getValueAt(0, 3).toString());
					cliente.setRg(table.getValueAt(0, 4).toString());
					cliente.setCpf(table.getValueAt(0, 5).toString());
					cliente.setEndereco(table.getValueAt(0, 6).toString());
					cliente.setNumCasa(table.getValueAt(0, 7).toString());
					cliente.setComplemento(table.getValueAt(0, 8).toString());
					cliente.setBairro(table.getValueAt(0, 9).toString());
					cliente.setCidade(table.getValueAt(0, 10).toString());
					cliente.setUf(table.getValueAt(0, 11).toString());
					cliente.setTelRes(table.getValueAt(0, 12).toString());
					cliente.setTelCel(table.getValueAt(0, 13).toString());
					cliente.setEmail(table.getValueAt(0, 14).toString());

					ClienteDAO dao = new ClienteDAO();
					dao.alterar(cliente);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível fazer a alteração, tente mais tarde!");

				}
			}
		});
		btnAlterar.setIcon(new ImageIcon(TelaConsulta.class.getResource("/br/edu/fatec/icons/pencil.png")));
		btnAlterar.setBounds(613, 697, 114, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaConsulta.class.getResource("/br/edu/fatec/icons/delete.png")));
		btnExcluir.setBounds(760, 697, 124, 23);
		contentPane.add(btnExcluir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, x, 94);
		contentPane.add(panel);
	}
}
