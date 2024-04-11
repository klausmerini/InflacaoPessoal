package com.merini.derbyAgenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.merini.derbyAgenda.modelo.Item;
import com.merini.derbyAgenda.modelo.Lista;


public class ListaDAO extends DAOAbstrato implements FacadeInterf
{
	
		private String sqlInsertlista="INSERT INTO lista (nomelista, descrlista) values ('";
		private String sqlDeletalista = "DELETE FROM lista WHERE nomelista = '";
		private String sqlSelecionaNomesLista = "SELECT nomeLista FROM Lista ";
		private String sqlEditar= "UPDATE lista SET  nomelista = '";
		private String sqlCarregaLista = "SELECT * FROM lista WHERE nomelista = '";;

		public ListaDAO()
		{
			c.comentaLocalizacao("Construtor ListaDao");
		}

		public Lista carregar(String nomeLista) 
		{			// TODO Auto-generated method stub
			c.comentaLocalizCamadaDAO("carregar", this.getClass().getName(), " id :");
			Connection connection = conecta();
			Lista lista = new Lista();
			try 
			{
					PreparedStatement preparedStatement = connection.prepareStatement(sqlCarregaLista+nomeLista+"'");
					System.out.println(sqlCarregaLista+nomeLista+"'");
					ResultSet resultSet = preparedStatement.executeQuery();
					resultSet.next();
					lista.setNomelista(resultSet.getString("nomelista"));
					lista.setDescrlista(resultSet.getString("Descrlista"));
					lista.setIdlista(resultSet.getInt("idlista"));
					
					resultSet.close();
					preparedStatement.close();
					connection.close();
						System.out.println("classificação recuperada : "+lista.getNomelista());
					shutDown();
					return lista;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();		
			}
			return null;
		}		

		@Override
		public void editar(Object objeto) 
		{
			Lista lista = (Lista)objeto;
			int resultado = 0;
			String sql = sqlEditar
								+lista.getNomelista()+
					        //   "', cor = '"+lista.getCor()+
							   "', descrlista = '"+lista.getDescrlista()+"' WHERE "+
							   " idlista = "+String.valueOf(lista.getIdlista());
			System.out.println("dao.editar "+sqlEditar);

			Connection connection =conecta();
			try 
			{
				Statement stmt = connection.createStatement();
				resultado = stmt.executeUpdate(sql);
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

		public int excluir(Lista entidade) 
		{		
			int resultado=0;
			Connection connection = conecta();
			String nomelista = entidade.getNomelista();
			try 
			{
				Statement stmt = connection.createStatement();
				String sql = sqlDeletalista+nomelista+"'";
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
		
		public Lista gravar(Lista lista)
		{
			c.comentaLocalizacao("gravar");

			System.out.println("listaDAO.gravar");
			Connection connection = conecta();
			Lista listaGr = (Lista) lista;
			sqlInsertlista= sqlInsertlista
					+ listaGr.getNomelista()+"', '"//+listaGr.getItemlistaCollection()+"', '"
					+ listaGr.getDescrlista()+"')";
			try 
			{
					Statement stmt = connection.createStatement();
					int resultado = stmt.executeUpdate(sqlInsertlista);
					stmt.close();
					connection.close();
						System.out.println("classificação recuperada : "+listaGr.getNomelista());
					shutDown();
					return lista;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();		
			}
			return null;
		}		
		
		@Override
		public List obterTodosNomes() 
		{		// TODO Auto-generated method stub
			c.comentaLocalizCamadaDAO("obterTodosNomes", this.getClass().toString(),"");
			Connection connection = conecta();
			try 
			{
					PreparedStatement preparedStatement = connection.prepareStatement(sqlSelecionaNomesLista);
					ResultSet resultSet = preparedStatement.executeQuery();
					String name;
					ArrayList<String> arrayNomesListas = new ArrayList<String>();
					while(resultSet.next())
					{
						name = resultSet.getString("nomelista").trim();
						System.out.printf("nome do item : %s\n",name);
						arrayNomesListas.add(name);
					}
					resultSet.close();
					preparedStatement.close();
					connection.close();
						System.out.println("nome dos itens recuperado");
					shutDown();
					return (List) arrayNomesListas;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();		
			}
			return null;		
		}
		
		
		
		
		
		
		
		
		
	

		public Object carregar(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}
		

		@Override
		public Integer recuperaIdPorNome(String nome) 
		{		// TODO Auto-generated method stub
			c.comentaLocalizCamadaDAO("recuperaIdPorNome", this.getClass().toString(),nome);
//			
//			Query query = em.createQuery("SELECT l.idLista FROM Lista l WHERE l.nomeLista LIKE:nome");
//			query.setParameter("nome","%"+nome+"%");
//			ArrayList<Integer> arrayIdPorNome = (ArrayList<Integer>)query.getResultList();
//			Integer idAgenda =  arrayIdPorNome.get(0);
//			c.comentaLocalizacao("recuperaIdPorNome", idAgenda.toString());
	//		return idAgenda;
			return null;
		}

		@Override
		public Object recuperaPorNome(String nome) 
		{			// TODO Auto-generated method stub
			c.comentaLocalizCamadaDAO("recuperaPorNome está fora de uso USAR MÉTODO CARREGAR", this.getClass().toString(),nome);
//			nome.trim();
//			Query query = em.createQuery("SELECT l FROM Lista l WHERE l.nomeLista = :nome");
//			query.setParameter("nome",nome);
//			String hqlSt = query.getParameterValue("nome").toString();
//			c.comentaValor("query ", "'"+hqlSt+"'");
//			return (Lista) query.getSingleResult();
			return null;
		}		
	
		public List recuperaPorIdAgenda(String nome) 
		{
			return null;			// TODO Auto-generated method stub
//			c.comentaLocalizCamadaDAO("recuperaPorIdAgenda - idAgenda recebido : ", this.getClass().toString(),nome);
//	//		nome.trim();
//			Query query = em.createQuery("SELECT l.nomeLista FROM Lista l WHERE l.idagenda.idAgenda = :nome");
//			query.setParameter("nome",Integer.valueOf(nome));
//			ArrayList<String> nomesListasArray = (ArrayList<String>) query.getResultList();
//			
//			c.comentaValor("query ","SELECT l FROM Lista l WHERE l.idagenda.idAgenda = :nome");	
//			c.comentaValor("qtd registros recuperados ", String.valueOf(nomesListasArray.size()));
//			return nomesListasArray ;

		}

		@Override
		public void excluir(Integer id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object gravar(Object entidade) {
			// J� IMPLEMENTADO
			
			// TODO Auto-generated method stub
			return null;
		}
		
		public void excluir(Object entidade) 
		{
			
		}





}