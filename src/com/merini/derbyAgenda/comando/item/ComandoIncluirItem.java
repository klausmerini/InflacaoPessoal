package com.merini.derbyAgenda.comando.item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.merini.derbyAgenda.dao.DAOAbstrato;
import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.dao.ItemlistaDAO;
import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Itemlista;
import com.merini.derbyAgenda.modelo.Lista;
import com.merini.derbyAgenda.view.item.JanelaAdicionaItem;

public class ComandoIncluirItem //extends ItemCommand
{
//	static ComandoIncluirItem controle;
	public static JanelaAdicionaItem janelaAdicionaItem ;
	public static ItemDAO dao = new ItemDAO();
	Comentario c = new Comentario();	
	
	public ComandoIncluirItem() 
	{		// TODO Auto-generated constructor stub
		c.comentaLocalizacao("public  ComandoIncluirItem");		
	}
		
	public void processaComando(String comando, String nomeLista) 
	{		// [TODO Auto-generated method stub
		c.comentaLocalizCamadaControle("processaComando", "ComandoIncluirItem", comando);		
		String[] arrayNomeListasSt =  recuperaNomesDasListas();		
		if (comando.equals("constroi interface adiciona item"))
		{
			c.comentaValor("array de nomeLista", String.valueOf(arrayNomeListasSt.length));			
			janelaAdicionaItem  = new JanelaAdicionaItem("Adiciona Item", arrayNomeListasSt, nomeLista);
		}		
	}
	
	public void processaComando(String comando, Item item, String nomeLista, Double valor, Integer qtd, Date diaDate) 
	{	
 		c.comentaLocalizCamadaControle("processaComando", "ComandoIncluirItem", comando);
		
		if (comando.equals("inclui item no banco de dados"))
		{		//Instância os DAO
			ItemlistaDAO daoIL = new ItemlistaDAO();
			ListaDAO daoL = new ListaDAO();
				c.comentaValor("nome dalista selecionada na combo ", nomeLista);
				//Prepara objetos a serem inseridos
			Lista lista = (Lista) daoL .carregar(nomeLista);	
		//	java.sql.Date data = new java.sql.Date(diaDate.getYear(), diaDate.getMonth(), diaDate.getDay()+14);
			java.sql.Date data = new java.sql.Date(diaDate.getTime());
				c.comentaValor("Prepara objetos-data a serem inseridos", data.toString());
				c.comentaValor("diaDate.getYear()", String.valueOf(data.getYear()));
				c.comentaValor("diaDate.getMonth()", String.valueOf(data.getMonth()));
				c.comentaValor("diaDate.getDay()", String.valueOf(data.getDay()));
				//executa a inserção no banco
			
			Item itemIncluido=null;
			Item ItemExistente=null;
			try 
			{
				ItemExistente  =  dao.carregar(item.getNomeItem());
					c.comentaValor("IdItem do itidItemExixtente ", String.valueOf(ItemExistente.getIdItem()));
			}
			catch (SQLException e) 
			{					// Se não encontraro item, cria-o
				itemIncluido = (Item) dao.gravar(item);	
					c.comentaValor(" Se não encontrar o item, cria-o, IdItem do item criado : ", String.valueOf(itemIncluido.getIdItem()));
				//	e.printStackTrace();
			}
			if(itemIncluido==null)	//Se o itemincluido for null, ele não incluiu, ou seja, achou o item com o onome inputado,
			{		//Então, grava no itemlista o iditem do item existente anteriormente
				daoIL.gravar(Integer.valueOf(lista.getIdlista()),Integer.valueOf(ItemExistente.getIdItem()), valor, qtd, data);
			}
			else
			{		//caso contr[ario entra o id do item criado
				daoIL.gravar(Integer.valueOf(lista.getIdlista()),Integer.valueOf(itemIncluido.getIdItem()), valor, qtd, data);
			}
//			try 
//			{		
//				cp.getComandoExibeListas().getJanelaLista().getFrame().dispose();
//			} 
//			catch (NullPointerException e) 
//			{			// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			cp.getComandoExibeListas().processaComando("Exibe Lista selecionada", nomeLista);	
		}		
		else
		{		//gerar exception
			System.out.println("!!!! comando errado");
		}		
	}
	
	public String[] recuperaNomesDasListas()
	{
		ListaDAO listadao = new ListaDAO();
			
		ArrayList<String> arrayNomesListas = (ArrayList<String>) listadao.obterTodosNomes();
		String[] arrayNomeClSt =  arrayNomesListas.toArray(new String[arrayNomesListas.size()]);
		return arrayNomeClSt;		
	}
	
	public static JanelaAdicionaItem getJanelaAdicionaItem() {
		return janelaAdicionaItem;
	}

	public static void setJanelaAdicionaItem(JanelaAdicionaItem janelaAdicionaItem) {
		ComandoIncluirItem.janelaAdicionaItem = janelaAdicionaItem;
	}
}
