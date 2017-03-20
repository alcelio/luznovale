package br.com.luznovale.model.PK;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InternacaoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer idInterno;
	private Integer idInstituicao;
	
	public Integer getIdPessoa() {
		return idInterno;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idInterno = idPessoa;
	}
	public Integer getIdInstituicao() {
		return idInstituicao;
	}
	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInstituicao == null) ? 0 : idInstituicao.hashCode());
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
		InternacaoPK other = (InternacaoPK) obj;
		if (idInstituicao == null) {
			if (other.idInstituicao != null)
				return false;
		} else if (!idInstituicao.equals(other.idInstituicao))
			return false;
		if (idInterno == null) {
			if (other.idInterno != null)
				return false;
		} else if (!idInterno.equals(other.idInterno))
			return false;
		return true;
	}

	
}
