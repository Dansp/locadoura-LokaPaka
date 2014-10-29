package br.edu.fatec.util;

import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * 
 * @author Daniel Pereira
 * Classe utilitária para deixar a tela full screen
 */
public class SetaTamanhoTela {
	private static Toolkit tk;
	
	
	public SetaTamanhoTela(JFrame jframe) {
		tk = Toolkit.getDefaultToolkit(); 
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jframe.setUndecorated(true);
	}
	
	public final Integer WIDTH() {
		return ((int) tk.getScreenSize().getWidth()); 
	}
	
	public final Integer HEIGHT(){	
		return ((int) tk.getScreenSize().getHeight());
	}
}
