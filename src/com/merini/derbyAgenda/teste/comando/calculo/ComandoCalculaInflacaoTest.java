package com.merini.derbyAgenda.teste.comando.calculo;

import org.junit.Test;

import com.merini.derbyAgenda.comando.item.ComandoCalculaInflacao;
import com.merini.derbyAgenda.comando.lista.ComandoIncluirLista;

public class ComandoCalculaInflacaoTest 
{
	
	private ComandoCalculaInflacao comando;
	private String nomeItem="";


	@Test
	public void comandoCalculaInflacaoUmMesTest()
	{
		comando = new ComandoCalculaInflacao();
		comando.processaComando("Calcula inflação 1 mês do produto",nomeItem,"Um mês" );
	}

}
