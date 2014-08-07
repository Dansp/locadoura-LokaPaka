package br.edu.fatec.bean;

public class Funcionario {
	
	private String userName;
	private String passworld;
	private String email;
	
	public Funcionario(){
		
	}
	
	public Funcionario(String userName, String passworld, String email) {
		super();
		this.userName = userName;
		this.passworld = passworld;
		this.email = email;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassworld() {
		return passworld;
	}



	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
