package com.merini.derbyAgenda.comando;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;
import com.merini.derbyAgenda.comando.lista.ComandoIncluirLista;

public class ComandoPrincipal extends Comandos 
{
	public static void main(String[] args) 
	{
//		ComandoIncluirClassificacao comando = new ComandoIncluirClassificacao();
//			System.out.println("main");
//		comando.processaComando("Cria Janela Inclui Classificacao");
		
		ComandoIncluirItem comando;
		comando = new ComandoIncluirItem();
		comando.processaComando("constroi interface adiciona item","Caderno do Monstro");
	
//		comando = new ComandoIncluirLista();
//		comando.processaComando( "Constroi interface inclui lista");
		
	//	ComandoGerenciaClassificacao comando = new ComandoGerenciaClassificacao();
			System.out.println("main");
	//	comando.processaComando("Cria Janela Gerencia Classificacao");
		
		
	}

}
