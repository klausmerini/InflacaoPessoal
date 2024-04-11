package com.merini.derbyAgenda.teste.classificacao;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.merini.derbyAgenda.dao.ClassificacaoDAO;
import com.merini.derbyAgenda.modelo.Classificacao;

public class CT4verificaEdicaoTest 
{
	@Test
	public void CT3verificaEdicao()
	{
		ClassificacaoDAO dao = new ClassificacaoDAO();
		Date date = new Date();
		String horaSt= String.valueOf(date.getTime());
		String nomeClasssificacaoSt = "Atividade Fisica";
		System.out.println("carregar "+nomeClasssificacaoSt);

		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());		} 
		catch (SQLException e) {		
			e.printStackTrace();		}

		Classificacao classificacao = (Classificacao) dao.carregar(nomeClasssificacaoSt);		
		String descricaoSt="descrição editada "+String.valueOf(horaSt);		
		classificacao.setDescricao(descricaoSt);

		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());		} 
		catch (SQLException e) {		
			e.printStackTrace();		}
		
		dao.editar(classificacao);
		
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());		} 
		catch (SQLException e) {		
			e.printStackTrace();		}
		
		Classificacao classificacaoEditada = (Classificacao) dao.carregar(classificacao.getNomeclassificacao());
		assertEquals(descricaoSt, classificacaoEditada.getDescricao());
	}	
}
