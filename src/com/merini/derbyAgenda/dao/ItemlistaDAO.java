package com.merini.derbyAgenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Itemlista;

public class ItemlistaDAO extends DAOAbstrato implements FacadeInterf 
{

	private String sqlInsertItemlista = "INSERT INTO itemlista (idlista, iditem) values (";
	private String sqlInsertItemlistaCompl = "INSERT INTO itemlista (idlista, iditem, valor, qtd, data ) values (";
	private String sqlRecuperaTodosPorLista = "SELECT descricao, nomeitem, lugar, cor, il.iditem FROM item i, itemlista il, lista l "
	+ "WHERE il.iditem = i.iditem AND il.idlista = l.idlista AND l.nomelista = '";
	private String sqlExcluiItemlista = "DELETE FROM itemlista WHERE iditem = ";
	private String sqlExcluiItemlistaP2 = "AND idlista = ";
	private String sqlRecuperaDataEValorPorLista = "SELECT valor, data FROM itemlista, item WHERE itemlista.iditem = item.iditem AND item.nomeitem = '";

	public Object carregar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int excluir(String idLista, String idItem) 
	{
			System.out.println("ItemlistaDAO.gravar");
		String sql = sqlExcluiItemlista+idLista+sqlExcluiItemlistaP2+idItem;
		Connection connection = conecta();		
		System.out.println(sql);
		try 
		{
				Statement stmt = connection.createStatement();
				int resultado = stmt.executeUpdate(sql);
				stmt.close();
				connection.close();
					System.out.println("itemlista excluido, status code : "+String.valueOf(resultado));
				shutDown();
				return resultado;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return (Integer) null;
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
					System.out.println("itemlista gravado, status code : "+String.valueOf(resultado));
				shutDown();
				return resultado;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return null;
	}
	
	public Object gravar(Integer idlistaInt, Integer iditemInt, Double valor, Integer qtd, Date dataDt) 
	{
			System.out.println("ItemlistaDAO.gravar");
		Connection connection = conecta();
		String sql = sqlInsertItemlistaCompl
			//	+ itemlistaGr.getIditem().toString()+"', '"
				+idlistaInt.toString()+", "
				+ iditemInt.toString()+","
						+valor.toString()+","
						+qtd.toString()+",'"
						+dataDt+"'"
						+")"						
				;
		System.out.println(sql);
		try 
		{
				Statement stmt = connection.createStatement();
				int resultado = stmt.executeUpdate(sql);
				stmt.close();
				connection.close();
					System.out.println("itemlista gravado, status code : "+String.valueOf(resultado));
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
	
	public HashMap obterDataEValorPorItem(String nomeItem) 
	{
		Connection connection = conecta();	
		String query = sqlRecuperaDataEValorPorLista+nomeItem+"'";
		try 
		{	
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			double valor;
			Map<Date, Double> mapValores= new HashMap<>();
//			ArrayList<Integer> arrayValoresItens = new ArrayList<Integer>();
//			ArrayList<Date> arrayDatasItens = new ArrayList<Date>();			
			while(rs.next())
			{
				valor = rs.getDouble("valor");
				System.out.printf("valor do item : %s\n",valor);
				mapValores.put(rs.getDate("data"), valor);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			shutDown();
			return (HashMap) mapValores;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}			
		return null;
	}	
	
	public List obterTodosValoresItem(String query) 
	{
		Connection connection = conecta();	
	//	String query = sqlRecuperaTodosPorLista+nomeListaSelec+"'";
		try 
		{	
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			String name;
			ArrayList<String> arrayNomesItens = new ArrayList<String>();
			while(rs.next())
			{
				name = rs.getString("nomeitem").trim();
				System.out.printf("valor do item : %s\n",name);
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
