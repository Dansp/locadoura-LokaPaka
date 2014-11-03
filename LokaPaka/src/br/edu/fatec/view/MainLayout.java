package br.edu.fatec.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.edu.fatec.util.SetaTamanhoTela;
import java.awt.Font;

public class MainLayout extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private final JLabel time = new JLabel();
    private final SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm");
    private int   currentSecond;
    private Calendar calendar;
    private JLabel text_clock = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLayout frame = new MainLayout();
				        frame.setVisible( true );
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
		SetaTamanhoTela tela = new SetaTamanhoTela(this);
		int x = tela.WIDTH();
		int y = tela.HEIGHT();
		setTitle("Lokapaka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, x, y);
		
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
				//dispose();
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
				//dispose();
			}
		});
		mnCliente.add(mntmMenorDe);
		
		JMenuItem mntmFilme = new JMenuItem("Filme");
		mntmFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFilme().setVisible(true);
				//dispose();
				
			}
		});
		mnCadastro.add(mntmFilme);
		
		JMenu mnNewMenu = new JMenu("Consultas");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					//dispose();
					new TelaConsulta().setVisible(true);			
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("Reserva");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaReserva().setVisible(true);
			}
		});
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
		contentPane.setBackground(Color.WHITE);
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
		lblWwwvideo.setBounds(1171, 693, 164, 14);
		contentPane.add(lblWwwvideo);
		
		JLabel imagem_fundo_lakapaka = new JLabel("");
		imagem_fundo_lakapaka.setAlignmentX(Component.CENTER_ALIGNMENT);
		Image img = new ImageIcon(this.getClass().getResource("/lokapaka_baixa.jpg")).getImage();
		imagem_fundo_lakapaka.setIcon(new ImageIcon(img));
		imagem_fundo_lakapaka.setBounds(493, -42, 1486, 843);
		contentPane.add(imagem_fundo_lakapaka);
		text_clock.setForeground(Color.BLUE);
		
		
		text_clock.setFont(new Font("Times New Roman", Font.BOLD, 54));
		text_clock.setBounds(1094, 521, 233, 77);
		contentPane.add(text_clock);
		

		start();
		
		
		setResizable(false);
	}
	
	 private void reset(){
	        calendar = Calendar.getInstance();
	        currentSecond = calendar.get(Calendar.SECOND);
	    }
	    public void start(){
	        reset();
	        Timer timer = new Timer();
	        timer.scheduleAtFixedRate( new TimerTask(){
	            public void run(){
	                if( currentSecond == 60 ) {
	                    reset();
	                }
	                text_clock.setText( String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond ));
	                currentSecond++;
	            }
	        }, 0, 1000 );
	    }
}
