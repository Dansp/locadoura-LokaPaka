package br.edu.fatec.view;

import java.awt.Color;
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
		txtLogin.setBounds(118, 44, 225, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 72, 225, 20);
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
					main.setTipoFunc(gerente);
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
		btnEntrar.setBounds(212, 117, 131, 23);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/edu/fatec/icons/door_out.png")));
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res =JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
				if(res == JOptionPane.YES_OPTION){
					dispose();
				}
			}
		});
		btnSair.setBounds(10, 117, 89, 23);
		contentPane.add(btnSair);
	}

	
}
