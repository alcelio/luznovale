package br.com.luznovale.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Comparator;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Objetos
 *
 */
@Entity
@NamedQuery(name = "Objeto.findAll", query = "SELECT o FROM Objeto o")
public class Objeto implements Serializable, Comparator<Objeto> {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idObjeto;
	private String desObjeto;

	public Objeto() {
		super();
	}
	

	public String getDesObjeto() {
		return desObjeto;
	}

	public void setDesObjeto(String desObjeto) {
		this.desObjeto = desObjeto;
	}


	public Integer getIdObjeto() {
		return idObjeto;
	}


	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desObjeto == null) ? 0 : desObjeto.hashCode());
		result = prime * result + ((idObjeto == null) ? 0 : idObjeto.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objeto other = (Objeto) obj;
		if (desObjeto == null) {
			if (other.desObjeto != null)
				return false;
		} else if (!desObjeto.equals(other.desObjeto))
			return false;
		if (idObjeto == null) {
			if (other.idObjeto != null)
				return false;
		} else if (!idObjeto.equals(other.idObjeto))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return this.getDesObjeto();
	}


	@Override
	public int compare(Objeto o1, Objeto o2) {
		return o1.getDesObjeto().compareTo(o2.getDesObjeto());
	}
   
}
