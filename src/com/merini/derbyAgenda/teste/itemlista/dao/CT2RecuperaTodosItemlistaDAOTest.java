package com.merini.derbyAgenda.teste.itemlista.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemlistaDAO;

public class CT2RecuperaTodosItemlistaDAOTest 
{

	@Test
	public void RecuperarNomesItensTest ()
	{
		ItemlistaDAO dao = new ItemlistaDAO();
		String name="Gaveta 1";
		ArrayList resultSet;
		
		resultSet =(ArrayList) dao.obterTodosItemlistaPorNomeLista(name);
//		
//		assertEquals("Pagina - 1709213882476", resultSet.get(0));
//		assertEquals("Pagina - 1709998773625", resultSet.get(4));
		
	}

}
