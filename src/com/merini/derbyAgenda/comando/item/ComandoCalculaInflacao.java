package com.merini.derbyAgenda.comando.item;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.merini.derbyAgenda.dao.ItemlistaDAO;
import com.merini.derbyAgenda.modelo.Comentario;

public class ComandoCalculaInflacao 
{
	Comentario c = new Comentario();
		
	public void processaComando(String comando, String nomeItem, String periodo) 
	{
		ItemlistaDAO dao = new ItemlistaDAO();
		String sql = "SELECT valor, data FROM itemlista, item WHERE itemlista.iditem = item.iditem AND item.nomeitem = '"+nomeItem+"'";
			//Separa valores do mes corrente,
		Date hoje = new Date();
		Integer mesCorrente=hoje.getMonth();
		Integer mesPassado=null;
		if (periodo.equals("Um mês") ) {
			mesPassado=mesCorrente-1;
		} else if (periodo.equals("3 meses")) {
			mesPassado=mesCorrente-3;
		}
		
		ArrayList<Integer> mes=null;
		
		HashMap<java.sql.Date, Double> dataValor = dao.obterDataEValorPorItem(nomeItem);
		ArrayList<java.sql.Date> valoresMesCorrenteRecuperado = new ArrayList<java.sql.Date>();
		for(java.sql.Date key : dataValor.keySet())
		{
			System.out.println(key+" : "+dataValor.get(key));
			if (Integer.valueOf(key.getMonth()).equals(mesCorrente))  
			{
				valoresMesCorrenteRecuperado.add(key);
			}
		}
			// e do mes passado
		ArrayList<java.sql.Date> valoresMesPssadoRecuperado = new ArrayList<java.sql.Date>();
		for(java.sql.Date key : dataValor.keySet())
		{
			System.out.println(key+" : "+dataValor.get(key));
			if (Integer.valueOf(key.getMonth()).equals(mesPassado))  
			{
				valoresMesPssadoRecuperado.add(key);
			}
		}		
			//Pega primeiro valor de cada mes
		java.sql.Date dataPrimeiraMesCorrente = valoresMesCorrenteRecuperado.get(0);
		for (java.sql.Date date : valoresMesCorrenteRecuperado) 		{
			if (date.compareTo(dataPrimeiraMesCorrente) < 0) {
				dataPrimeiraMesCorrente = date;
			}
		}		
		java.sql.Date dataPrimeiraMesPassado = valoresMesPssadoRecuperado.get(0);
		for (java.sql.Date date : valoresMesPssadoRecuperado) 		{
			if (date.compareTo(dataPrimeiraMesPassado) < 0) {
				dataPrimeiraMesPassado = date;
			}
		}
			//Pega valores das datas separadas e faz a porcentagem 
			c.comentaValor("dataPrimeiraMesCorrente", dataPrimeiraMesCorrente.toString());
			c.comentaValor("valor", dataValor.get(dataPrimeiraMesCorrente).toString());
			c.comentaValor("dataPrimeiraMesPassado", dataPrimeiraMesPassado.toString());
			c.comentaValor("valor", dataValor.get(dataPrimeiraMesPassado).toString());
		Double primeioValoMesPassado = dataValor.get(dataPrimeiraMesPassado);
		Double primeioValoMesCorrente = dataValor.get(dataPrimeiraMesCorrente);		
		Double aumento = primeioValoMesCorrente - primeioValoMesPassado ;
		Double porcentagem ;
		porcentagem = (100 * aumento)/primeioValoMesPassado;
		
		JOptionPane.showMessageDialog(null, "A inflação do "+nomeItem+" do mês "+String.valueOf(mesPassado+1)+" para o mês "+String.valueOf(mesCorrente+1)+" foi de : "+String.valueOf(porcentagem)+"%");		
	}
}
