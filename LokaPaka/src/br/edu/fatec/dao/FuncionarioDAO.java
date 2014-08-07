package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.fatec.bean.Funcionario;

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
	
	public void salvar(Funcionario funcionario) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		if (funcionario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO funcionario (userName, senha, email) values (?, ?, ?)";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, funcionario.getUserName());
			ps.setString(2, funcionario.getPassworld());
			ps.setString(3, funcionario.getEmail());
		
			// salve in Data Base
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public Funcionario consultar(Funcionario funcionario) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		if (funcionario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "SELECT * from funcionario where userName = ? or email = ? and senha = ? ";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, funcionario.getUserName());
			ps.setString(2, funcionario.getEmail());
			ps.setString(3, funcionario.getPassworld());
			rs = ps.executeQuery();
			rs.next();
			funcionario.setUserName(rs.getString("userName"));
			funcionario.setEmail(rs.getString("email"));
			funcionario.setPassworld(rs.getString("senha"));
			

			return funcionario;
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}
	

}
