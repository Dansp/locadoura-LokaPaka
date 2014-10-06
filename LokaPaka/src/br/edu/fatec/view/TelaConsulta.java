package br.edu.fatec.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class TelaConsulta extends JFrame {

	private JPanel contentPane, panelTable;
	private JTextField textFieldPesquisa;
	private JTable table;
	private JScrollPane scrollpane;
	private JComboBox comboBoxEscolhaPesquisa;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		lblPesquisa.setBounds(23, 26, 79, 14);
		contentPane.add(lblPesquisa);
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(84, 23, 366, 20);
		contentPane.add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);
		
		panelTable = new JPanel();
		panelTable.setBorder(BorderFactory.createTitledBorder("Lista de consulta"));
		panelTable.setBounds(84, 95, 800, 365);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
	
		scrollpane = new JScrollPane(table);
		panelTable.add(scrollpane);
		
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
					

					JOptionPane.showMessageDialog(null, "Consulta com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Consulta inválida. Digite novamente");
				}
			}
			
			}
		});
		btnPequisar.setBounds(460, 22, 114, 23);
		contentPane.add(btnPequisar);
		contentPane.add(panelTable);
		
		comboBoxEscolhaPesquisa = new JComboBox();
		comboBoxEscolhaPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Filme"}));
		comboBoxEscolhaPesquisa.setBounds(460, 66, 114, 20);
		contentPane.add(comboBoxEscolhaPesquisa);
		
		JLabel lblPesquisarPor = new JLabel("Pesquisar por: ");
		lblPesquisarPor.setBounds(348, 70, 102, 14);
		contentPane.add(lblPesquisarPor);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 884, 94);
		contentPane.add(panel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainLayout().setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(TelaConsulta.class.getResource("/br/edu/fatec/icons/arrow_left.png")));
		button.setBounds(25, 316, 49, 23);
		contentPane.add(button);
	}
}
