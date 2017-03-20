package br.com.luznovale.model.PK;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ObjetosInternoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer idInterno;
	private Integer idObjeto;
	public Integer getIdPessoa() {
		return idInterno;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idInterno = idPessoa;
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
		result = prime * result + ((idObjeto == null) ? 0 : idObjeto.hashCode());
		result = prime * result + ((idInterno == null) ? 0 : idInterno.hashCode());
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
		ObjetosInternoPK other = (ObjetosInternoPK) obj;
		if (idObjeto == null) {
			if (other.idObjeto != null)
				return false;
		} else if (!idObjeto.equals(other.idObjeto))
			return false;
		if (idInterno == null) {
			if (other.idInterno != null)
				return false;
		} else if (!idInterno.equals(other.idInterno))
			return false;
		return true;
	}
	
	
}
