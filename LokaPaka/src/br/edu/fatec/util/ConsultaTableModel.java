package br.edu.fatec.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.fatec.bean.Filme;

public class ConsultaTableModel extends AbstractTableModel{
	
	private static final int COL_COD_CLIENTE = 0;
	private static final int COL_TITULO = 1;
	private static final int COL_DIRETOR = 2;
	private static final int COL_ANO = 3;
	private static final int COL_GENERO = 4;
	

	private List<Filme> filmes;
	
	public ConsultaTableModel(List<Filme> filmes){
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		Filme filme = filmes.get(rowIndex);
		
		if(columnIndex == COL_COD_CLIENTE){
			return filme.getCodCliente();
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
	public String getColumnName(int column) {
		String coluna = "";
		switch(column) {
			case COL_COD_CLIENTE:
				coluna = "Código";
				break;
			case COL_TITULO:
				coluna = "Título";
				break;
			case COL_DIRETOR:
				coluna = "Diretor";
				break;
			case COL_ANO:
				coluna = "Ano";
				break;
			case COL_GENERO:
				coluna = "Gênero";
				break;
			default:
				throw new IllegalArgumentException("Coluna inválida");
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
