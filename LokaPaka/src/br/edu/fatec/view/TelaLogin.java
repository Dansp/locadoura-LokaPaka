package br.edu.fatec.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.edu.fatec.bean.Funcionario;
import br.edu.fatec.bean.Gerente;
import br.edu.fatec.dao.FuncionarioDAO;
import br.edu.fatec.util.LimpaCampos;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 189);
		contentPane = new JPanel();
		contentPane.setToolTipText("Insira sua senha");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmailOuUsurio = new JLabel("Email ou Usu\u00E1rio:");
		lblEmailOuUsurio.setBounds(10, 47, 111, 14);
		contentPane.add(lblEmailOuUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 71, 46, 14);
		contentPane.add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setToolTipText("Insira o seu email ou usu\u00E1rio");
		txtLogin.setBounds(118, 44, 123, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 72, 123, 20);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, 370, 36);
		contentPane.add(panel);
		
		JLabel lblBemVindoAo = new JLabel("BEM VINDO AO SISTEMA LOKAPAKA");
		lblBemVindoAo.setForeground(Color.WHITE);
		lblBemVindoAo.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblBemVindoAo);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/edu/fatec/icons/accept.png")));
		
		
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Funcionario funcionario = new Funcionario();
					funcionario.setUserName(txtLogin.getText());
					funcionario.setEmail(txtLogin.getText());
					funcionario.setPassworld(passwordField.getText());
					FuncionarioDAO dao = new FuncionarioDAO();
					Gerente gerente = new Gerente();
					
					gerente = (Gerente) dao.consultar(funcionario);
						
					
					MainLayout main = new MainLayout();
					main.setTipoFunc(gerente.getTipo());
					main.setVisible(true);
					dispose();
					

					JOptionPane.showMessageDialog(null, "Login Efetuado com sucesso!!!");
				} catch (Exception ex) {
//					// limpa os campos
//					for (int i = 0; i < getContentPane().getComponentCount(); i++) {
//						// varre todos os componentes
//
//						Component c = getContentPane().getComponent(i);
//
//						if (c instanceof JTextField) {
//							// apaga os valores
//							JTextField field = (JTextField) c;
//							field.setText("");
//						}
//					}
					
					new LimpaCampos(TelaLogin.this);
				
					JOptionPane.showMessageDialog(null, "Login inválida. Digite novamente");

				}
			}

			
		});
		btnEntrar.setBounds(148, 117, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/edu/fatec/icons/door_out.png")));
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
				dispose();
			}
		});
		btnSair.setBounds(10, 117, 89, 23);
		contentPane.add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(247, 37, 123, 55);
		contentPane.add(panel_1);
		
		JLabel lblNovoAqui = new JLabel("Novo aqui?");
		panel_1.add(lblNovoAqui);
		
		final JPanel panel_criarLogin = new JPanel();
		panel_criarLogin.setBorder(UIManager.getBorder("CheckBox.border"));
		
		panel_criarLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaCadastroFuncionario().setVisible(true);
				dispose();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				panel_criarLogin.setBackground(Color.green);
			}
		});
		panel_criarLogin.setBackground(Color.RED);
		panel_criarLogin.setBounds(247, 92, 123, 59);
		contentPane.add(panel_criarLogin);
		panel_criarLogin.setLayout(null);
		
		JLabel lblCriarLogin = new JLabel("Criar Login");
		lblCriarLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCriarLogin.setBounds(0, 23, 123, 14);
		lblCriarLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriarLogin.setForeground(Color.WHITE);
		panel_criarLogin.add(lblCriarLogin);
	}

	
}
