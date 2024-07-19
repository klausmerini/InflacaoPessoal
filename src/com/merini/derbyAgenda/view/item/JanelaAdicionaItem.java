package com.merini.derbyAgenda.view.item;

import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
//import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.merini.derbyAgenda.comando.item.ComandoCalculaInflacao;
import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;
import com.merini.derbyAgenda.comando.lista.ComandoExibeListas;
import com.merini.derbyAgenda.comando.lista.ComandoIncluirLista;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.view.JanelaCrud;

import net.sf.nachocalendar.components.DateField;



public class JanelaAdicionaItem extends JanelaCrud implements  ActionListener
{
	int nlinhas = 10;
	
	private boolean janelaEdicao = false;	
	Item itemEmEdicao= new Item();
	
	Comentario c = new Comentario();
	
	private TextField nomeItemTextField = new TextField();
	private TextField qtdTextField = new TextField();
	private TextField valorTextField = new TextField();
	private TextField corTextField = new TextField();
	private TextField descricaoTextField = new TextField();
	private TextField lugarTextField = new TextField();	
	private DateField nachoDateField;

	private JComboBox<String> comboListas=new JComboBox();
	private JComboBox<String> comboTipoLista;
	
	private static String listasDaCombo[] ;//= {"Atividade F�sica", "Casa", "Comercial", "Entretenimento",		"Estudo", "Pessoal", "Refei��o", "Trabalho"};
	private String nomeListaDoItemSt="";
	
	private JButton adicalistaButton = new JButton("Adicionar lista");
	private JButton salvarButton = new JButton("salvar");
	private JButton calcularInflacaoButton = new JButton("Calcula Inflação 1 mês");
	private JButton calcularInflacao3mButton = new JButton("Calcula Inflação 3 meses");
	
	
	public JanelaAdicionaItem(String nome, String[] nomeListasSt,String  nomeListaDoItem) 
	{
		super(nome);
		listasDaCombo = nomeListasSt;
		nomeListaDoItemSt = nomeListaDoItem;
		
		configuraJanela();
		montaComboListas();
		constroiInterface() ;
		
		exibeFrame();			
	}	
	
	public JanelaAdicionaItem(String nome, Item item, String[] nomeListasSt) 
	{	
		super(nome);	
		janelaEdicao =true;
		itemEmEdicao=item;
		listasDaCombo = nomeListasSt;
	
		configuraJanela();
		montaComboListas();
		constroiInterface() ;	
		preencheCampos(item);
		exibeFrame();			
	}	

