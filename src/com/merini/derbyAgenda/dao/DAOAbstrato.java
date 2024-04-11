package com.merini.derbyAgenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

//import javax.persistence.EntityManager;

import com.merini.derbyAgenda.modelo.Comentario;

public abstract class DAOAbstrato //implements FacadeInterf
{
//	protected static EntityManager em ;		
	protected static com.merini.derbyAgenda.modelo.Comentario c = new Comentario();
	private static String JdbcUrl="jdbc:derby:agendaDerby;";//create=true";
	
	
	
	public DAOAbstrato()
	{
//		em  = EM.getInstance().getEm();
	}


	public abstract void editar(Object objeto) ;
	
//	@Override
	public void excluir(Integer id) 
	{		// TODO Auto-generated method stub
		
	}

//	@Override
	public abstract Object gravar(Object entidade);


//	@Override
	public List obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
	public abstract List obterTodosNomes() ;
	


//	@Override
	public Integer recuperaIdPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
	public Object recuperaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object carregar(String nomeClasssificacao) {
		// TODO Auto-generated method stub
		return null;
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
	

	public void shutDown() 
	{
		System.out.println("public void shutDown() ");
		String shutdownUrl = "jdbc:derby:;shutdown=true";
		try 
		{			
			DriverManager.getConnection(shutdownUrl);
				System.out.println("shutdown1");
		} 
		catch (SQLException e) 
		{
			if (e.getSQLState().equals("XJ015"))
				{System.out.println("shutdown2");}
			else
				{e.printStackTrace();}
		}
	}

}
