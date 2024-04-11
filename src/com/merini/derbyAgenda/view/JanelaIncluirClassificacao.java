package com.merini.derbyAgenda.view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.merini.derbyAgenda.comando.ComandoIncluirClassificacao;
import com.merini.derbyAgenda.modelo.Classificacao;
import com.merini.derbyAgenda.modelo.Comentario;



public class JanelaIncluirClassificacao  implements  ActionListener
{
	private JButton salvar ;
	
	private TextField nomeClassificacaoTextField;
	private TextField cor;
	private TextField descricao;
	private TextField idAgenda;
	private Comentario c = new Comentario();
	
	JanelaCrud frame;
	private String nomeJanela = "Incluir Nova Classificacao";
	int nLinhas = 4;	
	
	public JanelaIncluirClassificacao() 
	{	// TODO Auto-generated constructor stub
		salvar = new JButton("Salvar");
		nomeClassificacaoTextField = new TextField();
		cor= new TextField();
		descricao = new TextField();		
		frame = new JanelaCrud(nomeJanela);
		
		configuraJanela(); 
		constroiInterface();		
	}
	
	public void actionPerformed(ActionEvent e) 
	{		
		if (e.getSource().equals(salvar))
		{	
			c.comentaLocalizacao("Action performed",nomeClassificacaoTextField.getText());					
			ComandoIncluirClassificacao comando = new ComandoIncluirClassificacao();				
			Classificacao classif = new Classificacao(nomeClassificacaoTextField.getText(), descricao.getText());				
			comando.processaComando("Incluir Classificao", classif);
			frame.dispose();				
			c.comentaValor("saindo do view action performed - Classificacao inclusa", classif.getNomeclassificacao());
		}
	}

	public void constroiInterface() 
	{	
		frame.add(new JLabel("Nome"));
		frame.add(nomeClassificacaoTextField );		
		frame.add(new JLabel("Cor"));
		frame.add(cor);		
		frame.add(new JLabel("Descri��o"));
		frame.add(descricao);		
		frame.add(salvar);			
		exibeFrame();
	}

	public void exibeFrame() 
	{		
		salvar.addActionListener(this);
		frame.setVisible(true);		
	}

	public void configuraJanela() 
	{
		frame.configuraInterface(nLinhas, 2);	
		frame.setSizeCrud(600,200);
		frame.setLocation(730, 260);
	}

	

}
