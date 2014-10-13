package br.edu.fatec.util;

import java.sql.*;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		try {

			// indica qual Ã© o banco de dados que estou utilizando e seu driver

			Class.forName("com.mysql.jdbc.Driver");

			// estabelece a conexao e retorna uma conexao

			return DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/lokapaka", "root",
					"12345678");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	// fecha uma conexão de três formas: conn, stmt, rs

	public static void closeConnection (Connection comn, Statement stmt, ResultSet rs) throws Exception{
		close (comn,stmt,rs);
	}
	public static void closeConnection (Connection comn, Statement stmt) throws Exception{
		close (comn,stmt,null);
	}
	public static void closeConnection (Connection comn) throws Exception{
		close (comn,null,null);
	}

	private static void close (Connection comn, Statement stmt, ResultSet rs) throws Exception{
		try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(comn!=null) comn.close();
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
}
