package br.edu.fatec.bean;

public class Reserva {
	
	private String id;
	private String id_cliente;
	private String id_filme;
	private String reservado;
	
	
	
	
	
	public Reserva(String id, String id_cliente, String id_filme,
			String reservado) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.id_filme = id_filme;
		this.reservado = reservado;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getId_filme() {
		return id_filme;
	}
	public void setId_filme(String id_filme) {
		this.id_filme = id_filme;
	}
	public String getReservado() {
		return reservado;
	}
	public void setReservado(String reservado) {
		this.reservado = reservado;
	}
	
	
	
	

}
