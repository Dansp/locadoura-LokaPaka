package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		ResultSet rs = null;
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
			
			ps = null;
			String SQL2 = "SELECT * from filme where titulo = ?";
			//este bloco procura pelo id do filme gerado no banco altomaticamente
			ps = conn.prepareStatement(SQL2);
			ps.setString(1, filme.getTitulo());
			rs = ps.executeQuery();
			
			while(rs.next()){
				filme.setCodCliente(rs.getString("idfilme"));
			}
			
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
			String SQL = "SELECT * from filme where titulo = ? or idfilme = ? or genero = ?";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getCodCliente());
			ps.setString(3, filme.getGenero());
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				filme = new Filme();
				
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
	
	
	public void alterar(Filme filme) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;

		if (filme == null)
			throw new Exception("O valor passado não pode ser nulo");

		try {
			String SQL = "UPDATE filme SET titulo = ?, diretor = ?,  ano = ?, genero = ? WHERE idfilme = ?";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getDiretor());
			ps.setString(3, filme.getAno());
			ps.setString(4, filme.getGenero());
			ps.setString(5, filme.getCodCliente());
			

			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public void excluir(Filme filme) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;

		if (filme == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM filme WHERE idfilme = ? ";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, filme.getCodCliente());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}
}
