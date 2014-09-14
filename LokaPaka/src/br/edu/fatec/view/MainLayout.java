package br.edu.fatec.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JProgressBar;

public class MainLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLayout frame = new MainLayout();
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
	public MainLayout() {
		setTitle("Lokapaka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 461);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setIcon(new ImageIcon(MainLayout.class.getResource("/br/edu/fatec/icons/add.png")));
		menuBar.add(mnCadastro);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCadastro.add(mnCliente);
		
		JMenuItem mntmMaiorDe = new JMenuItem("Maior de 18");
		mntmMaiorDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new TelaCadastroCliente().setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		mnCliente.add(mntmMaiorDe);
		
		JMenuItem mntmMenorDe = new JMenuItem("Menor de 18");
		mntmMenorDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new TelaCadastroCliente().setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		mnCliente.add(mntmMenorDe);
		
		JMenuItem mntmFilme = new JMenuItem("Filme");
		mntmFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFilme().setVisible(true);
				
			}
		});
		mnCadastro.add(mntmFilme);
		
		JMenu mnNewMenu = new JMenu("Consultas");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					dispose();
					new TelaConsulta().setVisible(true);			
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("Relat\u00F3rio");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("logoff");
	
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new TelaLogin().setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lokapaka");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/br/edu/fatec/icons/lokapaka.ico"));
		lblNewLabel.setBounds(0, 0, 0, 0);
		contentPane.add(lblNewLabel);
		
		JLabel lblWwwvideo = new JLabel("www.lokapaka.com.br");
		lblWwwvideo.setForeground(Color.BLUE);
		lblWwwvideo.setBounds(546, 371, 133, 14);
		contentPane.add(lblWwwvideo);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/beautiful.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 725, 412);
		contentPane.add(lblNewLabel_1);
		
		
		
			
		
		setResizable(false);
	}
}
