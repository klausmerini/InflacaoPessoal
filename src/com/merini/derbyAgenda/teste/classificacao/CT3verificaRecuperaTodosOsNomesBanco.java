package com.merini.derbyAgenda.teste.classificacao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class CT3verificaRecuperaTodosOsNomesBanco 
{
	String JdbcUrl="jdbc:derby:agendaDerby;create=true";

	@Test
	public void CT5verificaRecuperaTodosOsNomesBanco()
	{
		String sqlRecuperaTodosNomesClassif = "SELECT nomeclassificacao FROM classificacao";   		
		Connection connection = conecta();
		ArrayList<String> nomesClassificacao = new ArrayList<String>();
		try 
		{			   
				PreparedStatement preparedStatement = connection.prepareStatement(sqlRecuperaTodosNomesClassif);
				ResultSet resultSet = preparedStatement.executeQuery();
				String name;
				while(resultSet.next())
				{
					name = resultSet.getString("nomeclassificacao").trim();
					nomesClassificacao.add(name);
					System.out.printf("nome da classificação : %s\n",name);
				}
				resultSet.close();
				preparedStatement.close();
				connection.close();
					System.out.println("nome das classificações recuperado");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		assertEquals("Comercial", nomesClassificacao.get(0));
		assertEquals("Comercial", nomesClassificacao.get(1));
		assertEquals("Entretenimento", nomesClassificacao.get(4));
		shutDown();
	}	

	public Connection conecta()
	{
			System.out.println("public Connection conecta()");
		Connection connection =null;
	    try {
			connection = DriverManager.getConnection(JdbcUrl);	} 
	    catch (SQLException e) {
			e.printStackTrace();	}
			System.out.println("conectado");
		return connection;		
	}
	
	public void shutDown() 
	{
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
