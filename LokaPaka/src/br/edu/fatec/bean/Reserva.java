package br.edu.fatec.bean;

public class Reserva {
	
	private String idReserva;
	private String id_cliente;
	private String id_filme;
	private String reservado;
	
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Reserva(String id, String id_cliente, String id_filme,
			String reservado) {
		super();
		this.idReserva = id;
		this.id_cliente = id_cliente;
		this.id_filme = id_filme;
		this.reservado = reservado;
	}
	
	
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
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
