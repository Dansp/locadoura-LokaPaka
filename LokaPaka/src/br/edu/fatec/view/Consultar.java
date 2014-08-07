package br.edu.fatec.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Consultar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCarterinha;
	private JLabel lblSelecioneAOpo;
	private JButton btnConsultar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar frame = new Consultar();
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
	public Consultar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dansp\\Dropbox\\3\u00BA Semestre\\Engenharia de Software II\\Trab1\\Capturar.PNG"));
		setTitle("Consultar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 221);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNmeroDaCarterinha = new JRadioButton("N\u00FAmero da Carterinha");
		rdbtnNmeroDaCarterinha.setBounds(41, 64, 192, 23);
		contentPane.add(rdbtnNmeroDaCarterinha);
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setBounds(250, 64, 70, 23);
		contentPane.add(rdbtnNome);
		
		txtNomeCarterinha = new JTextField();
		txtNomeCarterinha.setBounds(51, 95, 269, 19);
		contentPane.add(txtNomeCarterinha);
		txtNomeCarterinha.setColumns(10);
		
		lblSelecioneAOpo = new JLabel("Selecione a op\u00E7\u00E3o desejada:");
		lblSelecioneAOpo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSelecioneAOpo.setBounds(52, 25, 213, 32);
		contentPane.add(lblSelecioneAOpo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Dansp\\Dropbox\\3\u00BA Semestre\\Engenharia de Software II\\Trab1\\icons\\cancel.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(203, 147, 117, 25);
		contentPane.add(btnCancelar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//procurar por uma classe no projeto
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con;
					
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/lokapaka", "root", "12345678");
					
					JOptionPane.showMessageDialog(null, "Estou conectado");
					
					
					String query = "SELECT * from cliente";
					
					
					PreparedStatement stmt = con.prepareStatement(query);
					
					ResultSet rs = stmt.executeQuery();
					rs.next();
					txtNomeCarterinha.setText(rs.getString("nome"));
					//JOptionPane.showMessageDialog(null, "Salvo com sucesso");
					stmt.close();
					con.close();
				} catch(Exception e){}
				
			}
		});
		btnConsultar.setBounds(47, 147, 117, 25);
		contentPane.add(btnConsultar);
	}
}
