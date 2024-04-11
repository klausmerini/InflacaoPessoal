

package com.merini.derbyAgenda.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import com.merini.derbyAgenda.modelo.Comentario;


//import commands.listar.ComandoListarPendencia;

public class JanelaCrud extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private com.merini.derbyAgenda.modelo.Comentario c = new Comentario();
	String nome;
	int nCampos;

	private ArrayList<JRadioButton> arrayBotoes;
	private JList<String> lista = null ;
	
	public JanelaCrud(String nome)
	{
		this.nome=nome;	
		this.setTitle(nome);
	}
	
	public void configuraInterface(int nLinhas, int nColunas)
	{
		c.comentaLocalizCamadaView("configuraInterface", "JanelaCrud","");
		nCampos = nLinhas;
		GridLayout gLayout = new GridLayout(nCampos , nColunas);
		this.setLayout(gLayout);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 		
	}
	
	public void setSizeCrud(int largura,int Altura )
	{
		this.setSize(largura, Altura);
	}	
	
//	public void constroiInterface(int nLinhas, int qtdNomesIterados, JButton selecionarIt, int nCol) 
//	{	// TODO Auto-generated method stub
//		configuraInterface(nLinhas, 2);	
//		int qtdLinhas = qtdNomesIterados+1;
//		configuraInterface(qtdLinhas,nCol);	
//		
//		System.out.println("		.quantos nomes \\ linhas ? "+qtdNomesIterados);	
//	
//		this.add(selecionarIt);
//		this.setVisible(true);	
//	}	
	
	public void constroiInterfaceAdiciona(int nLinhas, ArrayList<String> labelsSt,
			ArrayList<TextField> taxtFieldArray)
	{		
		int nLinha=labelsSt.size()+1;
		this.configuraInterface(nLinha, 2);	
		
		for (int i=0; i<labelsSt.size() ; i++)
		{
			System.out.println("			.itera��o : "+i+"; palavra iterada : "+labelsSt.get(i));
			System.out.println("			.itera��o : "+i+"; taxtField iterada : "+taxtFieldArray.get(i).getName());
			this.add(new JLabel(labelsSt.get(i) ));
			this.add(taxtFieldArray.get(i));			
		}
		
	}
	
	public void constroiInterfaceSeleciona(int nLinha, String label,
			TextField taxtField)
	{		
		this.configuraInterface(nLinha, 2);	
		
		System.out.println("			. palavra recebida : "+label);
		this.add(new JLabel(label ));
		this.add(taxtField);			
		
	}
	

	public  JList<String> constroiInterfaceSelecionaList( String[] arrayNomes)
	{
		lista = new JList<String>(arrayNomes);
	
		this.add (new JScrollPane(lista));	
		return lista;
		
	}

	public void constroiInterfaceSelecionaRadioButton( ArrayList<String> arrayNomes)
	{
		arrayBotoes = new ArrayList<JRadioButton>();
		ButtonGroup grupoDeBotoesNomes = new ButtonGroup();
		c.comentaLocalizacao("JanelaCrud");
		int qtdNomes = arrayNomes.size();
			
			for(int i=0; i<qtdNomes; i++)
			{
				arrayBotoes.add(new JRadioButton());
//				System.out.println("  arrayBotoes.size() - "+arrayBotoes.size()+", index - "+i+",comando.getNomes().size() "+qtdNomes);
			}			
			
			for (int i2=0; i2<arrayBotoes.size(); i2++)
			{
	//			System.out.println(" adiciona bot�o "+i2);
				arrayBotoes.get(i2).setLabel(arrayNomes.get(i2));
				c.comentaIteracao("comando.getNomes().get(i2) - ", arrayNomes.get(i2));
				grupoDeBotoesNomes.add(arrayBotoes.get(i2));
				this.add(arrayBotoes.get(i2));
			}			
		
	}
	
	public void constroiInterfaceSelecionaRadioButton( ArrayList<String> arrayNomes, JPanel panel)
	{
		arrayBotoes = new ArrayList<JRadioButton>();
		ButtonGroup grupoDeBotoesNomes = new ButtonGroup();
		c.comentaLocalizacao("JanelaCrud");
		int qtdNomes = arrayNomes.size();
			
			for(int i=0; i<qtdNomes; i++)
			{
				arrayBotoes.add(new JRadioButton());
//				System.out.println("  arrayBotoes.size() - "+arrayBotoes.size()+", index - "+i+",comando.getNomes().size() "+qtdNomes);
			}			
			
			for (int i2=0; i2<arrayBotoes.size(); i2++)
			{
	//			System.out.println(" adiciona bot�o "+i2);
				arrayBotoes.get(i2).setLabel(arrayNomes.get(i2));
				c.comentaIteracao("comando.getNomes().get(i2) - ", arrayNomes.get(i2));
				grupoDeBotoesNomes.add(arrayBotoes.get(i2));
				panel.add(arrayBotoes.get(i2));
			}			
		this.add(panel);
	}
	
	public JPanel constroiInterfaceSelecionaRadioButton1( ArrayList<String> arrayNomes, JPanel panel)
	{
		arrayBotoes = new ArrayList<JRadioButton>();
		ButtonGroup grupoDeBotoesNomes = new ButtonGroup();
		c.comentaLocalizacao("JanelaCrud.constroiInterfaceSelecionaRadioButton1");
		int qtdNomes = arrayNomes.size();
			
			for(int i=0; i<qtdNomes; i++)
			{
				arrayBotoes.add(new JRadioButton());
//				System.out.println("  arrayBotoes.size() - "+arrayBotoes.size()+", index - "+i+",comando.getNomes().size() "+qtdNomes);
			}			
			
			for (int i2=0; i2<arrayBotoes.size(); i2++)
			{
	//			System.out.println(" adiciona bot�o "+i2);
				arrayBotoes.get(i2).setLabel(arrayNomes.get(i2));
				c.comentaIteracao("comando.getNomes().get(i2) - ", arrayNomes.get(i2));
				grupoDeBotoesNomes.add(arrayBotoes.get(i2));
				panel.add(arrayBotoes.get(i2));
			}			
	//	this.add(panel);
		return panel;
	}
	

	public String nomeOpcaoSelecionada()
	{
		JRadioButton buttonIt = new JRadioButton();
		String nomeFicharioSelecionado=null;
		c.comentaLocalizacao("nomeOpcaoSelecionada - num de op��es : ", String.valueOf(arrayBotoes.size()));
		for (int i=0; i<arrayBotoes.size();i++)
		{
			buttonIt = arrayBotoes.get(i);
			c.comentaIteracao(buttonIt.getLabel());
			if(buttonIt.isSelected())
			{
				System.out.println(" - selecionado");
				nomeFicharioSelecionado = buttonIt.getLabel();
				break;
			}			
		}
		
		return nomeFicharioSelecionado;
	}
	
	
	public String recuperaValorSelecionadoNoRadioButton()
	{
		c.comentaLocalizacao("recuperaValorSelecionadoNoRadioButton","");
		JRadioButton botaoIt = new JRadioButton();
		ArrayList<JRadioButton> arrayBotoesIt = getArrayBotoes();
		System.out.println("		.bot�es recuperados : "+arrayBotoesIt.size());
		String opcaoSelecionada="";
		
		for (int i=0;i<arrayBotoesIt.size();  i++)
		{//ITERA TODOS OS BOTO�ES
			botaoIt=(JRadioButton)arrayBotoesIt.get(i);
			c.comentaValor("op��o radioButton iterado", botaoIt.getLabel());
			if (botaoIt.isSelected())//acha o selecionado
			{	//salva o valor na vari�vel
				opcaoSelecionada=botaoIt.getLabel().toString();
				System.out.println("			.op��o selecionada : "+opcaoSelecionada);
			}
		
		
			//	if (botaoIt.getLabel().toString().equals("Seleciona Pendencia Por Prioridade"))
	//		System.out.println(super.getClass());
		}
		
		
		return opcaoSelecionada;
	}
	
	public int getnCampos() 
	{
		return nCampos;
	}
	public void setnCampos(int nCampos) {
		this.nCampos = nCampos;
	}

	public ArrayList<JRadioButton> getArrayBotoes() {
		return arrayBotoes;
	}

	public void setArrayBotoes(ArrayList<JRadioButton> arrayBotoes) {
		this.arrayBotoes = arrayBotoes;
	}

	public String[] getLista() {
		
//		int[] itemns = lista.getSelectedIndices();
		ArrayList<String> itensSt =(ArrayList<String>)lista.getSelectedValuesList();
		String[] listaSt = new String[itensSt.size()];
		c.comentaLocalizacao("getLista");
		for (int i = 0; i< itensSt.size(); i++)
		{
			listaSt[i]=String.valueOf(itensSt.get(i));
			c.comentaIteracao(listaSt[i]);		
		}
		
		return listaSt;
	}

	public void setLista(JList<String> lista) {
		this.lista = lista;
	}

	public Comentario getC() {
		return c;
	}

	public void setC(Comentario c) {
		this.c = c;
	}
	
}
