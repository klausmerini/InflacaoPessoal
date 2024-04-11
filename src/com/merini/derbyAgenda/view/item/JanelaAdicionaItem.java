package com.merini.derbyAgenda.view.item;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;
import com.merini.derbyAgenda.comando.lista.ComandoExibeListas;
import com.merini.derbyAgenda.comando.lista.ComandoIncluirLista;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.view.JanelaCrud;



public class JanelaAdicionaItem extends JanelaCrud implements  ActionListener
{
	int nlinhas = 7;
	
	private boolean janelaEdicao = false;	
	Item itemEmEdicao= new Item();
	
	Comentario c = new Comentario();
	
	private TextField nomeItemTextField = new TextField();
	private TextField corTextField = new TextField();
	private TextField descricaoTextField = new TextField();
	private TextField lugarTextField = new TextField();	

	private JComboBox<String> comboListas=new JComboBox();
	private JComboBox<String> comboTipoLista;
	
	private static String listasDaCombo[] ;//= {"Atividade F�sica", "Casa", "Comercial", "Entretenimento",		"Estudo", "Pessoal", "Refei��o", "Trabalho"};
	private String nomeListaDoItemSt="";
	
	private JButton adicalistaButton = new JButton("Adicionar lista");
	private JButton salvarButton = new JButton("salvar");
	private JButton listaComprasButton = new JButton("Lista de Compras");
	
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
		Item i =  montaItem();
				
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
				comando.processaComando("inclui item no banco de dados", i,comboListas.getSelectedItem().toString());	
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
		if (e.getSource().equals(listaComprasButton))
		{
//			c.comentaLocalizacao("actionPerformed");
	//		ComandoGerenciaLista comando = new ComandoGerenciaLista();
		//	comando.processaComando("Exibe Lista de Compras");		
		}	
	}	

	public void constroiInterface() 
	{
		c.comentaLocalizacao("constroiInterface");
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("nome");
		labels.add("cor");
		labels.add("descri��o");
		labels.add("lugar");
		labels.add("lista");
		
		this.add(new JLabel(labels.get(0) ));
		this.add(nomeItemTextField);
		
		this.add(new JLabel(labels.get(1) ));
		this.add(corTextField);
		
		this.add(new JLabel(labels.get(2) ));
		this.add(descricaoTextField);
		
		this.add(new JLabel(labels.get(3) ));
		this.add(lugarTextField);
		
		this.add(new JLabel(labels.get(4) ));
		this.add(comboListas);
		
		this.add(salvarButton);
		this.add(adicalistaButton);
		this.add(listaComprasButton);
	}
	

	public void montaComboListas()
	{
		comboListas = new JComboBox<String>(listasDaCombo);
		setaComboLista();		
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
	
	public Item montaItem()
	{
		itemEmEdicao.setNomeItem(nomeItemTextField.getText());
		itemEmEdicao.setCor(corTextField.getText());
		itemEmEdicao.setDescricao(descricaoTextField.getText());
		itemEmEdicao.setLugar(lugarTextField.getText());		
		
		return itemEmEdicao;
	}

	public void exibeFrame() 
	{		// TODO Auto-generated method stub
		salvarButton.addActionListener(this);
		adicalistaButton.addActionListener(this);
		listaComprasButton.addActionListener(this);
		this.setVisible(true);		
	}

	public void configuraJanela() {
		// TODO Auto-generated method stub
		this.configuraInterface(nlinhas, 2);	
		this.setSizeCrud(400,400);	
		this.setLocation(730, 10);
	}
	
	public void preencheCampos(Item item)
	{
	//	try{
		nomeItemTextField.setText(item.getNomeItem());
		descricaoTextField.setText(item.getDescricao());
		lugarTextField.setText(item.getLugar().toString());
	//	classificacaoTextField.setText(pend.getIdclassificacao().getNomeclassificacao());
		corTextField.setText(item.getCor());
		
		verificaESetaListaSelecionada();
//	}
//		catch(Exception e)
//		{
//			
//		}
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