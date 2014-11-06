package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
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
	
	
	
	
	public void salvar(Cliente cliente, Filme filme) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null || filme == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			String SQL = "INSERT INTO reserva (idfilme, idCliente) values(?, ?)"; 
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, filme.getCodFilme());
			ps.setString(2, cliente.getNumCarterinha());
			//coloca o situação do filme como reservado
			filme.setReservado("S");
			// salva no banco de dados
			ps.executeUpdate();
			
		} catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally{
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}
