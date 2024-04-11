package com.merini.derbyAgenda.teste.classificacao;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;

public class CT2verificaExclusao 
{
	private String sqlInsertClassifParte1 = "INSERT INTO classificacao(nomeclassificacao, cor, descricao) values ";
	private String descricaoSt = "teste exclusao description";
		

	@Test
	public void verificaExclusao()
	{
		ClassificacaoDAO dao = new ClassificacaoDAO();
		Date date = new Date();
		String horaSt= String.valueOf(date.getTime());
		String nomeClasssificacaoSt = "Entretenimento 5 "+horaSt;
		String sqlInsertClassif = sqlInsertClassifParte1 
				+ "('"+nomeClasssificacaoSt
				+ "','Azul Escuro',"
				+ " '"+descricaoSt +"')";
		dao.gravar(sqlInsertClassif);
		
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());		} 
		catch (SQLException e) {		
			e.printStackTrace();		}
		
		int resultado = dao.excluir(nomeClasssificacaoSt);
		assertEquals(1, resultado);	//status code 2 indica o sucesso da operação
	}	

}
