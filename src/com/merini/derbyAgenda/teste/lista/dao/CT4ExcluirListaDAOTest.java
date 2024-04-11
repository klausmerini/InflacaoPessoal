package com.merini.derbyAgenda.teste.lista.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Lista;

public class CT4ExcluirListaDAOTest 
{

	@Test
	public void ExcluirItemTest ()
	{
		ListaDAO dao = new ListaDAO();
		Lista lista = new Lista();		
		lista.setNomelista("Pagina - "+geraNumeroAleatorio());
		lista.setDescrlista("Pão de forma");
		
		dao.gravar(lista);
		dao.obterTodosNomes();
		int resultado = dao.excluir(lista);
		dao.obterTodosNomes();
		assertEquals(1, resultado);
	}

	private String geraNumeroAleatorio() {	
		Date date = new Date();
		String horaSt= String.valueOf(date.getTime());
		return horaSt;		
	}
	

}
