package com.merini.derbyAgenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.merini.derbyAgenda.modelo.Classificacao;
import com.merini.derbyAgenda.modelo.Item;

public class ItemDAO extends DAOAbstrato implements FacadeInterf{

	private static String JdbcUrl="jdbc:derby:agendaDerby;";//create=true";
	private String sqlDeletaitem = "DELETE FROM item WHERE nomeitem = '";
	private String sqlCarregaItem = "SELECT * FROM item WHERE nomeitem = '";
	private String sqlInsertItem = "INSERT INTO item (nomeitem, cor, descricao) values ('";
	private String sqlEditar = "UPDATE item SET  nomeitem = '";
	private String sqlDeletaItem =  "DELETE FROM item WHERE nomeitem = '";
	
	@Override
	public void editar(Object objeto) {
		Item item = (Item)objeto;
		String sql = sqlEditar
							+item.getNomeItem()+
				           "', cor = '"+item.getCor()+
						   "', descricao = '"+item.getDescricao()+"' WHERE "+
						   " iditem = "+String.valueOf(item.getIdItem());
		System.out.println("dao.editar "+sqlEditar);

		Connection connection =conecta();
		try 
		{
			Statement stmt = connection.createStatement();
			int resultado = stmt.executeUpdate(sql);
				System.out.println(String.valueOf(resultado));
			stmt.close();
			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
	}

	public Item gravar(Item item) 
	{
		System.out.println("ItemDAO.gravar");
		Connection connection = conecta();
		Item itemGr = (Item) item;
		sqlInsertItem= sqlInsertItem
				+ itemGr.getNomeItem()+"', '"+itemGr.getCor()+"', '"
				+ itemGr.getDescricao()+"')";
		try 
		{
				Statement stmt = connection.createStatement();
				int resultado = stmt.executeUpdate(sqlInsertItem);
				itemGr = (Item) carregar(itemGr.getNomeItem());
				connection.close();
					System.out.println("item gravado e recuperado : "+itemGr.getNomeItem());
				shutDown();
				return itemGr;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return null;
	}

	@Override
	public List obterTodosNomes() 
	{	
		Connection connection = conecta();
		try 
		{
				PreparedStatement preparedStatement = connection.prepareStatement
				("select nomeitem from item");
				ResultSet resultSet = preparedStatement.executeQuery();
				String name;
				ArrayList<String> arrayNomesItens = new ArrayList<String>();
				while(resultSet.next())
				{
					name = resultSet.getString("nomeitem").trim();
					System.out.printf("nome do item : %s\n",name);
					arrayNomesItens.add(name);
				}
				resultSet.close();
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

	@Override
	public Object carregar(String nomeItem) {
		Connection connection = conecta();
		Item item = new Item();
		try 
		{
				PreparedStatement preparedStatement = connection.prepareStatement(sqlCarregaItem+nomeItem+"'");
				System.out.println(sqlCarregaItem+nomeItem+"'");
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				item.setNomeItem(resultSet.getString("nomeitem"));
				item.setCor(resultSet.getString("Cor"));
				item.setDescricao(resultSet.getString("Descricao"));
				item.setIdItem(resultSet.getInt("idItem"));
				
				resultSet.close();
				preparedStatement.close();
				connection.close();
					System.out.println("classificação recuperada : "+item.getNomeItem());
				shutDown();
				return item;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		return null;
	}


	public Object gravar(Object entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object carregar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void excluir(Object entidade) 
	{
		
	}

	public int excluir(Item entidade) 
	{
		int resultado=0;
		Connection connection = conecta();
		Item item = (Item) entidade;
		String nomeItem = item.getNomeItem();
		try 
		{
			Statement stmt = connection.createStatement();
			String sql = sqlDeletaItem+nomeItem+"'";
			System.out.println(sql);
			resultado = stmt.executeUpdate(sql);
				System.out.println("registro classificação excluído, status code : "+String.valueOf(resultado));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		}
		shutDown();
		return resultado;
	}

}
