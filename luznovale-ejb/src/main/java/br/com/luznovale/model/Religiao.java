package br.com.luznovale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Sexo database table.
 * 
 */
@Entity
@NamedQuery(name = "Religiao.findAll", query = "SELECT r FROM Religiao r")
public class Religiao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idReligiao;
	
	@Column(nullable = false)
	private String dsReligiao;
 
	/**
	 * Construtor da classe 
	 */
	public Religiao() {
	}

	public Integer getIdReligiao() {
		return idReligiao;
	}

	public void setIdReligiao(Integer idReligiao) {
		this.idReligiao = idReligiao;
	}

	public String getDsReligiao() {
		return dsReligiao;
	}

	public void setDsReligiao(String dsReligiao) {
		this.dsReligiao = dsReligiao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsReligiao == null) ? 0 : dsReligiao.hashCode());
		result = prime * result + ((idReligiao == null) ? 0 : idReligiao.hashCode());
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
		Religiao other = (Religiao) obj;
		if (dsReligiao == null) {
			if (other.dsReligiao != null)
				return false;
		} else if (!dsReligiao.equals(other.dsReligiao))
			return false;
		if (idReligiao == null) {
			if (other.idReligiao != null)
				return false;
		} else if (!idReligiao.equals(other.idReligiao))
			return false;
		return true;
	}
	
	
	
	
}