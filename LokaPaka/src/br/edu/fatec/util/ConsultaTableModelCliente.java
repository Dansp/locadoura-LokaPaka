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
	private static final int COL_NOME 			= 1;
	private static final int COL_DATA_NASC 		= 2;
	private static final int COL_CPF 			= 3;
	private static final int COL_ENDERECO 		= 4;
	private static final int COL_NUM_CASA 		= 5;
	private static final int COL_COMPLEMENTO 	= 6;
	private static final int COL_BAIRRO 		= 7;
	private static final int COL_CIDADE 		= 8;
	private static final int COL_UF 			= 9;
	private static final int COL_TEL_RES 		= 10;
	private static final int COL_TEL_CEL 		= 11;
	private static final int COL_EMAIL 			= 12;
	
	

	private List<Cliente> clientes;
	
	public ConsultaTableModelCliente(List<Cliente> clientes){
		this.clientes = clientes;

	}
	
	@Override
	public int getColumnCount() {
		return 13;
	}

	@Override
	public int getRowCount() {
		return clientes.size();
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Cliente cliente = clientes.get(rowIndex);
		
		if(columnIndex == COL_NUM_CARTERINHA){
			 cliente.setNumCarterinha((String) aValue);
		} else if(columnIndex == COL_NOME){
			 cliente.setNomeCliente((String) aValue);
		} else if (columnIndex == COL_DATA_NASC){
			 cliente.setDataNasci((String) aValue);
		} else if (columnIndex == COL_CPF){
			 cliente.setCpf((String) aValue);
		} else if (columnIndex == COL_ENDERECO){
			 cliente.setEndereco((String) aValue);
		} else if (columnIndex == COL_NUM_CASA){
			 cliente.setNumCasa((String) aValue);
		} else if (columnIndex == COL_COMPLEMENTO){
			 cliente.setComplemento((String) aValue);
		} else if (columnIndex == COL_BAIRRO){
			 cliente.setBairro((String) aValue);
		} else if (columnIndex == COL_CIDADE){
			 cliente.setCidade((String) aValue);
		} else if (columnIndex == COL_UF){
			 cliente.setUf((String) aValue);
		} else if (columnIndex == COL_TEL_RES){
			 cliente.setTelRes((String) aValue);
		} else if (columnIndex == COL_TEL_CEL){
			 cliente.setTelCel((String) aValue);
		} else if (columnIndex == COL_EMAIL){
			 cliente.setEmail((String) aValue);
		}
		
		 fireTableCellUpdated(rowIndex, columnIndex);  
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
				coluna = "N� Carterinha";
				break;
			case COL_NOME:
				coluna = "Nome";
				break;
			case COL_DATA_NASC:
				coluna = "Data Nascimento";
				break;
			case COL_CPF:
				coluna = "Cpf";
				break;
			case COL_ENDERECO:
				coluna = "Endere�o";
				break;
			case COL_NUM_CASA:
				coluna = "N� Casa";
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
				break;
			default:
				throw new IllegalArgumentException("Coluna inv�lida");
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
		}  else if (columnIndex == COL_CPF){
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
