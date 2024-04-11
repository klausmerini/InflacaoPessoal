package com.merini.derbyAgenda.comando.item;

import java.util.ArrayList;
import java.util.List;

import controle.AbstractCommand;
import controle.ItemCommand;
import entities.Comentario;
import entities.Horario;
import entities.Item;
import entities.Pendencia;
import view.item.JanelaAdicionaItem;
import view.lista.JanelaExibeLista;



public class ComandoEditarItem extends ItemCommand
{	
	
	JanelaAdicionaItem janela =null;
	
	public void processaComando(String comando, String nomePend, String idAgenda) 
	{	}

//	@Override
	public void processaComando(String comando, Item item) 
	{		// TODO Auto-generated method stub
		c.comentaLocalizCamadaControle("processaComando", this.getClass().toString(), comando+", "+item.getNomeItem());
//		c.comentaValor("idAgenda", pend.getAgenda().getIdagenda().toString());		
		if (comando.equals("Persiste altera��o do item no banco de dados"))
		{
	//		hor.setIdpendencia(pend);
			facadeItem.editarObj(item);
			
			String nomeLista = cp.getComandoExibeListas().getNomeListaSelec();
			c.comentaLocalizacao("nome Lista Selecionada", nomeLista);
			try {
				cp.getComandoExibeListas().getJanelaLista().getFrame().dispose();
			} catch (Exception e) {				// TODO Auto-generated catch block
				System.out.println("primeira janela de editar pendencia n�o foi achada, instancia uma nova");
				//e.printStackTrace();
			}
			cp.getComandoExibeListas().setJanelaLista(new JanelaExibeLista(nomeLista)); 
		}
		else
		{
			c.comentaErro("comando errado");
		}
		
	}

	
	public void processaComando(String comando, int id) 
	{		// TODO Auto-generated method stub
	//	Item itemEdit = (Item) facadeItem.recuperaPorNome(nomeItemSt);

		Item itemEdit = (Item) facadeItem.carregar(id);
		c.comentaLocalizacao("processaComando", itemEdit.getNomeItem());
		String[] arrayNomeClSt =  recuperaNomesDasListas();
		
		if (comando.equals("Exibe interface Altera Item"))
		{
			
			try {
				janela.dispose();
			} catch (Exception e) {				// TODO Auto-generated catch block
				System.out.println("primeira janela de editar pendencia n�o foi achada, instancia uma nova");
				//e.printStackTrace();
			}
			janela =  new JanelaAdicionaItem("Janelda Edita Item",itemEdit, arrayNomeClSt);
		}
		else
		{
			c.comentaErro("comando errado");
		}	
	}
	
	public void processaComando(String comando, String nomeItemSelecionadoEdi) 
	{		// TODO Auto-generated method stub
		Item itemEdit = (Item) facadeItem.recuperaPorNome(nomeItemSelecionadoEdi);
		//Item itemEdit = (Item) facadeItem.carregar(id);
		c.comentaLocalizacao("processaComando", nomeItemSelecionadoEdi);
		String[] arrayNomeClSt =  recuperaNomesDasListas();
		
		if (comando.equals("Exibe interface Altera Item"))
		{
			try {
				janela.dispose();		} 
			catch (Exception e) {				// TODO Auto-generated catch block
				System.out.println("primeira janela de editar pendencia n�o foi achada, instancia uma nova");}				//e.printStackTrace();			}
			janela =  new JanelaAdicionaItem("Janelda Edita Item",itemEdit, arrayNomeClSt);
		}
		else
		{	c.comentaErro("comando errado");	}	
	}
	
//
//	public List<String> recuperaNomesClassificacoes()
//	{
//		Integer idAgendaInt = facadeAg.recuperaIdPorNome(AbstractCommand.recuperaNomeAgendaNoCP());
//		String idAgSt = String.valueOf(idAgendaInt);		
//	
//		List<String> arrayClsNome =  facadeCl.obterTodosNomesPorAgenda(idAgSt);
//		return arrayClsNome;
//		
//	}
	
	
	@Override
	public void processaComando(String comando) {
		// TODO Auto-generated method stub
		
	}
	

}
