package br.edu.fatec.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.dao.FilmeDAO;
import br.edu.fatec.util.LimpaCampos;

public class TelaCadastroFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAno;
	private JTextField txtTitulo;
	private JTextField txtDiretor;
	private JTextField txtGeradoAutomticamente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFilme frame = new TelaCadastroFilme();
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
	public TelaCadastroFilme() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, 434, 41);
		contentPane.add(panel);
		
		JLabel lblCadastroDeFilme = new JLabel("CADASTRO DE FILME");
		lblCadastroDeFilme.setForeground(Color.WHITE);
		lblCadastroDeFilme.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblCadastroDeFilme);
		
		JLabel lblNome = new JLabel("T\u00EDtulo:");
		lblNome.setBounds(35, 100, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setBounds(35, 125, 46, 14);
		contentPane.add(lblDiretor);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(35, 156, 46, 14);
		contentPane.add(lblAno);
		
		final JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"A\u00E7\u00E3o", "Anima\u00E7\u00E3o", "Aventura", "Com\u00E9dia", "Com\u00E9dia rom\u00E2ntica", "Com\u00E9dia dram\u00E1tica", "Com\u00E9dia de a\u00E7\u00E3o", "Dan\u00E7a", "Document\u00E1rios ", "Drama", "Espionagem", "Fantasia", "Faroeste ", "Fic\u00E7\u00E3o cient\u00EDfica", "Franchise/S\u00E9ries", "Guerra", "Musical", "Filme noir", "Policial", "Pornogr\u00E1fico", "Romance", "Suspense", "Terror "}));
		comboBoxGenero.setBounds(264, 153, 138, 20);
		contentPane.add(comboBoxGenero);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setBounds(195, 156, 46, 14);
		contentPane.add(lblGenero);
		
		txtAno = new JTextField();
		txtAno.setBounds(84, 153, 86, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(84, 97, 318, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtDiretor = new JTextField();
		txtDiretor.setBounds(84, 122, 318, 20);
		contentPane.add(txtDiretor);
		txtDiretor.setColumns(10);

		final JLabel label = new JLabel("");
		label.setBounds(84, 237, 318, 14);
		contentPane.add(label);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(TelaCadastroFilme.class.getResource("/br/edu/fatec/icons/add.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Filme filme = new Filme();
					
					filme.setTitulo(txtTitulo.getText());
					filme.setDiretor(txtDiretor.getText());
					filme.setAno(txtAno.getText());
					filme.setGenero(comboBoxGenero.getSelectedItem().toString());
					filme.setReservado("N");
					
					FilmeDAO dao = new FilmeDAO();
					dao.salvar(filme);
					txtGeradoAutomticamente.setText(filme.getCodFilme());
					System.out.println(filme.getCodFilme());
					label.setText("Gravado com sucesso!!!");
									
				}catch(Exception e){
					new LimpaCampos(TelaCadastroFilme.this);
					label.setText("Erro ao gravar Dados, tente novamente");
				} 	
			}
		});
		btnSalvar.setBounds(292, 203, 110, 23);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaCadastroFilme.class.getResource("/br/edu/fatec/icons/arrow_left.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				//new MainLayout().setVisible(true);
			}
		});
		btnVoltar.setBounds(81, 203, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblCdigoDoFilme = new JLabel("C\u00F3digo do Filme:");
		lblCdigoDoFilme.setBounds(35, 61, 117, 14);
		contentPane.add(lblCdigoDoFilme);
		
		txtGeradoAutomticamente = new JTextField();
		txtGeradoAutomticamente.setText("Gerado autom\u00E1ticamente");
		txtGeradoAutomticamente.setEditable(false);
		txtGeradoAutomticamente.setBounds(141, 58, 156, 20);
		contentPane.add(txtGeradoAutomticamente);
		txtGeradoAutomticamente.setColumns(10);
		
		JButton btnAlterar = new JButton("Limpar");
		btnAlterar.setSelectedIcon(new ImageIcon(TelaCadastroFilme.class.getResource("/br/edu/fatec/icons/textfield_delete.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LimpaCampos(TelaCadastroFilme.this);
			}
		});
		btnAlterar.setBounds(313, 52, 89, 34);
		contentPane.add(btnAlterar);
		
	}
}
