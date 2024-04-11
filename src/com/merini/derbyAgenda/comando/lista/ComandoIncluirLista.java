package com.merini.derbyAgenda.comando.lista;

import java.util.ArrayList;

import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.modelo.Lista;
import com.merini.derbyAgenda.view.lista.JanelaIncluiLista;


public class ComandoIncluirLista// extends ItemCommand 
{
	String comandoExibeInterfaceIncluiListaSt = "Constroi interface inclui lista";
	String comandoIncluiIncluiListaSt = "Incluir Lista no banco";
	String comandoIncluiIncluiListaSemTipoListaSt = "Incluir Lista no banco sem tipo lista";
	private static ListaDAO daoL = new ListaDAO();
	private static JanelaIncluiLista janela;
	Comentario c = new Comentario();
	

	public void processaComando(String comando, Lista lista,String nomeTipoListaSt) 
	{		// TODO Auto-generated method stub
		c.comentaLocalizacao("processaComando()", comando);
		
		if (comando.equals(comandoIncluiIncluiListaSt)) 
		{
	//		lista.setIdagenda(cp.getAgendaSelecionada());
			daoL.gravar(lista);
		} 
		else 
		{
			c.comentaErro("COMANDO ERRADO !!!");
		}
	}

	public void processaComando(String comando)
	{	
		c.comentaLocalizacao("processaComando()", comando);
		
		if (comando.equals(comandoExibeInterfaceIncluiListaSt)) 
		{	//recupera listas, mudar para tipos de lista
			ArrayList<String> nomesListasArSt = (ArrayList<String>)daoL.obterTodosNomes();
			String[] arrayNomeClSt =  nomesListasArSt.toArray(new String[nomesListasArSt.size()]);			
			try {
				janela.dispose();
			} catch (NullPointerException e) {				
				//e.printStackTrace();			
			}	
			
			janela = new JanelaIncluiLista("Janela inclui lista", arrayNomeClSt );
		}
		else 
		{
			c.comentaErro("COMANDO ERRADO !!!");
		}		// TODO Auto-generated method stub		
	}	

	public String getComandoExibeInterfaceIncluiListaSt() {
		return comandoExibeInterfaceIncluiListaSt;
	}

	public void setComandoExibeInterfaceIncluiListaSt(String comandoExibeInterfaceIncluiListaSt) {
		this.comandoExibeInterfaceIncluiListaSt = comandoExibeInterfaceIncluiListaSt;
	}


	public JanelaIncluiLista getJanela() {
		return janela;
	}

	public void setJanela(JanelaIncluiLista janela) {
		this.janela = janela;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void processaComando(String comando, Lista lista) 
//	{		// TODO Auto-generated method stub
//		c.comentaLocalizacao("processaComando()", comando);
//		
//		if (comando.equals(comandoIncluiIncluiListaSemTipoListaSt)) 
//		{
//			facadeLista.gravar(lista);
//		} 
//		else 
//		{
//			c.comentaErro("COMANDO ERRADO !!!");
//		}
//	}	
//
//	public void processaComando(String comando,  String NomeLista, ArrayList<String>  linhasSelecionadas) 
//	{
//		Lista novaLista = new Lista();
//		c.comentaLocalizacao("processa comando", NomeLista);
//	//	novaLista.setIdlista(null);
//		novaLista.setNomelista(novaLista.getNomelista()+" personalizado");
//		Lista novalistaComId =null;
//		
//		if (comando.equals("Incluir Lista no banco")) 
//		{
//			novalistaComId = facadeLista.gravar(novaLista);;
//			for (int i=0 ; i< linhasSelecionadas.size(); i++)
//			{		
//				String nomeIt = linhasSelecionadas.get(i);
//				c.comentaLocalizacao("processa comando", nomeIt );
//				Item itemIncluido = (Item) facadeItem.carregar(Integer.valueOf(nomeIt));				
//				Itemlista itemL = new Itemlista(itemIncluido ,novalistaComId );
//				facadeItLi.gravar(itemL);				
//			}	
//		} 
//		else 
//		{
//			c.comentaErro("COMANDO ERRADO !!!");
//		}
//		ComandoExibeListas comando2 = new ComandoExibeListas();
//		comando2.processaComando("Exibe Lista selecionada", novalistaComId.getNomelista());
//	}


}
