package com.merini.derbyAgenda.dao;

import java.util.List;


public interface FacadeInterf {

	Object carregar(Integer id);

	void excluir(Object entidade);

	void excluir(Integer id);

	Object gravar(Object entidade);

	List obterTodos();
	
	List obterTodosNomes();
	

	Integer recuperaIdPorNome(String nome);

	Object recuperaPorNome(String nome);

}