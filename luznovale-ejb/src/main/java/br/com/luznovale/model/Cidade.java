package br.com.luznovale.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cidade
 *
 * @author "Alcélio Gomes  {@link doalcelio@gmail.com}"
 *
 *@since 20/02/2017
 *
 */
@Entity
@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private Integer idCidade;
	private String desNomeCidade;

	public Cidade() {
	}   
	public Integer getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}   
	public String getDesNomeCidade() {
		return this.desNomeCidade;
	}

	public void setDesNomeCidade(String desNomeCidade) {
		this.desNomeCidade = desNomeCidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desNomeCidade == null) ? 0 : desNomeCidade.hashCode());
		result = prime * result + ((idCidade == null) ? 0 : idCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (desNomeCidade == null) {
			if (other.desNomeCidade != null)
				return false;
		} else if (!desNomeCidade.equals(other.desNomeCidade))
			return false;
		if (idCidade == null) {
			if (other.idCidade != null)
				return false;
		} else if (!idCidade.equals(other.idCidade))
			return false;
		return true;
	}
   
}
