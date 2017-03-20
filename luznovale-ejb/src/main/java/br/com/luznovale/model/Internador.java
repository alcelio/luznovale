package br.com.luznovale.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * Classe que impleemente a entidade Internador
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 * 
 * @since 28/02/2017
 *
 */
@Entity
@DiscriminatorValue("Interandor")
@NamedQuery(name = "Internador.findAll", query = "SELECT o FROM Internador o")
public class Internador extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private String grauParentesco;
	

	public Internador() {

	}


	/**
	 * @return the grauParentesco
	 */
	public String getGrauParentesco() {
		return grauParentesco;
	}


	/**
	 * @param grauParentesco the grauParentesco to set
	 */
	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((grauParentesco == null) ? 0 : grauParentesco.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Internador other = (Internador) obj;
		if (grauParentesco == null) {
			if (other.grauParentesco != null)
				return false;
		} else if (!grauParentesco.equals(other.grauParentesco))
			return false;
		return true;
	}


}
