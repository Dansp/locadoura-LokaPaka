package br.edu.fatec.bean;

public class Gerente extends Funcionario{

	public static final int COD_FUNCIONARIO = 0;
	public static final int COD_GERENTE = 1;
	
	private int tipo;
	
	

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
