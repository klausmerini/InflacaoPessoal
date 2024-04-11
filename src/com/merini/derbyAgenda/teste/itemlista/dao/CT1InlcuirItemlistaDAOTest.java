package com.merini.derbyAgenda.teste.itemlista.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.dao.ItemlistaDAO;
import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Itemlista;
import com.merini.derbyAgenda.modelo.Lista;

public class CT1InlcuirItemlistaDAOTest 
{
	private String JdbcUrl="jdbc:derby:agendaDerby;create=true";
	private String sqlInsertItemlista;
	private String sqlCreateTableItemlista=	"CREATE TABLE itemlista (iditemlista INT NOT NULL "
										    +"GENERATED ALWAYS AS IDENTITY, idlista INT NOT NULL, "
											+"iditem INT NOT NULL, PRIMARY KEY(iditemlista), "
											+"constraint listaFk FOREIGN KEY(idlista) REFERENCES lista(idlista))";
						//					+"constraint itemFk FOREIGN KEY(iditem) REFERENCES item(iditem)) ";
	private String sqlAlterTableItemlista=	"ALTER TABLE itemlista ADD FOREIGN KEY (iditem)	"
											+"REFERENCES item(iditem)";

//	@Test
	public void CT1verificaInclusaoBancoTest()
	{		
		int resultado=0;
		try 
		{
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado");
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate (sqlAlterTableItemlista);//(sqlInsertItemlista);//
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
		ItemlistaDAO dao = new ItemlistaDAO();
		ListaDAO daoL = new ListaDAO();
		Lista lista = daoL.carregar("Gaveta 1");
		Integer idListaInt = lista.getIdlista();
		
		ItemDAO daoI = new ItemDAO();		
		Item item = new Item();
		String nomeItemSt="objeto teste "+String.valueOf(new Date().getTime());
		item.setNomeItem(nomeItemSt);
		item.setDescricao("descr test "+String.valueOf(new Date().getTime()));
		daoI.gravar(item);
		item = (Item) daoI.carregar(nomeItemSt);
		Integer idItemInt = item.getIdItem();
		
		int resultado = (Integer) dao.gravar(idListaInt, idItemInt);
		
//		assertEquals(descricaoSt, itemGravado.getDescricao());
//		assertEquals(nomeItemSt, itemGravado.getNomeItem());
//		assertEquals (corSt, itemGravado.getCor());
	}

}
