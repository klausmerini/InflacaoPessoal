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

import com.merini.derbyAgenda.comando.item.ComandoEditarItem;
import com.merini.derbyAgenda.comando.item.ComandoExcluirItem;
import com.merini.derbyAgenda.comando.item.ComandoIncluirItem;
import com.merini.derbyAgenda.comando.lista.ComandoExcluirLista;
import com.merini.derbyAgenda.view.JanelaCrud;


public class JanelaExibeLista implements ActionListener//InterfaceJanelaCrud ,
{
	private JanelaCrud frame;
	private String nomeListaSt="";
	
	private JButton botaoEditar = new JButton("editar");
	private JButton botaoAtualizar = new JButton("Atualizar");
	private JButton botaoExcluirLista = new JButton("Excluir Lista");
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
		
		if(e.getSource().equals(botaoExcluirLista))
		{
//			int[]  linhasSelecionInt = tabela.getSelectedRows();
//			ArrayList<String> arrayNomes =  recuperaNomesItensSelecionadosNaTabela(linhasSelecionInt);
//			ArrayList<String> arrayIdItens=  recuperaIdsItensSelecionadosNaTabela(linhasSelecionInt);
			
	//		c.comentaLocalizCamadaView("Actionperformed","","");
			ComandoExcluirLista comando = new ComandoExcluirLista();
			comando.processaComando("Exclui Lista", nomeListaSt);
		}
			
		int[]  linhasSelecionInt = tabela.getSelectedRows();
		
		if(e.getSource().equals(botaoEditar))
		{
			System.out.println("actionPerformed() bot�o editar");;
			ComandoEditarItem comando = new ComandoEditarItem();
			String nomePendenciaEdi = recuperaNomeItemSelecionadoNaTabela();
		//	c.comentaValor(" nome do item q ser� editado ", "'"+recuperaNomeItemSelecionadoNaTabela()+"'");
			comando.processaComando("Exibe interface Altera Item",nomePendenciaEdi );
		}
		
		
		if(e.getSource().equals(botaoAdicionar))
		{
			ComandoIncluirItem comando = new ComandoIncluirItem();
			comando.processaComando("constroi interface adiciona item", nomeListaSt);	
			getFrame().dispose();
		}
		
		
		if(e.getSource().equals(botaoExcluirDaLista))
		{
			String nomeItemEdi = recuperaNomeItemSelecionadoNaTabela();
			ComandoExcluirItem comando = new ComandoExcluirItem();
			comando.processaComando("Exclui Item", nomeItemEdi, nomeListaSt);	
		}
		
	
	}

	public void configuraJanela() 
	{
		botaoEditar.addActionListener(this);
		botaoExcluirLista.addActionListener(this);
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
	public void constroiInterface(String nomeListaSt) 
	{
//		String sql = "SELECT descricao, nomeitem, lugar, cor, il.iditem FROM item i, itemlista il, lista l "
//				+ "WHERE il.iditem = i.iditem AND il.idlista = l.idlista AND l.nomelista = '"+nomeListaSt+"'";
		
		String sql = "SELECT descricao, nomeitem, lugar, cor, il.iditem, il.valor, il.data FROM item i, itemlista il, lista l "
				+ "WHERE il.iditem = i.iditem AND il.idlista = l.idlista AND l.nomelista = '"+nomeListaSt+"'";
		
		tm = new QueryTableModelListaDeCompras(sql);
		tabela = new JTable(tm);
		configuraColunas();		
		BorderLayout fLayout = new BorderLayout();					
		JPanel painelFundo = new JPanel();
		JPanel painelInferior = new JPanel();
		JScrollPane barraRolagem = new JScrollPane(tabela);
		
		frame.setLayout(fLayout);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 		
		
        painelFundo.setLayout(new GridLayout(1, 1));
        painelFundo.add(barraRolagem);
        
    	painelInferior.add(botaoEditar);	
		painelInferior.add(botaoExcluirLista);
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
	
	public ArrayList<String> recuperaNomesItensNaTabela()
	{
		ArrayList<String> itensListaStArray = new ArrayList<String>();
		for (int i = 0; i < tabela.getModel().getRowCount(); i++) 
		{
			String nomeItemItSt = tabela.getValueAt (i,1).toString();
			itensListaStArray.add(nomeItemItSt);
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

