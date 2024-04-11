package com.merini.derbyAgenda.teste.item.dao;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;

public class CT2RecuperarNomesItensDAOTest 
{	
	@Test
	public void RecuperarNomesItensTest ()
	{
		ItemDAO dao = new ItemDAO();
		ArrayList resultSet;
		
		resultSet =(ArrayList) dao.obterTodosNomes();
		
		assertEquals("Pagina - 1709213882476", resultSet.get(0));
		assertEquals("Pagina - 1709998773625", resultSet.get(4));		
	}
}
