package com.merini.derbyAgenda.comando.item;

import java.util.ArrayList;

import com.merini.derbyAgenda.dao.ItemDAO;
import com.merini.derbyAgenda.dao.ItemlistaDAO;
import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Lista;

public class ComandoExcluirItem 
{	
	Comentario c = new Comentario();
	
	public void processaComando(String comando, String nomeItem, String nomeLista) 
	{		
			c.comentaLocalizCamadaView("processaComando", comando, nomeLista);
		ItemlistaDAO dao = new ItemlistaDAO();
		ListaDAO daoL = new ListaDAO();
		ItemDAO daoI = new ItemDAO();
		if (comando.equals("Exclui Item")) 
		{
			Item item = (Item) daoI.carregar(nomeItem);
			Lista lista = (Lista) daoL.carregar(nomeLista);
			dao.excluir(String.valueOf(item.getIdItem()),String.valueOf(lista.getIdlista()));
		} 
		else {
			c.comentaErro("COMANDO ERRADO !!!");	}
	}
}
