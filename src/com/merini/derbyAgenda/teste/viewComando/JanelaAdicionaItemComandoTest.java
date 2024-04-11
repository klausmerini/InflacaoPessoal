package com.merini.derbyAgenda.teste.viewComando;

import org.junit.Test;

import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;

public class JanelaAdicionaItemComandoTest 
{
	ComandoIncluirItem comando;
	String nomeLista = "Gaveta 1";
	
	@Test
	public void ComandoIncluirItemViewTest()
	{
		comando = new ComandoIncluirItem();
		comando.processaComando("constroi interface adiciona item",nomeLista );
		try {
			Thread.sleep(10000);	} 
		catch (InterruptedException e) {	e.printStackTrace();	}
	}

}
