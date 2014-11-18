package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.bean.Filme;
import br.edu.fatec.bean.Locacao;
import br.edu.fatec.util.ConnectionFactory;

public class LocacaoDAO {

	private Connection comn;
	
	public LocacaoDAO() throws Exception{
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			comn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	
	
	
	public void locar(Locacao locacao) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		if (locacao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		try {
			String SQL = "INSERT INTO locacao (idfilme, idFunc, numCarterinha, dataLocacao, "
					+ "dataDevolucao, dataDevRealizada) values(?, ?, ?, ?, ?, ?)"; 
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			
			/*
			ps.setString(1, locacao.getCodFilme());
			ps.setString(2, locacao.getCodFuncionario());
			ps.setString(3, locacao.getNumCarterinha());
			ps.setString(4, locacao.getDataLocacao());
			ps.setString(5, locacao.getDataDevolucao());
			ps.setString(6, locacao.getDataDevRealizada());
			*/
			
			ps.setInt(1, Integer.parseInt(locacao.getCodFilme()));
			ps.setInt(2, Integer.parseInt(locacao.getCodFuncionario()));
			ps.setInt(3, Integer.parseInt(locacao.getNumCarterinha()));
			ps.setString(4, locacao.getDataLocacao());
			ps.setString(5, locacao.getDataDevolucao());
			ps.setString(6, locacao.getDataDevRealizada());
			//coloca o situa��o do filme como reservado
			
			// salva no banco de dados
			ps.executeUpdate();
			
		} catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally{
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	
	public void devolver(){
		
	}
	
	public boolean alugado(Locacao locacao) throws Exception{
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		if(locacao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		
		Locacao locacao2 = null;
		try{
		conn = this.comn;
		
		String SQL = "SELECT * FROM locacao";
		ps = conn.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			locacao2 = new Locacao(); 
			locacao2.setCodFilme(rs.getString("idfilme"));
			locacao2.setNumCarterinha(rs.getString("numCarterinha"));
			
		}
		
		if(locacao.getCodFilme().equals(locacao2.getCodFilme())
				&& (locacao.getNumCarterinha().equals(locacao2.getNumCarterinha()))){
			return true;
		} 
		
			
		} catch(SQLException sqle){
			throw new Exception("Erro ao inserir dados " + sqle);
			
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		
		return false;
	}
}
