package br.com.luznovale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Classe para representar a entidade Escoalridade
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 28/02/2017
 */
@Entity
@NamedQuery(name = "Escolaridade.findAll", query = "SELECT r FROM Escolaridade r")
public class Escolaridade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idEscolaridade;
	
	@Column(nullable = false)
	private String dsEscolaridade;
 
	/**
	 * Construtor da classe 
	 */
	public Escolaridade() {
	}

	/**
	 * @return the idEscolaridade
	 */
	public Integer getIdEscolaridade() {
		return idEscolaridade;
	}

	/**
	 * @param idEscolaridade the idEscolaridade to set
	 */
	public void setIdEscolaridade(Integer idEscolaridade) {
		this.idEscolaridade = idEscolaridade;
	}

	/**
	 * @return the dsEscolaridade
	 */
	public String getDsEscolaridade() {
		return dsEscolaridade;
	}

	/**
	 * @param dsEscolaridade the dsEscolaridade to set
	 */
	public void setDsEscolaridade(String dsEscolaridade) {
		this.dsEscolaridade = dsEscolaridade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsEscolaridade == null) ? 0 : dsEscolaridade.hashCode());
		result = prime * result + ((idEscolaridade == null) ? 0 : idEscolaridade.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escolaridade other = (Escolaridade) obj;
		if (dsEscolaridade == null) {
			if (other.dsEscolaridade != null)
				return false;
		} else if (!dsEscolaridade.equals(other.dsEscolaridade))
			return false;
		if (idEscolaridade == null) {
			if (other.idEscolaridade != null)
				return false;
		} else if (!idEscolaridade.equals(other.idEscolaridade))
			return false;
		return true;
	}

}