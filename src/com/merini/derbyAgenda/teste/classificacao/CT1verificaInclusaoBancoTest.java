package com.merini.derbyAgenda.teste.classificacao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;

public class CT1verificaInclusaoBancoTest 
{
	private String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	
	private String nomeClasssificacaoSt = "Entretenimento 6" + String.valueOf(new Date().getTime());
	private String descricaoSt = "Atividades de lazer 2";	
	private String sqlInsertClassif = "INSERT INTO classificacao(nomeclassificacao, cor, descricao) values "
			+ "('"+nomeClasssificacaoSt
			+ "','Azul Escuro',"
			+ " '"+descricaoSt+"')";
	
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
		System.out.println("assert equals");
		assertEquals(1, resultado);
		verificaInclusao();
	}
	
	@Test
	public void verificaInclusao()
	{		
		ClassificacaoDAO dao = new ClassificacaoDAO();
		System.out.println("carregar "+nomeClasssificacaoSt);
		Classificacao classificacao = (Classificacao) dao.carregar(nomeClasssificacaoSt);
		assertEquals(descricaoSt, classificacao.getDescricao());
		assertEquals("Azul Escuro", classificacao.getCor());
	}
	
}