	public void actionPerformed(ActionEvent e) 
	{		
		Item itemCriado =  montaItem();
		Integer qtd=0;
		if(!qtdTextField.getText().equals("")) {
			qtd = Integer.valueOf(qtdTextField.getText());}
		Double valor=0.0;
		try {
			valor = Double.valueOf(valorTextField.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    java.util.Date diaDate = (java.util.Date)nachoDateField.getValue();		
		
	    if (e.getSource().equals(salvarButton))
		{
			c.comentaLocalizacao("actionPerformed");
				
			if (janelaEdicao) 
			{
		//		ComandoEditarItem comando = cp.getComandoEditarItem();
			//	comando.processaComando("Persiste altera��o do item no banco de dados", i);
			}
			else
			{
				ComandoIncluirItem comando = new ComandoIncluirItem();
					c.comentaIteracaoView(itemCriado.getNomeItem());
					c.comentaIteracaoView(itemCriado.getDescricao());
					c.comentaIteracaoView(String.valueOf(valor));
					c.comentaIteracaoView(String.valueOf(diaDate));
				comando.processaComando("inclui item no banco de dados", itemCriado,comboListas.getSelectedItem().toString(), valor, qtd, diaDate);	
				this.dispose();
				ComandoExibeListas comando2 = new ComandoExibeListas();
				comando2.processaComando("Exibe Lista selecionada", comboListas.getSelectedItem().toString());	
			}
		}		
		if (e.getSource().equals(adicalistaButton))
		{
				c.comentaLocalizacao("actionPerformed");
			ComandoIncluirLista  comando = new ComandoIncluirLista();
			this.dispose();
			comando.processaComando("Constroi interface inclui lista");		
		}
		if (e.getSource().equals(calcularInflacaoButton))
		{
				c.comentaLocalizacao("actionPerformed");
			ComandoCalculaInflacao comando = new ComandoCalculaInflacao();
			comando.processaComando("Calcula inflação 1 mês do produto",itemCriado.getNomeItem(),"Um mês" );		
		}	
		if (e.getSource().equals(calcularInflacao3mButton))
		{
				c.comentaLocalizacao("actionPerformed");
			ComandoCalculaInflacao comando = new ComandoCalculaInflacao();
			comando.processaComando("Calcula inflação 1 mês do produto",itemCriado.getNomeItem(),"3 meses" );		
		}	
	}		

	public void configuraJanela() {
		// TODO Auto-generated method stub
		this.configuraInterface(nlinhas, 2);	
		this.setSizeCrud(400,400);	
		this.setLocation(730, 10);
	}

	public void constroiInterface() 
	{
			c.comentaLocalizacao("constroiInterface");
		ArrayList<String> labels = new ArrayList<String>();
		setaNachoDateField();
		
		labels.add("nome");
		labels.add("cor");
		labels.add("descrição");
		labels.add("lugar");
		labels.add("valor");
		labels.add("qtd");
		labels.add("lista");
		labels.add("data");
		
		this.add(new JLabel(labels.get(0) ));
		this.add(nomeItemTextField);
		
		this.add(new JLabel(labels.get(1) ));
		this.add(corTextField);
		
		this.add(new JLabel(labels.get(2) ));
		this.add(descricaoTextField);
		
		this.add(new JLabel(labels.get(3) ));
		this.add(lugarTextField);
		
		this.add(new JLabel(labels.get(4) ));
		this.add(valorTextField);
		
		this.add(new JLabel(labels.get(5) ));
		this.add(qtdTextField);
		
		this.add(new JLabel(labels.get(6) ));
		this.add(nachoDateField);
		
		this.add(new JLabel(labels.get(7) ));
		this.add(comboListas);
		
		this.add(salvarButton);
		this.add(adicalistaButton);
		this.add(calcularInflacaoButton);
		this.add(calcularInflacao3mButton);
	}		

	public void exibeFrame() 
	{		// TODO Auto-generated method stub
		salvarButton.addActionListener(this);
		adicalistaButton.addActionListener(this);
		calcularInflacaoButton.addActionListener(this);
		calcularInflacao3mButton.addActionListener(this);
		this.setVisible(true);		
	}

	public void montaComboListas()
	{
		comboListas = new JComboBox<String>(listasDaCombo);
		setaComboLista();		
	}	
	
	public Item montaItem()
	{
		itemEmEdicao.setNomeItem(nomeItemTextField.getText());
		itemEmEdicao.setCor(corTextField.getText());
		itemEmEdicao.setDescricao(descricaoTextField.getText());
		itemEmEdicao.setLugar(lugarTextField.getText());		
		
		return itemEmEdicao;
	}		

	public void preencheCampos(Item item)
	{
		nomeItemTextField.setText(item.getNomeItem());
		descricaoTextField.setText(item.getDescricao());
		lugarTextField.setText(item.getLugar().toString());
	//	classificacaoTextField.setText(pend.getIdclassificacao().getNomeclassificacao());
		corTextField.setText(item.getCor());
		
		verificaESetaListaSelecionada();
	}

	public void setaComboLista()
	{
		int indexComboLista=0;
		String nomeListaOriginal= nomeListaDoItemSt;
		c.comentaValor("nomeListaDoItemSt", nomeListaDoItemSt);
		for (int i = 0; i < listasDaCombo.length; i++) {
			comboListas.setSelectedIndex(i);
			String listaIterada= (String) comboListas.getSelectedItem();
			c.comentaValor("lista Iterada", listaIterada);
			if(listaIterada.trim().equals(nomeListaOriginal.trim()))
			{
				indexComboLista=i;
			}
		}
		c.comentaValor("indexComboClassif", String.valueOf(indexComboLista));
		comboListas.setSelectedIndex(indexComboLista);
	}
	

    public void setaNachoDateField()
    {
        DateFormat df = DateFormat.getDateInstance(2);
        java.util.Date dia = new java.util.Date();
        nachoDateField = new DateField();
        nachoDateField.setDateFormat(df);
        nachoDateField.setValue(dia);
    }


	public void verificaESetaListaSelecionada()
	{		//Recupera id do item recebido pela tela d eedi��o
//		int idItemOriginal= itemEmEdicao.getIdItem();
//		ArrayList<Itemlista> il = FacadeImplementado.facadeItemLista.recuperaPorIdItem(idItemOriginal);	//atravez do facade pega o itemLista do item
//	//	c.comentaValor("nomeClassifOriginal", nomeClassifOriginal);
//		String nomeListaSt =  il.get(0).getIdlista().getNomelista();	//Pega o nome da lista do item no objeto ItemLista, para colocar na combo
//		int indexComboLista=0;
//		
//		for (int i = 0; i < listasDaCombo.length; i++) {
//			comboListas.setSelectedIndex(i);
//			String classifIterada= (String) comboListas.getSelectedItem();
//			c.comentaValor("classifica��o Iterada", classifIterada);
//			if(classifIterada.trim().equals(nomeListaSt.trim()))
//			{
//				indexComboLista=i;
//			}
//		}
//		c.comentaValor("indexComboLista", String.valueOf(indexComboLista));
//		comboListas.setSelectedIndex(indexComboLista);
	}	
}