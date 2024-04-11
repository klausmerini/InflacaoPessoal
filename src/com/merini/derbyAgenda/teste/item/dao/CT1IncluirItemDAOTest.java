package com.merini.derbyAgenda.teste.item.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.modelo.Item;

public class CT1IncluirItemDAOTest 
{

	private String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	
	private String nomeItemSt = "Pagina - " + String.valueOf(new Date().getTime());
	private String descricaoSt = "Atividade - ";	
	private String lugarSt = "Caderno do Mutante monstro";
	
	private String corSt ="Azul Escuro";
	
	private String sqlInsertItem = "INSERT INTO Item(nomeItem, cor, descricao) values "
			+ "('"+nomeItemSt
			+ "','Azul Escuro',"
			+ " '"+descricaoSt+"')";
	private String sqlCreateTableItem  = "CREATE TABLE item (iditem INT NOT NULL GENERATED ALWAYS AS IDENTITY, nomeitem VARCHAR(200), cor VARCHAR(70), lugar VARCHAR(200), descricao VARCHAR(700), PRIMARY KEY(iditem))";

	
//	@Test
	public void CT1verificaInclusaoBancoTest()
	{		
		int resultado=0;
		try 
		{
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado");
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate (sqlInsertItem);//(sqlCreateTableItem);
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
		ItemDAO dao = new ItemDAO();
		
		Item item = new Item();
		item.setNomeItem(nomeItemSt);
		item.setCor(corSt);
		item.setDescricao(descricaoSt);
		item.setLugar(lugarSt);		
		
		Item itemGravado = (Item) dao.gravar(item);
		
		assertEquals(descricaoSt, itemGravado.getDescricao());
		assertEquals(nomeItemSt, itemGravado.getNomeItem());
		assertEquals (corSt, itemGravado.getCor());
	}
}
