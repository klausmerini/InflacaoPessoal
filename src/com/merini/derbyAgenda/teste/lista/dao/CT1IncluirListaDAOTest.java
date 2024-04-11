package com.merini.derbyAgenda.teste.lista.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Lista;

public class CT1IncluirListaDAOTest 
{

	private String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	
	private String sqlCreateTableLista  = "CREATE TABLE lista (idlista INT NOT NULL GENERATED ALWAYS AS IDENTITY, nomelista VARCHAR(200), descrlista VARCHAR(700), PRIMARY KEY(idlista))";

	private String nomeListaSt = "Gaveta 1 "+String.valueOf(new Date().getTime());

	private String descricaoSt = "Gaveta de cima armário preto";

	@Test
	public void verificaInclusao()
	{		
		System.out.println("CT1IncluirListaDAOTest");
		ListaDAO dao = new ListaDAO();
		
		Lista lista = new Lista();
		lista.setNomelista(nomeListaSt);
		lista.setDescrlista(descricaoSt);
		
		Lista listaGravado = (Lista) dao.gravar(lista);
		
		System.out.println("executar assert");
		assertEquals(descricaoSt, listaGravado.getDescrlista());
		assertEquals(nomeListaSt, listaGravado.getNomelista());
	}

	//@Test
	public void CT1verificaInclusaoBancoTest()
	{		
		int resultado=0;
		try 
		{
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado");
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate (sqlCreateTableLista);
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
}
