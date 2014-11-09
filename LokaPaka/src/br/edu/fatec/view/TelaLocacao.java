package br.edu.fatec.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;

public class TelaLocacao extends TelaConsulta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodFilme;
	private JLabel lblDataDevolucao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLocacao frame = new TelaLocacao();
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
	public TelaLocacao() throws ParseException {
		
		setBounds(100, 100, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlugarFilme = new JLabel("ALUGAR FILME");
		lblAlugarFilme.setForeground(Color.WHITE);
		lblAlugarFilme.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlugarFilme.setBounds(568, 23, 209, 20);
		contentPane.add(lblAlugarFilme);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 162, 237));
		panel.setBounds(0, 0, 1366, 84);
		contentPane.add(panel);
		
		JLabel label = new JLabel("C\u00F3digo filme:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(843, 201, 110, 14);
		contentPane.add(label);
		
		textFieldCodFilme = new JTextField();
		textFieldCodFilme.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCodFilme.setColumns(10);
		textFieldCodFilme.setBounds(963, 198, 141, 20);
		contentPane.add(textFieldCodFilme);
		
		JLabel label_1 = new JLabel("Titulo:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(843, 271, 75, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("G\u00EAnero:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(843, 409, 75, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Diretor:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(843, 310, 75, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Ano:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(843, 361, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(963, 271, 141, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(Color.GRAY);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(963, 310, 141, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(963, 361, 141, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(963, 409, 141, 14);
		contentPane.add(label_8);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(TelaLocacao.class.getResource("/br/edu/fatec/icons/zoom.png")));
		button.setBounds(1114, 198, 46, 23);
		contentPane.add(button);
		
		JLabel label_9 = new JLabel("CPF do Cliente:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_9.setBounds(133, 198, 207, 14);
		contentPane.add(label_9);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		formattedTextField.setColumns(10);
		formattedTextField.setBounds(298, 195, 225, 20);
		contentPane.add(formattedTextField);
		
		JLabel label_10 = new JLabel("");
		label_10.setForeground(Color.GRAY);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(298, 309, 227, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setForeground(Color.GRAY);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_11.setBounds(298, 408, 225, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.GRAY);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_12.setBounds(298, 270, 225, 14);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setForeground(Color.GRAY);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_13.setBounds(298, 360, 225, 14);
		contentPane.add(label_13);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(TelaLocacao.class.getResource("/br/edu/fatec/icons/zoom.png")));
		button_1.setBounds(533, 194, 40, 23);
		contentPane.add(button_1);
		
		JLabel label_14 = new JLabel("Nome:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_14.setBounds(133, 309, 70, 14);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("Email:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_15.setBounds(133, 408, 70, 14);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("N\u00BA Carterinha:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_16.setBounds(133, 270, 159, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("Data Nasc:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_17.setBounds(133, 360, 130, 14);
		contentPane.add(label_17);
		
		JButton btnAlugar = new JButton("Confirmar");
		btnAlugar.setIcon(new ImageIcon(TelaLocacao.class.getResource("/br/edu/fatec/icons/accept.png")));
		btnAlugar.setBounds(1172, 663, 141, 51);
		contentPane.add(btnAlugar);
		
		JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o:");
		lblDataDeDevoluo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataDeDevoluo.setBounds(722, 586, 159, 14);
		contentPane.add(lblDataDeDevoluo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Cliente"));
		panel_1.setBounds(35, 147, 597, 326);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Filme"));
		panel_2.setBounds(722, 147, 597, 326);
		contentPane.add(panel_2);

		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		String d = form.format(date);
		String data[] = d.split("/");
		int day = Integer.parseInt(data[0]);
		//int month = Integer.parseInt(data[1]);
		//int year = Integer.parseInt(data[2]);
		day += 7;
		date.setDate(day);
		String d2 = form.format(date);
		lblDataDevolucao = new JLabel(d2);
		lblDataDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDevolucao.setBounds(891, 588, 159, 14);
		contentPane.add(lblDataDevolucao);
		
		JLabel lblDataAtual = new JLabel(d);
		lblDataAtual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataAtual.setBounds(891, 546, 85, 14);
		contentPane.add(lblDataAtual);
		
		JLabel lblDataAtual_1 = new JLabel("Data Atual:");
		lblDataAtual_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataAtual_1.setBounds(722, 546, 159, 14);
		contentPane.add(lblDataAtual_1);
	}
}
