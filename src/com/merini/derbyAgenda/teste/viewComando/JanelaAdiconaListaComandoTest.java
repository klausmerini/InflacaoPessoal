package com.merini.derbyAgenda.teste.viewComando;

import org.junit.Test;

import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;
import com.merini.derbyAgenda.comando.lista.ComandoIncluirLista;

public class JanelaAdiconaListaComandoTest 
{
	ComandoIncluirLista comando;
	String nomeLista = "Gaveta 1";
	
	@Test
	public void ComandoIncluirItemViewTest()
	{
		comando = new ComandoIncluirLista();
		comando.processaComando( "Constroi interface inclui lista");
		try {
			Thread.sleep(10000);	} 
		catch (InterruptedException e) {	e.printStackTrace();	}
	}


}
