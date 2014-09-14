package br.edu.fatec.bean;

public class Filme {
	private String codCliente;
	private String titulo;
	private String diretor;
	private String ano;
	private String genero;
	
	public Filme(){
		
	}
	
	public Filme(String codCliente, String titulo, String diretor, String ano, String genero) {
		super();
		this.codCliente = codCliente;
		this.titulo = titulo;
		this.diretor = diretor;
		this.ano = ano;
		this.genero = genero;
	}

	public String getCodCliente(){
		return codCliente;
	}
	
	public void setCodCliente(String codCliente){
		this.codCliente = codCliente;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

}
