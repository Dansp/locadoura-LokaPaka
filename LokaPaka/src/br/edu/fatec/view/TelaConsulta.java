package br.edu.fatec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.JButton;

import br.edu.fatec.bean.Filme;
import br.edu.fatec.dao.FilmeDAO;
import br.edu.fatec.util.ConsultaTableModel;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class TelaConsulta extends JFrame {

	private JPanel contentPane, panelTable;
	private JTextField textFieldPesquisa;
	private JTable table;
	private JScrollPane scrollpane;

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
		setBounds(100, 100, 678, 412);
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
		panelTable.setBounds(84, 95, 490, 244);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
	
		scrollpane = new JScrollPane(table);
		panelTable.add(scrollpane);
		
		JButton btnPequisar = new JButton("Pesquisar");
		btnPequisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					List<Filme> filmes = new ArrayList<Filme>();
					Filme filme = new Filme();
					filme.setCodCliente(textFieldPesquisa.getText());
					filme.setTitulo(textFieldPesquisa.getText());
					FilmeDAO dao = new FilmeDAO();

					filmes = dao.consultar(filme);

					// apresentar os dados
					
					
					table.setModel(new ConsultaTableModel(filmes));
					

					JOptionPane.showMessageDialog(null, "Consulta com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Consulta inválida. Digite novamente");

				}
			
			}
		});
		btnPequisar.setBounds(460, 22, 114, 23);
		contentPane.add(btnPequisar);
		contentPane.add(panelTable);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Filme"}));
		comboBox.setBounds(460, 66, 114, 20);
		contentPane.add(comboBox);
		
		JLabel lblPesquisarPor = new JLabel("Pesquisar por: ");
		lblPesquisarPor.setBounds(348, 70, 102, 14);
		contentPane.add(lblPesquisarPor);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 662, 94);
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
