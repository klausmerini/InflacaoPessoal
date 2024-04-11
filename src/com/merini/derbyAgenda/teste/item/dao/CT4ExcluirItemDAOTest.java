package com.merini.derbyAgenda.teste.item.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.modelo.Item;

public class CT4ExcluirItemDAOTest 
{
	@Test
	public void ExcluirItemTest ()
	{
		ItemDAO dao = new ItemDAO();
		Item item = new Item();		
		item.setNomeItem("Pão de forma "+geraNumeroAleatorio());
		item.setDescricao("Pão de forma");
		item.setLugar("SUpermercado");
		
		dao.gravar(item);
		dao.obterTodosNomes();
		int resultado = dao.excluir(item);
		dao.obterTodosNomes();
		assertEquals(1, resultado);	//status code 2 indica o sucesso da operação
	}

	private String geraNumeroAleatorio() {	
		Date date = new Date();
		String horaSt= String.valueOf(date.getTime());
		return horaSt;		
	}
}
