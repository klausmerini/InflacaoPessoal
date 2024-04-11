package com.merini.derbyAgenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Itemlista;

public class ItemlistaDAO extends DAOAbstrato implements FacadeInterf 
{

	private String sqlInsertItemlista = "INSERT INTO itemlista (idlista, iditem) values (";
	private String sqlRecuperaTodosPorLista = "SELECT descricao, nomeitem, lugar, cor, il.iditem FROM item i, itemlista il, lista l "
	+ "WHERE il.iditem = i.iditem AND il.idlista = l.idlista AND l.nomelista = '";


	public Object carregar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Object gravar(Integer idlistaInt, Integer iditemInt) 
	{
			System.out.println("ItemlistaDAO.gravar");
		Connection connection = conecta();
		String sql = sqlInsertItemlista
			//	+ itemlistaGr.getIditem().toString()+"', '"
				+idlistaInt.toString()+", "
				+ iditemInt.toString()+")";
		System.out.println(sql);
		try 
		{
				Statement stmt = connection.createStatement();
				int resultado = stmt.executeUpdate(sql);
				stmt.close();
				connection.close();
					System.out.println("itemlista recuperada : ");
				shutDown();
				return resultado;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return null;
	}

	public List obterTodosItemlistaPorNomeLista(String nomeListaSelec) 
	{
		Connection connection = conecta();	
		String query = sqlRecuperaTodosPorLista+nomeListaSelec+"'";
		try 
		{	
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			String name;
			ArrayList<String> arrayNomesItens = new ArrayList<String>();
			while(rs.next())
			{
				name = rs.getString("nomeitem").trim();
				System.out.printf("nome do item : %s\n",name);
				arrayNomesItens.add(name);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
				System.out.println("nome dos itens recuperado");
			shutDown();
			return (List) arrayNomesItens;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}			
		return null;
	}
	
	
	

	public List obterTodosNomes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer recuperaIdPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object recuperaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Object objeto) {
		// TODO Auto-generated method stub
		
	}

	public Object gravar(Object entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluir(Object entidade) {
		// TODO Auto-generated method stub
		
	}
	

}
