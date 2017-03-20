package br.com.luznovale.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Funcoes
 *
 */
@Entity
@NamedQuery(name = "Funcao.findAll", query = "SELECT o FROM Funcao o")
public class Funcao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idFuncao;
	private String desFuncao;

	public Funcao() {
	}   
	public Integer getIdFuncao() {
		return this.idFuncao;
	}

	public void setIdFuncao(Integer idFuncao) {
		this.idFuncao = idFuncao;
	}   
	public String getDesFuncao() {
		return this.desFuncao;
	}

	public void setDesFuncao(String desFuncao) {
		this.desFuncao = desFuncao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desFuncao == null) ? 0 : desFuncao.hashCode());
		result = prime * result + ((idFuncao == null) ? 0 : idFuncao.hashCode());
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
		Funcao other = (Funcao) obj;
		if (desFuncao == null) {
			if (other.desFuncao != null)
				return false;
		} else if (!desFuncao.equals(other.desFuncao))
			return false;
		if (idFuncao == null) {
			if (other.idFuncao != null)
				return false;
		} else if (!idFuncao.equals(other.idFuncao))
			return false;
		return true;
	}
   
}
