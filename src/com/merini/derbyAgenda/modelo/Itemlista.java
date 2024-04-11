package com.merini.derbyAgenda.modelo;

import java.io.Serializable;
/**
 *
 * @author Klaus
 */

public class Itemlista implements Serializable 
{  
    private Integer iditemlista;
    
    private Integer qtd;
    
    private String lugar;
    
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

    public Integer getIditemlista() {
        return iditemlista;
    }

    public void setIditemlista(Integer iditemlista) {
        this.iditemlista = iditemlista;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Item getIditem() {
        return idItem;
    }

    public void setIditem(Item iditem) {
        this.idItem = iditem;
    }

    public Lista getIdlista() {
        return idlista;
    }

    public void setIdlista(Lista idlista) {
        this.idlista = idlista;
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
