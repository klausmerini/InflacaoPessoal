package com.merini.derbyAgenda.teste;

import static org.junit.Assert.assertEquals;
//import org.junit.FixMethodOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
//import org.junit.runners.MethodSorters;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;


public class ClassificacaoDAOTest
{
	Classificacao classificacao;
	private String nomeClasssificacaoSt = "Entretenimento 6";
	private String descricaoSt = "Atividades de lazer 2";
	
	private String sqlInsertClassif = "INSERT INTO classificacao(nomeclassificacao, cor, descricao) values "
			+ "('"+nomeClasssificacaoSt
			+ "','Azul Escuro',"
			+ " '"+descricaoSt+"')";
	
	private String sqlCreateTableLista  = "";	
	private String sqlCreateTableItemLista  = "";
	private static String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	private static String sqlRecuperaTodosNomesClassif = "SELECT nomeclassificacao FROM classificacao";

//	@Test
	public void CT2verificaCarregar()
	{		
		ClassificacaoDAO dao = new ClassificacaoDAO();
		System.out.println("carregar "+nomeClasssificacaoSt);
		classificacao= (Classificacao) dao.carregar(nomeClasssificacaoSt);
		assertEquals(descricaoSt, classificacao.getDescricao());
		assertEquals("Azul Escuro", classificacao.getCor());
	}	
	
//	@Test
	public void CT3verificaEdicao()
	{
		ClassificacaoDAO dao = new ClassificacaoDAO();
		System.out.println("carregar "+nomeClasssificacaoSt);
		classificacao= (Classificacao) dao.carregar(nomeClasssificacaoSt);
		
		String descricaoSt="descrição editada";		
		classificacao.setDescricao(descricaoSt);
		dao.editar(classificacao);
		Classificacao classificacaoEditada = (Classificacao) dao.carregar(classificacao.getNomeclassificacao());
		assertEquals(descricaoSt, classificacaoEditada.getDescricao());
	}		
	
	@Test
	public void CT4verificaExclusao()
	{
		ClassificacaoDAO dao = new ClassificacaoDAO();
		int resultado = dao.excluir(nomeClasssificacaoSt);
		assertEquals(2, resultado);
	}	
	
//	@Test
	public void CT1verificaInclusaoBancoTest()
	{
		int resultado=0;
		try 
		{
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado");
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate(sqlInsertClassif);
				System.out.println("registro classificação inserido - "+String.valueOf(resultado));
			
			stmt.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
		assertEquals(1, resultado);
	}
	
//	@Test
	public void CT1verificaInclusaoDAOTest()
	{
		ClassificacaoDAO dao = new ClassificacaoDAO();
		int resultado = dao.gravar(sqlInsertClassif);
		assertEquals(1, resultado);
	}
	
//	@Test
	public void CT5verificaRecuperaTodosOsNomesBanco()
	{
		Connection connection = conecta();
		try 
		{			   
				PreparedStatement preparedStatement = connection.prepareStatement
				(sqlRecuperaTodosNomesClassif);
				ResultSet resultSet = preparedStatement.executeQuery();
				String name;
				while(resultSet.next())
				{
					name = resultSet.getString("nomeclassificacao").trim();
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
