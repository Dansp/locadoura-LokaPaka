package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.util.ConnectionFactory;

public class ClienteDAO {
	private Connection comn;
	private Cliente cliente;

	public ClienteDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexao
		try {
			comn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// m�todo de salvar / gravar / incluir

	public void salvar(Cliente cliente) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		if (cliente == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO cliente (nome, data_nascimento, sexo, rg, cpf, endereco, num_casa,  complemento, bairro, cidade, uf, telefone_res, telefone_cel, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getDataNasci());
			ps.setString(3, cliente.getSexo());
			ps.setString(4, cliente.getRg());
			ps.setString(5, cliente.getCpf());
			ps.setString(6, cliente.getEndereco());
			ps.setString(7, cliente.getNumCasa());
			ps.setString(8, cliente.getComplemento());
			ps.setString(9, cliente.getBairro());
			ps.setString(10, cliente.getCidade());
			ps.setString(11, cliente.getUf());
			ps.setString(12, cliente.getTelRes());
			ps.setString(13, cliente.getTelCel());
			ps.setString(14, cliente.getEmail());

			// salva no banco de dados
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// m�todo de salvar / gravar / incluir

	public List<Cliente> consultar(Cliente cliente) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
	
		if (cliente == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "SELECT * from cliente where cpf = ? or nome = ? or num_carterinha = ?";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getCpf());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getNumCarterinha());
			rs = ps.executeQuery();
			while(rs.next()){
					
				cliente.setNumCarterinha(rs.getString("num_carterinha"));
				cliente.setNomeCliente(rs.getString("nome"));
				cliente.setDataNasci(rs.getString("data_nascimento"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setRg(rs.getString("rg"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumCasa(rs.getString("num_casa"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setUf(rs.getString("uf"));
				cliente.setTelRes(rs.getString("telefone_res"));
				cliente.setTelCel(rs.getString("telefone_cel"));
				cliente.setEmail(rs.getString("email"));

				clientes.add(cliente);
			}
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

		return clientes;
	}

	public void excluir(Cliente cliente) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;

		if (cliente == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM cliente WHERE num_carterinha = ? ";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getNumCarterinha());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}

	}

	public void alterar(Cliente cliente) throws Exception {
		PreparedStatement ps = null;
		Connection conn = null;

		if (cliente == null)
			throw new Exception("O valor passado n�o pode ser nulo");

		try {
			String SQL = "UPDATE cliente SET  nome = ?, data_nascimento = ?, sexo= ?,  rg= ?, cpf= ?,  endereco= ?,  num_casa= ?, complemento= ?,"
					+ " bairro= ?, cidade= ?, uf= ?, telefone_res= ?, telefone_cel= ?, email= ? where num_carterinha = ?";
			conn = this.comn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getDataNasci());
			ps.setString(3, cliente.getSexo());
			ps.setString(4, cliente.getRg());
			ps.setString(5, cliente.getCpf());
			ps.setString(6, cliente.getEndereco());
			ps.setString(7, cliente.getNumCasa());
			ps.setString(8, cliente.getComplemento());
			ps.setString(9, cliente.getBairro());
			ps.setString(10, cliente.getCidade());
			ps.setString(11, cliente.getUf());
			ps.setString(12, cliente.getTelRes());
			ps.setString(13, cliente.getTelCel());
			ps.setString(14, cliente.getEmail());
			ps.setString(15, cliente.getNumCarterinha());

			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}