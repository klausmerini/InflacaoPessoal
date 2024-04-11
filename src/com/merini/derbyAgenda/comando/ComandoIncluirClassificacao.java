package com.merini.derbyAgenda.comando;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.view.JanelaIncluirClassificacao;

//import controle.AbstractCommand;
//import controle.ComandoPrincipal;
//import view.classificacao.JanelaIncluirClassificacao;

public class ComandoIncluirClassificacao //implements AbstractCommand 
{
//	private static String nomeAgendaSelecionadaSt=null;
	public com.merini.derbyAgenda.view.JanelaIncluirClassificacao janelaInlcuirClassificacao;
	Comentario c = new Comentario();

	public void processaComando(String comando, Classificacao classificacao) 
	{		// TODO Auto-generated method stub
//		ComandoPrincipal cp = ComandoPrincipal.getInstance();
//		nomeAgendaSelecionadaSt = AbstractCommand.recuperaNomeAgendaNoCP();		
//		classificacao.setAgenda(facadeAg.recuperaPorNome(nomeAgendaSelecionadaSt));		
		if (comando.equals("Incluir Classificao")) 
		{
			ClassificacaoDAO daoCl = new ClassificacaoDAO();
			daoCl .gravar(classificacao);
			reabreJanelaClassificaaco();
		} 
		else 
		{
			System.out.println("Comando ERRAAdo");
		}
	}

	private void reabreJanelaClassificaaco() 
	{
		ComandoGerenciaClassificacao comando = new ComandoGerenciaClassificacao();
		System.out.println("main");
		comando.processaComando("Cria Janela Gerencia Classificacao");
	}

	public void processaComando(String comando) 
	{		
		if (comando.equals("Cria Janela Inclui Classificacao")) 
		{
			c.comentaLocalizacao("processaComando()", comando);
			janelaInlcuirClassificacao = new JanelaIncluirClassificacao();				
		} 
		else 
		{
			System.out.println("Coamando errado");
		}
	}
}
