package com.merini.derbyAgenda.view.lista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.merini.derbyAgenda.modelo.Comentario;

public class QueryTableModelListaDeCompras extends AbstractTableModel
{
	Comentario c = new Comentario();
	private ArrayList<Object[]> linhas;
	private String[] colunas;
	private static String JdbcUrl="jdbc:derby:agendaDerby;";//create=true";
	
	private Statement stmt;
	private String query;
	
	final static int PRIMEIRA_COLUNA= 0;
	
	public QueryTableModelListaDeCompras(String sql)
	{
//		linhas = new ArrayList<Object[]>();
//		loadData();
		c.comentaValor("query - ", query);
		try
		{
	//		stmt=DB.getInstance().getConnection().createStatement();
			this.query=sql;
			linhas = new ArrayList<Object[]>();
			loadData();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public QueryTableModelListaDeCompras()
	{
//		linhas = new ArrayList<Object[]>();
//		loadData();
		query =  "SELECT * FROM pendencia;";
		try
		{
	//		stmt=DB.getInstance().getConnection().createStatement();			
			linhas = new ArrayList<Object[]>();
			loadData();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void loadData()//carrega dados do banco pro modelo
	{
			System.out.println("		.loadData");
			c.comentaValor("query - ", query);
		Connection connection = conecta();	
		
		try 
		{	
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			colunas = new String[numCols];
			
			//itera lista e preenche ArrayList com ResultSet
			iteraRSpreecheArray(numCols, rsmd, rs );
			
			fireTableDataChanged();			
		} 
		
		catch (SQLException e) {	e.printStackTrace();	}		
				
		System.out.println(" numero de linhas - "+linhas.size());		
	}
	
	
	public void iteraRSpreecheArray(int numCols, ResultSetMetaData rsmd, ResultSet rs ) throws SQLException
	{
		for (int i = 0; i < numCols; i++) 
		{
			System.out.println(rsmd.getColumnName(i+1));
			colunas[i]=rsmd.getColumnName(i+1);
		}
					
		linhas.clear();
		
		while (rs.next())
		{
			Object l[] = new Object[numCols];
			for (int i = 0; i < numCols; i++) 
			{
				l[i]=rs.getObject(i+1);
//				String st = (String) l[i];
//				c.comentaValor(" linha "+String.valueOf(i), String.valueOf(l[i]));
			}
			linhas.add(l);				
		}
	}	
	
	public int getRowCount() 
	{
		// TODO Auto-generated method stub
		return linhas.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int col)
	{
		String columnNameSt="";
		if (col == 1)
		{
			columnNameSt="Nome do Item da Lista";
		}
		else			
		{
			columnNameSt = colunas[col];
		}
		return columnNameSt;
	}

	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		try
		{
			
			if (columnIndex == PRIMEIRA_COLUNA) 
			{
				
			}
			
			
		}
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
		
		System.out.println("getValueAt()");
		Object l[] = linhas.get(rowIndex);		
		return l[columnIndex];
	}		

	public Connection conecta()
	{
		Connection connection =null;
	    try {
	    	DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());	
			connection = DriverManager.getConnection(JdbcUrl);	} 
	    catch (SQLException e) {
			e.printStackTrace();	}
			System.out.println("conectado");
		return connection;		
	}

}

