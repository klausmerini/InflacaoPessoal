package com.merini.derbyAgenda.comando.item;

import java.util.ArrayList;

import controle.AbstractCommand;
import controle.ItemCommand;
import entities.Agenda;
import entities.Item;
import entities.Itemlista;

public class ComandoExcluirItem extends ItemCommand {

	
	public void processaComando(String comando, String nomeItem) 
	{		// TODO Auto-generated method stub

		String nomeLista = cp.getComandoExibeListas().getNomeListaSelec();
		c.comentaLocalizCamadaView("processaComando", comando, nomeLista);
		if (comando.equals("Exclui Item")) 
		{
			Itemlista item= new Itemlista();			
			ArrayList<Itemlista> ilArray = 	facadeItemLista.recuperaPorNomeItemENomeLista(nomeLista, nomeItem);
			item = (Itemlista) ilArray.get(0); 
			facadeItemLista.excluir(item);		
		} else {
			c.comentaErro("COMANDO ERRADO !!!");
		}

	}

	@Override
	public void processaComando(String comando) {
		// TODO Auto-generated method stub
		
	}

}
