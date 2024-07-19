package com.merini.derbyAgenda.teste.itemlista.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ItemlistaDAO;

public class CT3ObterDataEValorPorItemDAOTest 
{
	
	String nomeItem = "pao de forma";
	@Test
	public void obterDataEValorPorItemDAOTest ()
	{		
		ItemlistaDAO dao = new ItemlistaDAO();
		HashMap<Date, Double> map = dao.obterDataEValorPorItem(nomeItem);
		System.out.println("obterDataEValorPorItemDAOTest");
		for(Date key : map.keySet())
		{
			System.out.println(key+" : "+map.get(key));
		}
	}

}
