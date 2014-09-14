package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.util.ConnectionFactory;

public class FilmeDAO {
	private Connection comn;
	private Filme filme;

	public FilmeDAO() throws Exception {
		// call the class ConnectionFactory and connect with it
		try {
			comn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	public void salvar(Filme filme) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (filme == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO filme (titulo, diretor, ano, genero) values (?, ?, ?, ?)";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getDiretor());
			ps.setString(3, filme.getAno());
			ps.setString(4, filme.getGenero());
			

			// salva no banco de dados
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		
	}
	
	
	public List<Filme> consultar(Filme filme) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Filme> filmes = new ArrayList<Filme>();
		if (filme == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "SELECT * from filme where idfilme = ? or titulo = ?" ;
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, filme.getCodCliente());
			ps.setString(2, filme.getTitulo());
			rs = ps.executeQuery();
			while(rs.next()){
			
				filme.setCodCliente(rs.getString("idfilme"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setDiretor(rs.getString("diretor"));
				filme.setAno(rs.getString("ano"));
				filme.setGenero(rs.getString("genero"));
		
				filmes.add(filme);
			}
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		
		return filmes;

	}

}
