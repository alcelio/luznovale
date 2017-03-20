package br.com.luznovale.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoLogradouro
 *
 */
@Entity
@NamedQuery(name = "Logradouro.findAll", query = "SELECT o FROM Logradouro o")
public class Logradouro implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private Integer idLogradouro;
	private String desLogradouro;

	public Logradouro() {
		super();
	}

	public Integer getIdLogradouro() {
		return idLogradouro;
	}

	public void setIdLogradouro(Integer idLogradouro) {
		this.idLogradouro = idLogradouro;
	}

	public String getDesLogradouro() {
		return desLogradouro;
	}

	public void setDesLogradouro(String desLogradouro) {
		this.desLogradouro = desLogradouro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desLogradouro == null) ? 0 : desLogradouro.hashCode());
		result = prime * result + ((idLogradouro == null) ? 0 : idLogradouro.hashCode());
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
		Logradouro other = (Logradouro) obj;
		if (desLogradouro == null) {
			if (other.desLogradouro != null)
				return false;
		} else if (!desLogradouro.equals(other.desLogradouro))
			return false;
		if (idLogradouro == null) {
			if (other.idLogradouro != null)
				return false;
		} else if (!idLogradouro.equals(other.idLogradouro))
			return false;
		return true;
	}   
	
}
