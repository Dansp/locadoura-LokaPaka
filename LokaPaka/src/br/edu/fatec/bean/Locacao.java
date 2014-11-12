package br.edu.fatec.bean;

public class Locacao {
	
	private String codLocacao;
	private String codFilme;
	private String codFuncionario;
	private String numCarterinha;
	private String codReserva;
	private String dataLocacao;
	private String dataDevolucao;
	private String dataDevRealizada;
	
	public Locacao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Locacao(String codLocacao, String codFilme, String codFuncionario,
			String numCarterinha, String codReserva, String dataLocacao,
			String dataDevolucao, String dataDevRealizada) {
		super();
		this.codLocacao = codLocacao;
		this.codFilme = codFilme;
		this.codFuncionario = codFuncionario;
		this.numCarterinha = numCarterinha;
		this.codReserva = codReserva;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.dataDevRealizada = dataDevRealizada;
	}
	
	public String getCodLocacao() {
		return codLocacao;
	}
	public void setCodLocacao(String codLocacao) {
		this.codLocacao = codLocacao;
	}
	public String getCodFilme() {
		return codFilme;
	}
	public void setCodFilme(String codFilme) {
		this.codFilme = codFilme;
	}
	public String getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(String codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	public String getNumCarterinha() {
		return numCarterinha;
	}
	public void setNumCarterinha(String numCarterinha) {
		this.numCarterinha = numCarterinha;
	}
	public String getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}
	public String getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getDataDevRealizada() {
		return dataDevRealizada;
	}
	public void setDataDevRealizada(String dataDevRealizada) {
		this.dataDevRealizada = dataDevRealizada;
	}
	
	

}
