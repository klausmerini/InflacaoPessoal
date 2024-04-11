package com.merini.derbyAgenda.view.lista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;
import com.merini.derbyAgenda.view.JanelaCrud;


public class JanelaExibeLista implements ActionListener//InterfaceJanelaCrud ,
{
	private JanelaCrud frame;
	private String nomeListaSt="";
	
	private JButton botaoEditar = new JButton("editar");
	private JButton botaoAtualizar = new JButton("Atualizar");
	private JButton botaoGerarLista = new JButton("Gerar Nova Lista");
	private JButton botaoAdicionar= new JButton("Adicionar Item");
	private JButton botaoExcluirDaLista = new JButton("Excluir Item da lista");	
	private JButton botaoStatus = new JButton("Alterar Status");
	
	private JTable tabela;
	private QueryTableModelListaDeCompras tm;
	
	public JanelaExibeLista() 
	{		// TODO Auto-generated constructor stub
		System.out.println("construtor sem parametr obsoleto");

	}
	
	public JanelaExibeLista(String nomeListaSt) 
	{		// TODO Auto-generated constructor stub
		frame = new JanelaCrud("Lista : "+nomeListaSt);
		this.nomeListaSt=nomeListaSt;
		System.out.println("construtor janela "+ nomeListaSt);
		
		constroiInterface(nomeListaSt);
		configuraJanela();
		exibeFrame() ;
	}

	public void actionPerformed(ActionEvent e) 
	{		// TODO Auto-generated method stub
		
		if(e.getSource().equals(botaoGerarLista))
		{
			int[]  linhasSelecionInt = tabela.getSelectedRows();
			ArrayList<String> arrayNomes =  recuperaNomesItensSelecionadosNaTabela(linhasSelecionInt);
			ArrayList<String> arrayIdItens=  recuperaIdsItensSelecionadosNaTabela(linhasSelecionInt);
			
//			c.comentaLocalizCamadaView("Actionperformed","qtd linhas selec - ", String.valueOf(arrayIdItens.size()));
//			ComandoIncluirLista comando = new ComandoIncluirLista();
//			comando.processaComando("Incluir Lista no banco", nomeListaSt, arrayIdItens );
		}
			
		int[]  linhasSelecionInt = tabela.getSelectedRows();
		
		if(e.getSource().equals(botaoEditar))
		{
//			c.comentaLocalizacao("actionPerformed() bot�o editar");
//			ComandoEditarItem comando = cp.getComandoEditarItem();
//			String nomePendenciaEdi = recuperaNomeItemSelecionadoNaTabela();
////			int idItemSelec = recuperaIdItemSelecionadoNaTabela();
//		//	c.comentaValor(" nome do item q ser� editado ", "'"+recuperaNomeItemSelecionadoNaTabela()+"'");
//			comando.processaComando("Exibe interface Altera Item",nomePendenciaEdi );
		}
		
		
		if(e.getSource().equals(botaoAdicionar))
		{
			ComandoIncluirItem comando = new ComandoIncluirItem();
			comando.processaComando("constroi interface adiciona item", nomeListaSt);	
			getFrame().dispose();
		}
		
		
		if(e.getSource().equals(botaoExcluirDaLista))
		{
//			String nomePendenciaEdi = recuperaNomeItemSelecionadoNaTabela();
//			ComandoExcluirItem comando = new ComandoExcluirItem();
//			comando.processaComando("Exclui Item", nomePendenciaEdi);	
		}
		
	
	}

