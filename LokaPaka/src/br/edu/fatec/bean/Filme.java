package br.edu.fatec.bean;

public class Filme {
	private String codFilme;
	private String titulo;
	private String diretor;
	private String ano;
	private String genero;
	private String reservado;
	
	public Filme(){
		
	}
	
	public Filme(String codFilme, String titulo, String diretor, String ano, String genero, String reservado) {
		super();
		this.codFilme 	= codFilme;
		this.titulo 	= titulo;
		this.diretor 	= diretor;
		this.ano 		= ano;
		this.genero 	= genero;
		this.reservado 	= reservado;

	}

	public String getCodFilme(){
		return codFilme;
	}
	
	public void setCodFilme(String codFilme){
		this.codFilme = codFilme;
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

	public String getReservado() {
		return reservado;
	}

	public void setReservado(String reservado) {
		this.reservado = reservado;
	}
}
