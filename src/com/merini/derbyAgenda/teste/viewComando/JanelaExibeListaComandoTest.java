package com.merini.derbyAgenda.teste.viewComando;

import org.junit.Test;

import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;
import com.merini.derbyAgenda.comando.lista.ComandoExibeListas;

public class JanelaExibeListaComandoTest 
{
	ComandoExibeListas comando;
	String nomeLista = "Gaveta 1";
	
	@Test
	public void ComandoIncluirItemViewTest()
	{
		comando = new ComandoExibeListas();
		comando.processaComando("Exibe Lista selecionada",nomeLista );
		try {
			Thread.sleep(10000);	} 
		catch (InterruptedException e) {	e.printStackTrace();	}

}
}