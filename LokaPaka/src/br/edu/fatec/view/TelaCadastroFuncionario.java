package br.edu.fatec.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ToolTipUI;
import javax.swing.plaf.metal.MetalBorders;

import br.edu.fatec.bean.Funcionario;
import br.edu.fatec.bean.Gerente;
import br.edu.fatec.dao.FuncionarioDAO;
import br.edu.fatec.util.Cryptography;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtEmail;
	private JPasswordField passwordField01Func;
	private JPasswordField passwordField02Func;
	private JComboBox<?> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(21, 100, 140, 14);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Nome de Usu\u00E1rio");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(21, 62, 140, 14);
		contentPane.add(lblUsername);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(21, 136, 140, 14);
		contentPane.add(lblSenha);
		
		JLabel lblRepetirSenha = new JLabel("Repetir Senha:");
		lblRepetirSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRepetirSenha.setBounds(21, 161, 140, 14);
		contentPane.add(lblRepetirSenha);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(171, 61, 217, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(172, 97, 217, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/br/edu/fatec/icons/add.png")));
		btnCadastrar.setToolTipText("clique aqui");

		btnCadastrar.addActionListener(new ActionListener() {
						
			public void actionPerformed(ActionEvent e) {
				try{
					Funcionario funcionario = new Funcionario(txtUserName.getText(), passwordField01Func.getText(), txtEmail.getText());
					
					//get the text in the box 
					//funcionario.setUserName(txtUserName.getText());
						
			
					FuncionarioDAO dao = new FuncionarioDAO();
					if(comboBox.getSelectedIndex() == 0){
						//salve in DB Mysql
						dao.salvar(funcionario, Gerente.COD_FUNCIONARIO);
					} else {
						dao.salvar(funcionario, Gerente.COD_GERENTE);
					}
					JOptionPane.showMessageDialog(null, "Gravado com sucesso");
					dispose();
					new TelaLogin().setVisible(true);
					
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar, tente denovo!");
				}
			}
		});
		btnCadastrar.setBounds(271, 213, 117, 23);
		contentPane.add(btnCadastrar);
		
		passwordField01Func = new JPasswordField();
		passwordField01Func.setBounds(171, 133, 217, 20);
		contentPane.add(passwordField01Func);
		
		passwordField02Func = new JPasswordField();
		passwordField02Func.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (!passwordField01Func.getText().equals(passwordField02Func.getText())){
					
					//For left the border red
					passwordField01Func.setBorder(BorderFactory.createLineBorder(Color.red));
					passwordField02Func.setBorder(BorderFactory.createLineBorder(Color.red));
					btnCadastrar.setEnabled(false);
					
				} else {
					//For came back to original border
					passwordField01Func.setBorder(MetalBorders.getTextFieldBorder()); 
					passwordField02Func.setBorder(MetalBorders.getTextFieldBorder());
					btnCadastrar.setEnabled(true);
				}
			}
		});
		passwordField02Func.setBounds(171, 160, 217, 20);
		contentPane.add(passwordField02Func);
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, 421, 38);
		contentPane.add(panel);
		
		JLabel lblNovoCadastro = new JLabel("NOVO CADASTRO");
		lblNovoCadastro.setForeground(Color.WHITE);
		panel.add(lblNovoCadastro);
		lblNovoCadastro.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/br/edu/fatec/icons/arrow_left.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaLogin().setVisible(true);
			}
		});
		btnVoltar.setBounds(171, 213, 89, 23);
		contentPane.add(btnVoltar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Funcion\u00E1rio", "Gerente"}));
		comboBox.setBounds(21, 214, 96, 20);
		contentPane.add(comboBox);
	}
}
