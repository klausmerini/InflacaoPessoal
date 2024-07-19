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
	private String sqlDescribeTableItemlista=	"DESCRIBE itemlsta";
	
	String nomeItemSt="objeto teste "+String.valueOf(new Date().getTime());

//	@Test
	public void CT1verificaInclusaoBancoTest()
	{		
		int resultado=0;
		try 
		{
			Connection connection = DriverManager.getConnection(JdbcUrl);
				System.out.println("conectado - CT1verificaInclusaoBancoTest");
			Statement stmt = connection.createStatement();
			resultado = stmt.executeUpdate (sqlDescribeTableItemlista);//(sqlInsertItemlista);//
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
//		verificaInclusao();
	}
//	
////	@Test
//	public void verificaInclusao()
//	{		
//		ItemlistaDAO dao = new ItemlistaDAO();
//		ListaDAO daoL = new ListaDAO();
//		Lista lista = daoL.carregar("Gaveta 1");
//		Integer idListaInt = lista.getIdlista();
//		
//		ItemDAO daoI = new ItemDAO();		
//		Item item = montaItem();
//		daoI.gravar(item);	//gravar item para gerar id
//		try {
//			item = (Item) daoI.carregar(nomeItemSt);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Integer idItemInt = item.getIdItem();
//		
//		int resultado = (Integer) dao.gravar(idListaInt, idItemInt);
//		
////		assertEquals(descricaoSt, itemGravado.getDescricao());
////		assertEquals(nomeItemSt, itemGravado.getNomeItem());
////		assertEquals (corSt, itemGravado.getCor());
//	}
//	
	@Test
	public void verificaInclusaoParaInflPess()
	{		
		ItemlistaDAO dao = new ItemlistaDAO();
		ListaDAO daoL = new ListaDAO();
		Lista lista = daoL.carregar("compras teste");
		Itemlista itemLista = new Itemlista();
		
		Integer idListaInt = lista.getIdlista();
		
		ItemDAO daoI = new ItemDAO();		
		Item item = montaItem();
		daoI.gravar(item);	//gravar item para gerar id
		try {
			item = (Item) daoI.carregar(nomeItemSt);		} 
		catch (SQLException e) {
			e.printStackTrace();		}
		Integer idItemInt = item.getIdItem();
		
		Date hoje = new Date();
		java.sql.Date dataDt = new java.sql.Date(hoje.getYear(), hoje.getMonth(), hoje.getDay()+14); 		
		
		itemLista.setQtd(3);
		itemLista.setValor(7.0);
		itemLista.setData(dataDt);
		System.out.println("hoje = "+itemLista.getData().toString());
		int resultado = (Integer) dao.gravar(idListaInt, idItemInt, itemLista.getValor(), itemLista.getQtd(), dataDt);
		
//		assertEquals(descricaoSt, itemGravado.getDescricao());
//		assertEquals(nomeItemSt, itemGravado.getNomeItem());
//		assertEquals (corSt, itemGravado.getCor());
	}
	
	public Item montaItemCompleto()
	{		
		Item item = new Item();	
		item.setNomeItem(nomeItemSt);
		item.setDescricao("descr test "+String.valueOf(new Date().getTime()));
		return item;
	}
	
	public Item montaItem()
	{		
		Item item = new Item();	
		item.setNomeItem(nomeItemSt);
		item.setDescricao("descr test "+String.valueOf(new Date().getTime()));
		
		return item;
	}

}
