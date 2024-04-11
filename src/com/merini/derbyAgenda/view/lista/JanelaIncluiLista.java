package com.merini.derbyAgenda.view.lista;
//
//import static view.InterfaceJanelaCrud.c;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.merini.derbyAgenda.comando.lista.ComandoExibeListas;
import com.merini.derbyAgenda.comando.lista.ComandoIncluirLista;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.modelo.Lista;
import com.merini.derbyAgenda.view.JanelaCrud;


public class JanelaIncluiLista extends JanelaCrud implements ActionListener
{

	int nlinhas = 8;
	Comentario c = new Comentario();
	
	private TextField nomeListaTextField = new TextField();
	private TextField descricaoTextField = new TextField();
//	private TextField corTextField = new TextField();
//	private TextField lugarTextField = new TextField();
	
	private JComboBox<String> comboTipoLista;
	private String tipoDeListaSelecionada = "";	
	private static String padrao[] ;//= {"Atividade F�sica", "Casa", "Comercial", "Entretenimento",		"Estudo", "Pessoal", "Refei��o", "Trabalho"};
		
	private JButton salvarButton = new JButton("salvar");
	private JButton selecionaListaButton = new JButton("Seleciona Lista para Exibir");
//	private JButton adicalistaButton = new JButton("Adicionar � tipo de lista");
	
	public JanelaIncluiLista(String nome, String[] nomeListasSt) 
	{			// TODO Auto-generated constructor stub
		super(nome);
		padrao = nomeListasSt;
		
		configuraJanela();
		constroiInterface() ;		
		exibeFrame();			
	}	
	
	public void actionPerformed(ActionEvent e) 
	{		
			c.comentaLocalizacao("action Peformed");		
		Lista l =  montaLista();				
		if (e.getSource().equals(salvarButton))
		{
			c.comentaLocalizacao("actionPerformed",e.getSource().toString());
			ComandoIncluirLista comando = new ComandoIncluirLista();
			
			try {
				comando.processaComando("Incluir Lista no banco", l,comboTipoLista.getSelectedItem().toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		//		comando.processaComando("Incluir Lista no banco sem tipo lista", l);
			}		
		}		
//		if (e.getSource().equals(adicalistaButton))
//		{
//			c.comentaLocalizacao("actionPerformed");
//			ComandoIncluirItem comando = new ComandoIncluirItem();
//			comando.processaComando("Constr�i interface - Relaciona item a tipo");		
//		}
		if (e.getSource().equals(selecionaListaButton))
		{
			c.comentaLocalizacao("actionPerformed",e.getSource().toString());
			ComandoExibeListas comando = new ComandoExibeListas();
			comando.processaComando("Exibe Lista selecionada", comboTipoLista.getSelectedItem().toString());		
		}	
	}

	public void constroiInterface() 
	{		
			c.comentaLocalizacao("Constr�i Interface");
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("nome");
		labels.add("descrição");
		labels.add("Listas");		
		
		montaComboClassificacao();
		
		this.add(new JLabel(labels.get(0) ));
		this.add(nomeListaTextField);
		
		this.add(new JLabel(labels.get(1) ));
		this.add(descricaoTextField);
		
		this.add(new JLabel(labels.get(2) ));
		this.add(comboTipoLista);
				
		this.add(salvarButton);
		this.add(selecionaListaButton);

//		this.add(adicalistaButton);
	}	

	public void montaComboClassificacao()
	{
		comboTipoLista = new JComboBox<String>(padrao);		
	}	

	
	public Lista montaLista()
	{

		Lista l = new Lista();
		
		l.setNomelista(nomeListaTextField.getText());
	//	i.setCor(corTextField.getText());
		l.setDescrlista(descricaoTextField.getText());
		//i.setLugar(lugarTextField.getText());
		
		
		return l;
	}


	public void exibeFrame() 
	{		// TODO Auto-generated method stub
		salvarButton.addActionListener(this);
//		adicalistaButton.addActionListener(this);
		selecionaListaButton.addActionListener(this);
		this.setVisible(true);		
	}

	public void configuraJanela() {
		// TODO Auto-generated method stub
		this.configuraInterface(nlinhas, 2);
		this.setLocation(20, 10);
		this.setSizeCrud(400,400);		
	}

	public JanelaCrud getFrame() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
