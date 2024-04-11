package com.merini.derbyAgenda.comando;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;

public class ComandoExcluirClassificacao  {

	public void processaComando(String comando, String nomeClassificacao) 
	{		// TODO Auto-generated method stub
		if (comando.equals("Excluir classifica��o")) 
		{
			ClassificacaoDAO dao = new ClassificacaoDAO();
			Classificacao classificacao= new Classificacao();
			classificacao = (Classificacao) dao.carregar(nomeClassificacao);
			dao.excluir(classificacao.getNomeclassificacao());
		} 
		else 
		{
			System.out.println("   !!!! COMANDO ERRADO");
		}
	}
//	
//	public void atualizaFrame()
//	{
//		Comandos.comandoIncluirClassificacao.janelaInlcuirClassificacao.
//	}

}
