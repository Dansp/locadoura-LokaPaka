package br.edu.fatec.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;
import java.text.NumberFormat;
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
import javax.swing.text.AbstractDocument;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.dao.ClienteDAO;
import br.edu.fatec.util.NumericAndLengthFilter;

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
	private JComboBox comboBoxUF;
	private JLabel labelRealizarCadastro;

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
		setBounds(200, 200, 662, 425);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNmeroDaCarterinha = new JLabel("N\u00FAmero da carterinha:");
		lblNmeroDaCarterinha.setBounds(67, 45, 141, 15);
		contentPane.add(lblNmeroDaCarterinha);

		txtCarterinha = new JTextField();
		txtCarterinha.setText("Gerado autom\u00E1ticamente");
		txtCarterinha.setEditable(false);
		txtCarterinha.setBounds(234, 42, 193, 19);
		contentPane.add(txtCarterinha);
		txtCarterinha.setColumns(10);

		JLabel lblNome = new JLabel("* Nome: ");
		lblNome.setBounds(67, 85, 70, 15);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(204, 82, 398, 19);
		txtNome.setColumns(10);
		contentPane.add(txtNome);

		JLabel lblDataDeNascimento = new JLabel("* Data de Nascimento: ");
		lblDataDeNascimento.setBounds(67, 125, 128, 15);
		contentPane.add(lblDataDeNascimento);

		txtNascimento = new JTextField();
		txtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtNascimento.setBounds(204, 122, 70, 19);
		txtNascimento.setColumns(10);
		contentPane.add(txtNascimento);

		txtRG = new JTextField();

		JLabel lblCpf = new JLabel("* CPF: ");
		lblCpf.setBounds(282, 125, 44, 15);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCPF.setBounds(336, 122, 92, 19);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		JLabel lblEndereo = new JLabel("* Endere\u00E7o:");
		lblEndereo.setBounds(67, 168, 79, 15);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(155, 165, 224, 19);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblN = new JLabel("* N\u00BA:");
		lblN.setBounds(389, 168, 44, 15);
		contentPane.add(lblN);

		txtNumCasa = new JTextField();
		((AbstractDocument) txtNumCasa.getDocument()).setDocumentFilter(new NumericAndLengthFilter(5));
		//txtNumCasa = new JFormattedTextField(new NumberFormatter());
		txtNumCasa.setBounds(427, 165, 48, 19);
		contentPane.add(txtNumCasa);
		txtNumCasa.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento: ");
		lblComplemento.setBounds(67, 206, 100, 15);
		contentPane.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(155, 203, 223, 19);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblBairro = new JLabel("* Bairro: ");
		lblBairro.setBounds(389, 206, 59, 15);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(458, 203, 144, 19);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("* Cidade: ");
		lblCidade.setBounds(67, 237, 70, 15);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(155, 234, 224, 19);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblUf = new JLabel("* UF: ");
		lblUf.setBounds(487, 237, 48, 15);
		contentPane.add(lblUf);

		comboBoxUF = new JComboBox();
		comboBoxUF.setBounds(558, 233, 44, 24);
		comboBoxUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO"}));
		contentPane.add(comboBoxUF);

		JLabel lblTelefone = new JLabel("* Telefone Res: ");
		lblTelefone.setBounds(67, 272, 92, 15);
		contentPane.add(lblTelefone);

		txtResidencia = new JTextField();
		txtResidencia = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		txtResidencia.setBounds(155, 269, 128, 19);
		contentPane.add(txtResidencia);
		txtResidencia.setColumns(10);

		JLabel lblCelular = new JLabel("Telefone Cel: ");
		lblCelular.setBounds(374, 272, 79, 15);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular = new JFormattedTextField(new MaskFormatter("(##) ###-###-###"));
		txtCelular.setBounds(481, 269, 121, 19);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);

		JLabel lblEmail = new JLabel("* E-mail: ");
		lblEmail.setBounds(67, 298, 70, 15);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(155, 299, 224, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/add.png")));
		
		btnCadastrar.setToolTipText("Cadastrar Cliente");
		btnCadastrar.setBounds(485, 346, 117, 24);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// procurar por uma classe no projeto
				try {
					Cliente cliente = new Cliente();

					cliente.setNomeCliente(txtNome.getText());
					cliente.setDataNasci(txtNascimento.getText());
					cliente.setCpf(txtCPF.getText());
					cliente.setEndereco(txtEndereco.getText());
					cliente.setNumCasa(txtNumCasa.getText());
					cliente.setComplemento(txtComplemento.getText());
					cliente.setBairro(txtBairro.getText());
					cliente.setCidade(txtCidade.getText());
					cliente.setUf(comboBoxUF.getSelectedItem().toString());
					cliente.setTelRes(txtResidencia.getText());
					
					if(txtCelular.getText().equals("(  )    -   -   ")){
						cliente.setTelCel("");
					} else {
						cliente.setTelCel(txtCelular.getText());
					}
					cliente.setEmail(txtEmail.getText());

					
					ClienteDAO dao = new ClienteDAO();

					dao.salvar(cliente);
					txtCarterinha.setText(cliente.getNumCarterinha());
					System.out.println(cliente.getNumCarterinha());
					labelRealizarCadastro.setText("Cadastrado com sucesso!");
					labelRealizarCadastro.setForeground(Color.green);
				
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Não é possível fazer o cadastro, tente novamente");

				}

			}
		});
		contentPane.add(btnCadastrar);

		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/br/edu/fatec/icons/cross.png")));
		btnSair.setToolTipText("Sair da Tela de Cadastro de cliente");
		
		btnSair.setBounds(358, 346, 117, 25);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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
		btnLimpar.setBounds(488, 41, 114, 23);
		contentPane.add(btnLimpar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, 646, 37);
		contentPane.add(panel);
		
		JLabel lblCadastroDeClientes = new JLabel("CADASTRO DE CLIENTES");
		lblCadastroDeClientes.setForeground(Color.WHITE);
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblCadastroDeClientes);
		
		JLabel lblCamposMarcadosCom = new JLabel("Campos marcados com * s\u00E3o obrigat\u00F3rios.");
		lblCamposMarcadosCom.setBounds(398, 302, 248, 14);
		contentPane.add(lblCamposMarcadosCom);
		
		labelRealizarCadastro = new JLabel("");
		labelRealizarCadastro.setBounds(26, 351, 322, 14);
		contentPane.add(labelRealizarCadastro);
		
		setResizable(true);
	}
}
