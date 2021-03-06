package br.edu.fatec.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import br.edu.fatec.bean.Filme;

public class ConsultaTableModelFilme extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int COL_COD_CLIENTE 	= 0;
	private static final int COL_TITULO 		= 1;
	private static final int COL_DIRETOR 		= 2;
	private static final int COL_ANO 			= 3;
	private static final int COL_GENERO 		= 4;
	

	private List<Filme> filmes;
	
	public ConsultaTableModelFilme(List<Filme> filmes){
		this.filmes = filmes;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		return filmes.size();
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Filme filme = filmes.get(rowIndex);
		
		if(columnIndex == COL_COD_CLIENTE){
			System.out.println("Aqui esta: " + aValue);
			filme.setCodFilme((String) aValue);
		} else if(columnIndex == COL_TITULO){
			filme.setTitulo((String) aValue); ;
		} else if (columnIndex == COL_DIRETOR){
			filme.setDiretor((String) aValue);
		} else if (columnIndex ==  COL_ANO){
			filme.setAno((String) aValue);;
		} else if (columnIndex == COL_GENERO){
			filme.setGenero((String) aValue);
		}
		
        fireTableCellUpdated(rowIndex, columnIndex);     
	}
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Filme filme = filmes.get(rowIndex);
		
		if(columnIndex == COL_COD_CLIENTE){
			return filme.getCodFilme();
		} else if(columnIndex == COL_TITULO){
			return filme.getTitulo();
		} else if (columnIndex == COL_DIRETOR){
			return filme.getDiretor();
		} else if (columnIndex ==  COL_ANO){
			return filme.getAno();
		} else if (columnIndex == COL_GENERO){
			return filme.getGenero();
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
			case COL_COD_CLIENTE:
				coluna = "C�digo";
				break;
			case COL_TITULO:
				coluna = "T�tulo";
				break;
			case COL_DIRETOR:
				coluna = "Diretor";
				break;
			case COL_ANO:
				coluna = "Ano";
				break;
			case COL_GENERO:
				coluna = "G�nero";
				break;
			default:
				throw new IllegalArgumentException("Coluna inv�lida");
		}
		return coluna;
	}
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex == COL_COD_CLIENTE){
			return Integer.class;
		} else if(columnIndex == COL_TITULO){
			return String.class;
		} else if (columnIndex == COL_DIRETOR){
			return String.class;
		} else if (columnIndex ==  COL_ANO){
			return String.class;
		} else if (columnIndex == COL_GENERO){
			return String.class;
		}
		return null;
	}
	
	public Filme get(int row){
		return filmes.get(row);
	}
}
