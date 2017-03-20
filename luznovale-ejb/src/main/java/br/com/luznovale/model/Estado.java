package br.com.luznovale.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estado
 *
 */
@Entity
@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private Integer idEstado;
	private String desEstado;
	private String desUF;

	public Estado() {
		super();
	}   
	public Integer getIdEstado() {
		return this.idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}   
	public String getDesEstado() {
		return this.desEstado;
	}
	public void setDesEstado(String desEstado) {
		this.desEstado = desEstado;
	}   
	public String getDesUF() {
		return this.desUF;
	}
	public void setDesUF(String desUF) {
		this.desUF = desUF;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desEstado == null) ? 0 : desEstado.hashCode());
		result = prime * result + ((desUF == null) ? 0 : desUF.hashCode());
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
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
		Estado other = (Estado) obj;
		if (desEstado == null) {
			if (other.desEstado != null)
				return false;
		} else if (!desEstado.equals(other.desEstado))
			return false;
		if (desUF == null) {
			if (other.desUF != null)
				return false;
		} else if (!desUF.equals(other.desUF))
			return false;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		return true;
	}
	
}
