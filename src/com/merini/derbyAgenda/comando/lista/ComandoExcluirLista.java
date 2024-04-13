package com.merini.derbyAgenda.comando.lista;

import java.sql.SQLException;

import com.merini.derbyAgenda.dao.ListaDAO;
import com.merini.derbyAgenda.modelo.Comentario;
import com.merini.derbyAgenda.modelo.Lista;

public class ComandoExcluirLista
{
	Comentario c = new Comentario();
	String comandoExcluiListaSt = "Exclui Lista";
	ListaDAO dao = new ListaDAO();
	
	public void processaComando(String comando, String nomeLista) 
	{	
			c.comentaLocalizCamadaControle("processaComando", this.getClass().toString(),comando);
		if (comando.equals(comandoExcluiListaSt))
		{
			Lista lista = dao.carregar(nomeLista);
			dao.excluir(lista);
		}
	}
}
