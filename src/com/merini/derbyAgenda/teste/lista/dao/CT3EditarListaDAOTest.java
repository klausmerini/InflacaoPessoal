package com.merini.derbyAgenda.teste.lista.dao;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Lista;

public class CT3EditarListaDAOTest 
{
	String descricaoSt="descrição editada "+geraNumeroAleatorio();	
	String nomeListaSt = "Gaveta 1";
	
	@Test
	public void editarListaTest()
	{
		ListaDAO dao = new ListaDAO();	
		System.out.println("carregar "+nomeListaSt);
	
	
		Lista lista = (Lista) dao.carregar(nomeListaSt);			
		lista.setDescrlista(descricaoSt);
	
		
		dao.editar(lista);
		
		Lista listaEditada = (Lista) dao.carregar(lista.getNomelista());
		assertEquals(descricaoSt, listaEditada.getDescrlista());
	}	

	private String geraNumeroAleatorio() {	
		Date date = new Date();
		String horaSt= String.valueOf(date.getTime());
		return horaSt;		
	}


}
