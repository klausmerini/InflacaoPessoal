package com.merini.derbyAgenda.modelo;

import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author Klaus
 */

public class Itemlista implements Serializable 
{  
    private Integer iditemlista;    
    private Integer qtd;   
	private Double valor;    
    private Date data ;    
	private String classificacao;    
    private Item idItem;    
    private Lista idlista;

    public Itemlista() {
    }
    
    public Itemlista(Item item, Lista lista) {
    	setIditem(item);
    	setIdlista(lista);
    }

    public Itemlista(Integer iditemlista) {
        this.iditemlista = iditemlista;
    }
    

    public Date getData() {
		return data;
	}

    public Integer getIditemlista() {
        return iditemlista;
    }

    public Integer getQtd() {
        return qtd;
    }   

    public Item getIditem() {
        return idItem;
    }

    public Lista getIdlista() {
        return idlista;
    }

    public Double getValor() {
		return valor;
	}



	public void setData(Date data) {
		this.data = data;
	}

    
    public void setIditem(Item iditem) {
        this.idItem = iditem;
    }

    public void setIditemlista(Integer iditemlista) {
        this.iditemlista = iditemlista;
    }
    

    public void setIdlista(Lista idlista) {
        this.idlista = idlista;
    }
    
    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
	
	

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditemlista != null ? iditemlista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemlista)) {
            return false;
        }
        Itemlista other = (Itemlista) object;
        if ((this.iditemlista == null && other.iditemlista != null) || (this.iditemlista != null && !this.iditemlista.equals(other.iditemlista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Itemlista[ iditemlista=" + iditemlista + " ]";
    }
    
}
