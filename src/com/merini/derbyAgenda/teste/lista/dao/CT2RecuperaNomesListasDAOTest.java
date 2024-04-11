package com.merini.derbyAgenda.teste.lista.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.dao.ListaDAO;

public class CT2RecuperaNomesListasDAOTest 
{
	
	@Test
	public void RecuperarNomesItensTest ()
	{
		ListaDAO dao = new ListaDAO();
		String name;
		ArrayList resultSet;
		
		resultSet =(ArrayList) dao.obterTodosNomes();
		
		assertEquals("Gaveta 1", resultSet.get(0));
		assertEquals("Gaveta 1 1712145546084", resultSet.get(1));
		
	}

}
