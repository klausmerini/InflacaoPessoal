package com.merini.derbyAgenda.teste.item.dao;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.modelo.Item;

public class CT3EditarItemDAOTest 
{

	String descricaoSt="descrição editada "+geraNumeroAleatorio();	
	String nomeItemSt = "Pagina - 1709213910458";
	
	@Test
	public void editarItemTest()
	{
	ItemDAO dao = new ItemDAO();	
	System.out.println("carregar "+nomeItemSt);

	Item item = (Item) dao.carregar(nomeItemSt);			
	item.setDescricao(descricaoSt);

	dao.editar(item);
	
	
	Item itemEditada = (Item) dao.carregar(item.getNomeItem());
	assertEquals(descricaoSt, itemEditada.getDescricao());
}	

private String geraNumeroAleatorio() {	
	Date date = new Date();
	String horaSt= String.valueOf(date.getTime());
	return horaSt;		
}

}
