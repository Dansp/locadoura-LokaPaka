package br.edu.fatec.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.fatec.bean.Cliente;

public class ConsultaTableModelCliente extends AbstractTableModel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 136832678247231777L;
	
	private static final int COL_NUM_CARTERINHA = 0;
	private static final int COL_NOME = 1;
	private static final int COL_DATA_NASC = 2;
	private static final int COL_SEXO = 3;
	private static final int COL_RG = 4;
	private static final int COL_CPF = 5;
	private static final int COL_ENDERECO = 6;
	private static final int COL_NUM_CASA = 7;
	private static final int COL_COMPLEMENTO = 8;
	private static final int COL_BAIRRO = 9;
	private static final int COL_CIDADE = 10;
	private static final int COL_UF = 11;
	private static final int COL_TEL_RES = 12;
	private static final int COL_TEL_CEL = 13;
	private static final int COL_EMAIL = 14;
	
	

	private List<Cliente> clientes;
	
	public ConsultaTableModelCliente(List<Cliente> clientes){
		this.clientes = clientes;

	}
	
	@Override
	public int getColumnCount() {
		return 15;
	}

	@Override
	public int getRowCount() {
		return clientes.size();
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		fireTableDataChanged();
	}
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clientes.get(rowIndex);
		
		if(columnIndex == COL_NUM_CARTERINHA){
			return cliente.getNumCarterinha();
		} else if(columnIndex == COL_NOME){
			return cliente.getNomeCliente();
		} else if (columnIndex == COL_DATA_NASC){
			return cliente.getDataNasci();
		} else if (columnIndex ==  COL_SEXO){
			return cliente.getSexo();
		} else if (columnIndex == COL_RG){
			return cliente.getRg();
		} else if (columnIndex == COL_CPF){
			return cliente.getCpf();
		} else if (columnIndex == COL_ENDERECO){
			return cliente.getEndereco();
		} else if (columnIndex == COL_NUM_CASA){
			return cliente.getNumCasa();
		} else if (columnIndex == COL_COMPLEMENTO){
			return cliente.getComplemento();
		} else if (columnIndex == COL_BAIRRO){
			return cliente.getBairro();
		} else if (columnIndex == COL_CIDADE){
			return cliente.getCidade();
		} else if (columnIndex == COL_UF){
			return cliente.getUf();
		} else if (columnIndex == COL_TEL_RES){
			return cliente.getTelRes();
		} else if (columnIndex == COL_TEL_CEL){
			return cliente.getTelCel();
		} else if (columnIndex == COL_EMAIL){
			return cliente.getEmail();
		}
		
		return null;
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		if(col == 0){
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		String coluna = "";
		switch(column) {
			case COL_NUM_CARTERINHA:
				coluna = "Nº Carterinha";
				break;
			case COL_NOME:
				coluna = "Nome";
				break;
			case COL_DATA_NASC:
				coluna = "Data Nascimento";
				break;
			case COL_SEXO:
				coluna = "Sexo";
				break;
			case COL_RG:
				coluna = "RG";
				break;
			case COL_CPF:
				coluna = "Cpf";
				break;
			case COL_ENDERECO:
				coluna = "Endereço";
				break;
			case COL_NUM_CASA:
				coluna = "Nº Casa";
				break;
			case COL_COMPLEMENTO:
				coluna = "Complemento";
				break;
			case COL_BAIRRO:
				coluna = "Bairro";
				break;
			case COL_CIDADE:
				coluna = "Cidade";
				break;
			case COL_UF:
				coluna = "Uf";
				break;
			case COL_TEL_RES:
				coluna = "Tel Res:";
				break;
			case COL_TEL_CEL:
				coluna = "Tel Cel:";
				break;
			case COL_EMAIL:
				coluna = "Email";
			default:
				throw new IllegalArgumentException("Coluna inválida");
		}
		return coluna;
	}
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex == COL_NUM_CARTERINHA){
			return Integer.class;
		} else if(columnIndex == COL_NOME){
			return String.class;
		} else if (columnIndex == COL_DATA_NASC){
			return String.class;
		} else if (columnIndex ==  COL_SEXO){
			return String.class;
		} else if (columnIndex == COL_RG){
			return String.class;
		} else if (columnIndex == COL_CPF){
			return String.class;
		} else if (columnIndex == COL_ENDERECO){
			return String.class;
		} else if (columnIndex == COL_NUM_CASA){
			return String.class;
		} else if (columnIndex == COL_COMPLEMENTO){
			return String.class;
		} else if (columnIndex == COL_BAIRRO){
			return String.class;
		} else if (columnIndex == COL_CIDADE){
			return String.class;
		} else if (columnIndex == COL_UF){
			return String.class;
		} else if (columnIndex == COL_TEL_RES){
			return String.class;
		} else if (columnIndex == COL_TEL_CEL){
			return String.class;
		} else if (columnIndex == COL_EMAIL){
			return String.class;
		}
		return null;
	}
	
	
	
	public Cliente get(int row){
		return clientes.get(row);
	}
}
