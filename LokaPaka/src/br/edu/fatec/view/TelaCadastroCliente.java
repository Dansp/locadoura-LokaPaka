package br.edu.fatec.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.dao.ClienteDAO;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class TelaCadastroCliente extends JFrame {

	private JLayeredPane contentPane;
	private JTextField txtCarterinha;
	private JTextField txtNome;
	private JTextField txtNascimento;
	private JTextField txtRG;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtNumCasa;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtResidencia;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JComboBox comboBoxSexo;
	private JComboBox comboBoxUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCadastroCliente() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/lokapaka.ico")));
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(200, 200, 662, 522);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNmeroDaCarterinha = new JLabel("N\u00FAmero da carterinha:");
		lblNmeroDaCarterinha.setBounds(99, 45, 141, 15);
		contentPane.add(lblNmeroDaCarterinha);

		txtCarterinha = new JTextField();
		txtCarterinha.setText("Gerado autom\u00E1ticamente");
		txtCarterinha.setEditable(false);
		txtCarterinha.setBounds(234, 42, 193, 19);
		contentPane.add(txtCarterinha);
		txtCarterinha.setColumns(10);

		JLabel lblNome = new JLabel("* Nome: ");
		lblNome.setBounds(99, 85, 46, 15);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(155, 82, 411, 19);
		txtNome.setColumns(10);
		contentPane.add(txtNome);

		JLabel lblDataDeNascimento = new JLabel("* Data de Nascimento: ");
		lblDataDeNascimento.setBounds(99, 125, 128, 15);
		contentPane.add(lblDataDeNascimento);

		txtNascimento = new JTextField();
		txtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtNascimento.setBounds(234, 122, 169, 19);
		txtNascimento.setColumns(10);
		contentPane.add(txtNascimento);

		JLabel lblSexo = new JLabel("* Sexo: ");
		lblSexo.setBounds(475, 125, 48, 15);
		contentPane.add(lblSexo);

		comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(522, 120, 44, 24);
		comboBoxSexo.setModel(new DefaultComboBoxModel(
				new String[] { "M", "F" }));
		contentPane.add(comboBoxSexo);

		JLabel lblRg = new JLabel("* RG: ");
		lblRg.setBounds(99, 165, 34, 15);
		contentPane.add(lblRg);

		txtRG = new JTextField();
		txtRG = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
		txtRG.setBounds(143, 162, 150, 19);
		contentPane.add(txtRG);
		txtRG.setColumns(10);

		JLabel lblCpf = new JLabel("* CPF: ");
		lblCpf.setBounds(303, 165, 44, 15);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setBounds(345, 162, 150, 19);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		JLabel lblEndereo = new JLabel("* Endere\u00E7o:");
		lblEndereo.setBounds(99, 213, 70, 15);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(178, 210, 224, 19);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblN = new JLabel("* N\u00BA:");
		lblN.setBounds(412, 213, 40, 15);
		contentPane.add(lblN);

		txtNumCasa = new JTextField();
		txtNumCasa.setBounds(452, 210, 114, 19);
		contentPane.add(txtNumCasa);
		txtNumCasa.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(99, 255, 100, 15);
		contentPane.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(190, 252, 212, 19);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblBairro = new JLabel("* Bairro: ");
		lblBairro.setBounds(406, 255, 46, 15);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(452, 252, 114, 19);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("* Cidade: ");
		lblCidade.setBounds(99, 285, 70, 15);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(160, 281, 242, 19);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblUf = new JLabel("* UF: ");
		lblUf.setBounds(475, 285, 48, 15);
		contentPane.add(lblUf);

		comboBoxUF = new JComboBox();
		comboBoxUF.setBounds(522, 280, 44, 24);
		comboBoxUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		contentPane.add(comboBoxUF);

		JLabel lblTelefone = new JLabel("Telefone Res: ");
		lblTelefone.setBounds(99, 335, 92, 15);
		contentPane.add(lblTelefone);

		txtResidencia = new JTextField();
		txtResidencia.setBounds(178, 332, 128, 19);
		contentPane.add(txtResidencia);
		txtResidencia.setColumns(10);

		JLabel lblCelular = new JLabel("Telefone Cel: ");
		lblCelular.setBounds(363, 335, 79, 15);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setBounds(445, 332, 121, 19);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);

		JLabel lblEmail = new JLabel("* E-mail: ");
		lblEmail.setBounds(99, 375, 54, 15);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(159, 372, 407, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/add.png")));
		
		btnCadastrar.setToolTipText("Cadastrar Cliente");
		btnCadastrar.setBounds(519, 425, 117, 24);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// procurar por uma classe no projeto
				try {
					Cliente cliente = new Cliente();

					cliente.setNomeCliente(txtNome.getText());
					cliente.setDataNasci(txtNascimento.getText());
					cliente.setSexo(comboBoxSexo.getSelectedItem().toString());
					cliente.setRg(txtRG.getText());
					cliente.setCpf(txtCPF.getText());
					cliente.setEndereco(txtEndereco.getText());
					cliente.setNumCasa(txtNumCasa.getText());
					cliente.setComplemento(txtComplemento.getText());
					cliente.setBairro(txtBairro.getText());
					cliente.setCidade(txtCidade.getText());
					cliente.setUf(comboBoxUF.getSelectedItem().toString());
					cliente.setTelRes(txtResidencia.getText());
					cliente.setTelCel(txtCelular.getText());
					cliente.setEmail(txtEmail.getText());

					ClienteDAO dao = new ClienteDAO();

					dao.salvar(cliente);
					txtCarterinha.setText(cliente.getNumCarterinha());
					JOptionPane.showMessageDialog(null, "Gravado com sucesso");

					// limpa os campos
					for (int i = 0; i < getContentPane().getComponentCount(); i++) {
						// varre todos os componentes

						Component c = getContentPane().getComponent(i);

						if (c instanceof JTextField) {
							// apaga os valores
							JTextField field = (JTextField) c;
							field.setText("");
						}
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Sistema indisponível");

				}

			}
		});
		contentPane.add(btnCadastrar);

		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setToolTipText("Consultar cliente SOMENTE pelo CPF ");
		btnConsultar.setBounds(392, 425, 117, 25);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Cliente cliente = new Cliente();
					cliente.setCpf(txtCPF.getText());
					ClienteDAO dao = new ClienteDAO();

					cliente = dao.consultar(cliente);

					// apresentar os dados

					txtCarterinha.setText(cliente.getNumCarterinha());
					txtNome.setText(cliente.getNomeCliente());
					txtNascimento.setText(cliente.getDataNasci());
					comboBoxSexo.setSelectedItem(cliente.getSexo());
					txtRG.setText(cliente.getRg());
					txtCPF.setText(cliente.getCpf());
					txtEndereco.setText(cliente.getEndereco());
					txtNumCasa.setText(cliente.getNumCasa());
					txtComplemento.setText(cliente.getComplemento());
					txtBairro.setText(cliente.getBairro());
					txtCidade.setText(cliente.getCidade());
					comboBoxUF.setSelectedItem(cliente.getUf());
					txtResidencia.setText(cliente.getTelRes());
					txtCelular.setText(cliente.getTelCel());
					txtEmail.setText(cliente.getEmail());

					JOptionPane.showMessageDialog(null, "Consulta com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Consulta inválida. Digite novamente");

				}
			}

		});
		contentPane.add(btnConsultar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/database_edit.png")));
		
		btnAlterar.setToolTipText("ALterar dados do cliente");
		btnAlterar.setBounds(265, 425, 117, 25);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Cliente cliente = new Cliente();

					cliente.setNumCarterinha(txtCarterinha.getText());
					cliente.setNomeCliente(txtNome.getText());
					cliente.setDataNasci(txtNascimento.getText());
					cliente.setSexo(comboBoxSexo.getSelectedItem().toString());
					cliente.setRg(txtRG.getText());
					cliente.setCpf(txtCPF.getText());
					cliente.setEndereco(txtEndereco.getText());
					cliente.setNumCasa(txtNumCasa.getText());
					cliente.setComplemento(txtComplemento.getText());
					cliente.setBairro(txtBairro.getText());
					cliente.setCidade(txtCidade.getText());
					cliente.setUf(comboBoxUF.getSelectedItem().toString());
					cliente.setTelRes(txtResidencia.getText());
					cliente.setTelCel(txtCelular.getText());
					cliente.setEmail(txtEmail.getText());

					ClienteDAO dao = new ClienteDAO();
					dao.alterar(cliente);
					JOptionPane
							.showMessageDialog(null, "Alterado com sucesso!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não foi possível fazer a alteração, tente mais tarde!");

				}
			}

		});
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/delete.png")));
		btnExcluir.setToolTipText("Excluir um cliente");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					cliente.setNumCarterinha(txtCarterinha.getText());
					ClienteDAO dao = new ClienteDAO();

					dao.excluir(cliente);

					JOptionPane.showMessageDialog(null, "Excluido com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Não foi possível fazer a exclusão, tente mais tarde!");
				}
				
				/* Para limpar todos os campos*/
				for (int i = 0; i < getContentPane().getComponentCount(); i++) {
					// varre todos os componentes
					Component c = getContentPane().getComponent(i);

					if (c instanceof JTextField) {
						// apaga os valores
						JTextField field = (JTextField) c;
						field.setText("");
					}
				}
			}

		});
		btnExcluir.setBounds(155, 426, 100, 23);
		contentPane.add(btnExcluir);

		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/cross.png")));
		btnSair.setToolTipText("Sair da Tela de Cadastro de cliente");
		
		btnSair.setBounds(16, 425, 117, 25);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new MainLayout().setVisible(true);
			}
		});
		contentPane.add(btnSair);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/textfield_delete.png")));
		btnLimpar.setToolTipText("Limpar todos os campos");
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// limpa os campos
				for (int i = 0; i < getContentPane().getComponentCount(); i++) {
					// varre todos os componentes

					Component c = getContentPane().getComponent(i);

					if (c instanceof JTextField) {
						// apaga os valores
						JTextField field = (JTextField) c;
						field.setText("");
					}
				}
			}

		});
		btnLimpar.setBounds(452, 41, 114, 23);
		contentPane.add(btnLimpar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 656, 37);
		contentPane.add(panel);
		
		JLabel lblCadastroDeClientes = new JLabel("CADASTRO DE CLIENTES");
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblCadastroDeClientes);
		
		setResizable(true);
	}
}
