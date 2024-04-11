package com.merini.derbyAgenda.comando;

import java.util.ArrayList;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.view.JanelaGerenciaClassificacao;


public class ComandoGerenciaClassificacao 
{
	String comandoConstroiInterfaceGerenciaClassificacoesString = "Constr�i interface Gerencia classifica��o";
	public JanelaGerenciaClassificacao janelaGerenciaClassificacao;	
	Comentario c = new Comentario();

	public void processaComando(String comandoSt) 
	{	
			c.comentaLocalizCamadaControle("processaComando", this.getClass().getName(), comandoSt);
		ClassificacaoDAO dao = new ClassificacaoDAO();	
		ArrayList nomesClArray = (ArrayList) dao.obterTodosNomes();
		if (comandoSt.equals("Cria Janela Gerencia Classificacao"))
		{		
			JanelaGerenciaClassificacao janela = new JanelaGerenciaClassificacao(nomesClArray);
				c.comentaLocalizacao("comando.processaComando", comandoSt);
			this.setJanelaGerenciaClassificacao( janela);
		}
		else
		{
			System.out.println("          ___________COMANDO ERRADO !!!!!");
		}
	}

	public JanelaGerenciaClassificacao getJanelaGerenciaClassificacao() {
		return janelaGerenciaClassificacao;
	}


	public void setJanelaGerenciaClassificacao(JanelaGerenciaClassificacao janelaGerenciaClassificacao) {
		this.janelaGerenciaClassificacao = janelaGerenciaClassificacao;
	}
	
	public void verificaJanela()
	{
		try {
			this.getJanelaGerenciaClassificacao().getFrame().dispose();
		} catch (Exception e1) {
			c.comentaLocalizacao(" nenhuma janela berta para fechar ");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}	
}
