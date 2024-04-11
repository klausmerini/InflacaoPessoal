package com.merini.derbyAgenda.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.merini.derbyAgenda.comando.ComandoExcluirClassificacao;
import com.merini.derbyAgenda.comando.ComandoGerenciaClassificacao;
import com.merini.derbyAgenda.comando.ComandoIncluirClassificacao;
import com.merini.derbyAgenda.comando.ComandoPrincipal;
import com.merini.derbyAgenda.modelo.Comentario;

//import controle.ComandoPrincipal;
//import controle.agenda.ComandoGerenciaAgendas;
//import controle.agenda.ComandoIncluirAgenda;
//import controle.agenda.ComandoListaAgendas;
//import controle.classificacao.ComandoExcluirClassificacao;
//import controle.classificacao.ComandoGerenciaClassificacao;
//import controle.classificacao.ComandoIncluirClassificacao;
//import controle.pendencia.ComandoGerenciaPendencia;
//import entities.Comentario;
//import view.InterfaceJanelaCrud;
//import view.JanelaCrud;

public class JanelaGerenciaClassificacao implements  ActionListener
{
	private int nLinhas=2;
						
	private JButton adicClassificacaoJButton = new JButton("Adicionar Classifica��o");
	private JButton excluiClassificacaosJButton = new JButton("Exclui Classifica��o");
	private JButton editarClassificacaoJButton = new JButton("Editar Classificacao");
	
	static JanelaCrud frame ;
	Comentario c = new Comentario();
	ArrayList<String> nomesAgArray;
	
	public JanelaGerenciaClassificacao(ArrayList<String> nomesAgArray)
	{
		frame = new JanelaCrud("Gerencia Classifica��es");	
		this.nomesAgArray=nomesAgArray;
		
		configuraJanela();
		constroiInterface();		
	}	
	
	public void actionPerformed(ActionEvent e) 
	{	// TODO Auto-generated method stub	
		
		String opcao = frame.recuperaValorSelecionadoNoRadioButton();
		
		if (e.getSource().equals(excluiClassificacaosJButton))
		{			
			ComandoExcluirClassificacao comando = new ComandoExcluirClassificacao();
			comando.processaComando("Excluir classifica��o", frame.recuperaValorSelecionadoNoRadioButton());
			frame.dispose();
			
			ComandoGerenciaClassificacao comandoNovaJanela = new ComandoGerenciaClassificacao();
			comandoNovaJanela.processaComando("Cria Janela Gerencia Classificacao");
		}
		
		if (e.getSource().equals(adicClassificacaoJButton))
		{
			ComandoIncluirClassificacao comando = new ComandoIncluirClassificacao();
			comando.processaComando("Cria Janela Inclui Classificacao");
						
			frame.dispose();
			
			ComandoGerenciaClassificacao comandoNovaJanela = new ComandoGerenciaClassificacao();
			comando.processaComando("Cria Janela Gerencia Classificacao");
		}		
			
		if (e.getSource().equals(editarClassificacaoJButton))
		{
			c.comentaLocalizacao("actionPerformed", opcao);
//			ComandoGerenciaPendencia comando = new ComandoGerenciaPendencia();
//			comando.processaComando("constroi interface gerencia pendencia", opcao);//			
		}

	}

	public static void setFrame(JanelaCrud frame) {
		JanelaGerenciaClassificacao.frame = frame;
	}

	public void configuraJanela() {
		frame.configuraInterface(nLinhas, 2);
		frame.setLocation(1,590);
		frame.setSizeCrud(500, 150);
		
		adicClassificacaoJButton.addActionListener(this);
		excluiClassificacaosJButton.addActionListener(this);
		editarClassificacaoJButton.addActionListener(this);
	}

	public void constroiInterface() {
		JPanel peinelCentral = new JPanel();
		frame.constroiInterfaceSelecionaRadioButton(nomesAgArray, peinelCentral);
		//delegar para essa classe o controle e repassa para as classes de controle		
		
		JPanel peinelInferior = new JPanel();
		peinelInferior.add(adicClassificacaoJButton);
		peinelInferior.add(excluiClassificacaosJButton);	
		peinelInferior.add(editarClassificacaoJButton);
		
		frame.add(peinelCentral);
		frame.add(peinelInferior);
		frame.setVisible(true);	
	}
	
	public JanelaCrud getFrame() {
		// TODO Auto-generated method stub
		return null;
	}	
	
//	@Override
//	public void exibeFrame() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public JPanel montaBotoes() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//

}
