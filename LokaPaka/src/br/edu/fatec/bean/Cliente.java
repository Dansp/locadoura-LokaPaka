package br.edu.fatec.bean;

public class Cliente {

	private String numCarterinha;
	private String nomeCliente;
	private String dataNasci;
	private String cpf;
	private String endereco;
	private String numCasa;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String telRes;
	private String telCel;
	private String email;
	
	
	public Cliente(String numCarterinha, String nomeCliente, String dataNasci,
			String cpf, String endereco, String numCasa,
			String complemento, String bairro, String cidade, String uf,
			String telRes, String telCel, String email) {
		
		this.numCarterinha = numCarterinha;
		this.nomeCliente = nomeCliente;
		this.dataNasci = dataNasci;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numCasa = numCasa;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.telRes = telRes;
		this.telCel = telCel;
		this.email = email;
	}

	
	public Cliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Cliente() {
	}

	public String getNumCarterinha() {
		return numCarterinha;
	}


	public void setNumCarterinha(String numCarterinha) {
		this.numCarterinha = numCarterinha;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getDataNasci() {
		return dataNasci;
	}


	public void setDataNasci(String dataNasci) {
		this.dataNasci = dataNasci;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getNumCasa() {
		return numCasa;
	}


	public void setNumCasa(String string) {
		this.numCasa = string;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getTelRes() {
		return telRes;
	}


	public void setTelRes(String telRes) {
		this.telRes = telRes;
	}


	public String getTelCel() {
		return telCel;
	}


	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
