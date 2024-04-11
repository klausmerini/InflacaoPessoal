package com.merini.derbyAgenda.comando.lista;

import java.util.ArrayList;
import com.merini.derbyAgenda.view.lista.JanelaExibeLista;

public class ComandoExibeListas 
{
	private static JanelaExibeLista janelaLista;
	private static String nomeListaSelec;
	String comandoExibeSt = "Exibe Lista selecionada";
	String sql = "SELECT descricao, nomeitem, lugar, cor, iditem FROM item i, itemlista il, lista l "
			+ "WHERE il.iditem = i.iditem AND il.idlista = l.idlista AND l.nomelista = '"+nomeListaSelec+"'";

	
	public void processaComando(String comando, String nomeListaSelecionada) 
	{		// TODO Auto-generated method stub
		if (comando.equals("Exibe Lista selecionada")) 
		{
			nomeListaSelec=nomeListaSelecionada;
			System.out.println("nome Lista Selecionada "+ nomeListaSelec);
			
//			try {
//				this.janelaLista.getFrame().dispose();
//			} catch (Exception e) {				// TODO Auto-generated catch block
//				System.out.println("primeira janela de editar pendencia n�o foi achada, instancia uma nova");
//				//e.printStackTrace();
//			}
			janelaLista = new JanelaExibeLista(nomeListaSelec); 
		} 
		else 
		{
//			nomesListasArSt = (ArrayList<String>) facadeLista.obterTodosNomes();
//			String[] arrayNomeClSt =  nomesListasArSt.toArray(new String[nomesListasArSt.size()]);
//			JanelaSelecionaLista janela = new JanelaSelecionaLista("Selecione a lista para exibir", arrayNomeClSt);
				System.out.println("Comando Errado !!!!!!!");
		}
	}

	public String getComandoExibeSt() {
		return comandoExibeSt;
	}

	public void setComandoExibeSt(String comandoExibeSt) {
		this.comandoExibeSt = comandoExibeSt;
	}
	
	public static JanelaExibeLista getJanelaLista() {
		return janelaLista;
	}

	public static void setJanelaLista(JanelaExibeLista janelaLista) {
		ComandoExibeListas.janelaLista = janelaLista;
	}


	public static String getNomeListaSelec() {
		return nomeListaSelec;
	}


	public static void setNomeListaSelec(String nomeListaSelec) {
		ComandoExibeListas.nomeListaSelec = nomeListaSelec;
	}

	

}