	public void configuraJanela() 
	{
		botaoEditar.addActionListener(this);
		botaoGerarLista.addActionListener(this);
		botaoAtualizar.addActionListener(this);
		botaoAdicionar.addActionListener(this);
		botaoStatus.addActionListener(this);
		botaoExcluirDaLista.addActionListener(this);
		
	//	frame.configuraInterface(2, 2);
		frame.setLocation(15, 10);
		frame.setSize(1270, 600);
//		frame.setSizeCrud(700,400);
	}

//	@Override
	public void constroiInterface(String nomeListaSt) {
		// TODO Auto-generated method stub
	//	idAgendaSt = idAgenda;
	//	String sql = "SELECT i.iditem, nomeitem, statusitemlista, lugar, cor FROM item i, itemlista il, lista l WHERE il.iditem = i.iditem AND il.idlista = l.idlista AND l.nomelista = '"+nomeListaSt+"';";
	//	dados=dadosR;
//		this.colunas=colunasR;		

		String sql = "SELECT descricao, nomeitem, lugar, cor, il.iditem FROM item i, itemlista il, lista l "
				+ "WHERE il.iditem = i.iditem AND il.idlista = l.idlista AND l.nomelista = '"+nomeListaSt+"'";
		
		tm = new QueryTableModelListaDeCompras(sql);
		tabela = new JTable(tm);
		configuraColunas();
	//	 tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
		
		BorderLayout fLayout = new BorderLayout();				
		
		JPanel painelFundo = new JPanel();
		JPanel painelInferior = new JPanel();
		JScrollPane barraRolagem = new JScrollPane(tabela);
		
		frame.setLayout(fLayout);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 		
		
        painelFundo.setLayout(new GridLayout(1, 1));
        painelFundo.add(barraRolagem);
        
    	painelInferior.add(botaoEditar);	
		painelInferior.add(botaoGerarLista);
		painelInferior.add(botaoAtualizar);
		painelInferior.add(botaoAdicionar);
		painelInferior.add(botaoStatus);
		painelInferior.add(botaoExcluirDaLista);
    	
		frame.add(painelFundo,  "North");
		frame.add(painelInferior,  "South");
	
	}
	
	public void configuraColunas()
	{
		tabela.setAutoCreateRowSorter(true);
		TableColumn col = tabela.getColumnModel().getColumn(4);
		tabela.getColumnModel().removeColumn(col);
		
//		 String[] valores = new String[]{"Masculino", "Feminino"};
//	     col.setCellEditor(new MyComboBoxEditor(valores));
//	     col.setCellRenderer(new ComboBoxRenderer(valores));
	}		    

	public void exibeFrame() 
	{
		frame.setVisible(true);	
	}
	
	public ArrayList<String> recuperaNomesItensSelecionadosNaTabela(int[] linhasInt)
	{
		ArrayList<String> itensListaStArray = new ArrayList<String>();
		for (int i = 0; i < linhasInt.length; i++) 
		{
			int j = linhasInt[i];
			String nomeTabelaItSt = tabela.getValueAt (j,1).toString();
			itensListaStArray.add(nomeTabelaItSt);
		}
		
		return itensListaStArray ;		
	}
	
	public ArrayList<String> recuperaIdsItensSelecionadosNaTabela(int[] linhasInt)
	{
		ArrayList<String> itensListaStArray = new ArrayList<String>();
		for (int i = 0; i < linhasInt.length; i++) 
		{
			int j = linhasInt[i];
			String nomeTabelaItSt = tabela.getValueAt (j,4).toString();
			itensListaStArray.add(nomeTabelaItSt);
		}
		
		return itensListaStArray ;		
	}

	public String recuperaNomeItemSelecionadoNaTabela()
	{		
		String nomeItemSt = tabela.getValueAt (tabela.getSelectedRow(),1).toString();
		System.out.println("nome do Item St" + nomeItemSt);
		return nomeItemSt;		
	}
	
	public int recuperaIdItemSelecionadoNaTabela()
	{		
		int idTabelaSt = Integer.valueOf(tabela.getValueAt (tabela.getSelectedRow(),4).toString());
		System.out.println("idTabelaSt "+ String.valueOf(idTabelaSt ));
		return idTabelaSt;		
	}

	public void constroiInterface() {
		// TODO Auto-generated method stub
		
	}

	public JanelaCrud getFrame() {
		return frame;
	}

	public void setFrame(JanelaCrud frame) {
		this.frame = frame;
	}

}

