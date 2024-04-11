package com.merini.derbyAgenda.modelo;

public class Item 
{	// CREATE TABLE item (iditem INT NOT NULL GENERATED ALWAYS AS IDENTITY, nomeitem VARCHAR(70), cor VARCHAR(200), cor VARCHAR(200), descricao VARCHAR(700), PRIMARY KEY(iditem) )
	
	//private String sqlCriaTabelaClassif = "CREATE TABLE classificacao(idclassificacao INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
	//+ "nomeclassificacao VARCHAR(70), cor VARCHAR(200),  descricao VARCHAR(700), PRIMARY KEY(idclassificacao))";
	
	
	private int idItem;	
	
//	private TipoLista idtipo;
	
	private String nomeItem;
	
	private String cor;
	
	private String lugar; 
	
	private String descricao;

	
	public Item()
	{
		
	}
	
	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public TipoLista getTipoDeListaDoItem() {
//		return tipoDeListaDoItem;
//	}
//
//	public void setTipoDeListaDoItem(TipoLista tipoDeListaDoItem) {
//		this.tipoDeListaDoItem = tipoDeListaDoItem;
//	}

}
