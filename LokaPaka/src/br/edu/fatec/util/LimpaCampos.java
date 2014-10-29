package br.edu.fatec.util;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LimpaCampos {

	/**
	 *  construtor utilitário para limpar campos na tela
	 * @param jframe
	 */
	public LimpaCampos(JFrame jframe) {
		// limpa os campos
		for (int i = 0; i < jframe.getContentPane().getComponentCount(); i++) {
			// varre todos os componentes

			Component c = jframe.getContentPane().getComponent(i);

			if (c instanceof JTextField) {
				// apaga os valores
				JTextField field = (JTextField) c;
				field.setText("");
			}
		}
	}
}
