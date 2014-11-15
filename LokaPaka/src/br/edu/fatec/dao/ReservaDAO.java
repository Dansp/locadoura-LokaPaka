package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.bean.Reserva;
import br.edu.fatec.util.ConnectionFactory;

public class ReservaDAO {

	private Connection comn;
	
	public ReservaDAO() throws Exception{
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			comn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	
	
	
	public void reservar(Cliente cliente, Filme filme) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null && filme == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			String SQL = "INSERT INTO reserva (idfilme, idCliente, reservado) values(?, ?, ?)"; 
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, filme.getCodFilme());
			ps.setString(2, cliente.getNumCarterinha());
			ps.setString(3, filme.getReservado());
			//coloca o situação do filme como reservado
			
			// salva no banco de dados
			ps.executeUpdate();
			
		} catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally{
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public Reserva consultar(Cliente cliente, Filme filme) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		if (cliente == null && filme == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try{
			conn = this.comn;
			
			String SQL = "SELECT * FROM reserva WHERE idfilme = ? AND idCliente = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, filme.getCodFilme());
			ps.setString(2, cliente.getNumCarterinha());
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				Reserva reserva = new Reserva();
				
				reserva.setIdReserva(rs.getString("idreserva"));
				reserva.setId_filme(rs.getString("idfilme"));
				reserva.setId_cliente(rs.getString("idCliente"));
				reserva.setReservado(rs.getString("reservado"));
				
				
				return reserva;
			}
			
			return null;
		} catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally{
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}
