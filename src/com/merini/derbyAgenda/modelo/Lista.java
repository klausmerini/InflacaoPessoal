package com.merini.derbyAgenda.modelo;


import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Klaus
 */

public class Lista implements Serializable {

    private Integer idlista;
    
    private String nomeLista;
    
    private String descrlista;
    
 //   private Agenda idagenda;
    private Collection<Itemlista> itemlistaCollection;
    

    public Lista() {
    }

    public Lista(Integer idlista) {
        this.idlista = idlista;
    }

    public Integer getIdlista() {
        return idlista;
    }

    public void setIdlista(Integer idlista) {
        this.idlista = idlista;
    }

    public String getNomelista() {
        return nomeLista;
    }

    public void setNomelista(String nomelista) {
        this.nomeLista = nomelista;
    }

    public String getDescrlista() {
        return descrlista;
    }

    public void setDescrlista(String descrlista) {
        this.descrlista = descrlista;
    }
//
//    public Agenda getIdagenda() {
//        return idagenda;
//    }
//
//    public void setIdagenda(Agenda idagenda) {
//        this.idagenda = idagenda;
//    }

    public Collection<Itemlista> getItemlistaCollection() {
        return itemlistaCollection;
    }

    public void setItemlistaCollection(Collection<Itemlista> itemlistaCollection) {
        this.itemlistaCollection = itemlistaCollection;
    }


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idlista != null ? idlista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.idlista == null && other.idlista != null) || (this.idlista != null && !this.idlista.equals(other.idlista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lista[ idlista=" + idlista + " ]";
    }
    
}
