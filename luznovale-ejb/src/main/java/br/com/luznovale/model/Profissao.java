package br.com.luznovale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Classe para representar a entidade Profissao
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 28/02/2017
 */
@Entity
@NamedQuery(name = "Profissao.findAll", query = "SELECT r FROM Profissao r")
public class Profissao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idProfissao;
	
	@Column(nullable = false)
	private String dsProfissao;
 
	/**
	 * Construtor da classe 
	 */
	public Profissao() {
	}

	/**
	 * @return the idProfissao
	 */
	public Integer getIdProfissao() {
		return idProfissao;
	}

	/**
	 * @param idProfissao the idProfissao to set
	 */
	public void setIdProfissao(Integer idProfissao) {
		this.idProfissao = idProfissao;
	}

	/**
	 * @return the dsProfissao
	 */
	public String getDsProfissao() {
		return dsProfissao;
	}

	/**
	 * @param dsProfissao the dsProfissao to set
	 */
	public void setDsProfissao(String dsProfissao) {
		this.dsProfissao = dsProfissao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsProfissao == null) ? 0 : dsProfissao.hashCode());
		result = prime * result + ((idProfissao == null) ? 0 : idProfissao.hashCode());
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
		Profissao other = (Profissao) obj;
		if (dsProfissao == null) {
			if (other.dsProfissao != null)
				return false;
		} else if (!dsProfissao.equals(other.dsProfissao))
			return false;
		if (idProfissao == null) {
			if (other.idProfissao != null)
				return false;
		} else if (!idProfissao.equals(other.idProfissao))
			return false;
		return true;
	}



	
	
}