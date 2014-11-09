package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.fatec.bean.Funcionario;
import br.edu.fatec.bean.Gerente;
import br.edu.fatec.util.ConnectionFactory;

public class FuncionarioDAO {
	private Connection comn;
	private Funcionario funcionario;
	
	public FuncionarioDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			comn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	public void salvar(Funcionario funcionario, int tipo) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		if (funcionario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO funcionario (userName, senha, email, codGerente) values (?, ?, ?, ?)";
			conn = this.comn;

			ps = conn.prepareStatement(SQL);
			ps.setString(1, funcionario.getUserName());
			ps.setString(2, funcionario.getPassworld());
			ps.setString(3, funcionario.getEmail());
			ps.setInt(4, tipo);
		
			// salve in Data Base
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public Funcionario consultar(Funcionario func) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		if (func == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "SELECT * from funcionario where userName = ? or email = ? and senha = ? ";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, func.getUserName());
			ps.setString(2, func.getEmail());
			ps.setString(3, func.getPassworld());
			rs = ps.executeQuery();
			rs.next();
			
			Gerente gerente = new Gerente();
			gerente.setTipo(rs.getInt("codGerente"));
			
			gerente.setUserName(rs.getString("userName"));
			gerente.setEmail(rs.getString("email"));
			gerente.setPassworld(rs.getString("senha"));
				
			return gerente;

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}
	

}
