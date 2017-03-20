package br.com.luznovale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: ParametrosUsuario
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 * 
 * @since 22/02/2017
 */

@Entity
@NamedQuery(name = "ParametrosSistema.findAll", query = "SELECT a FROM ParametrosSistema a")
public class ParametrosSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idParametroSistema;

	@Column(updatable=false)
	private String descricaoParametro;
	
	private String funcaoParametro;
	@Column(length= 500, nullable=false)	
	private String desValorParametro;
	

	public ParametrosSistema() {
	}


	/**
	 * @return the idParametroSistema
	 */
	public Integer getIdParametroSistema() {
		return idParametroSistema;
	}


	/**
	 * @param idParametroSistema the idParametroSistema to set
	 */
	public void setIdParametroSistema(Integer idParametroSistema) {
		this.idParametroSistema = idParametroSistema;
	}


	/**
	 * @return the descricaoParametro
	 */
	public String getDescricaoParametro() {
		return descricaoParametro;
	}


	/**
	 * @param descricaoParametro the descricaoParametro to set
	 */
	public void setDescricaoParametro(String descricaoParametro) {
		this.descricaoParametro = descricaoParametro;
	}


	/**
	 * @return the funcaoParametro
	 */
	public String getFuncaoParametro() {
		return funcaoParametro;
	}


	/**
	 * @param funcaoParametro the funcaoParametro to set
	 */
	public void setFuncaoParametro(String funcaoParametro) {
		this.funcaoParametro = funcaoParametro;
	}


	/**
	 * @return the desValorParametro
	 */
	public String getDesValorParametro() {
		return desValorParametro;
	}


	/**
	 * @param desValorParametro the desValorParametro to set
	 */
	public void setDesValorParametro(String desValorParametro) {
		this.desValorParametro = desValorParametro;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desValorParametro == null) ? 0 : desValorParametro.hashCode());
		result = prime * result + ((descricaoParametro == null) ? 0 : descricaoParametro.hashCode());
		result = prime * result + ((funcaoParametro == null) ? 0 : funcaoParametro.hashCode());
		result = prime * result + ((idParametroSistema == null) ? 0 : idParametroSistema.hashCode());
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
		ParametrosSistema other = (ParametrosSistema) obj;
		if (desValorParametro == null) {
			if (other.desValorParametro != null)
				return false;
		} else if (!desValorParametro.equals(other.desValorParametro))
			return false;
		if (descricaoParametro == null) {
			if (other.descricaoParametro != null)
				return false;
		} else if (!descricaoParametro.equals(other.descricaoParametro))
			return false;
		if (funcaoParametro == null) {
			if (other.funcaoParametro != null)
				return false;
		} else if (!funcaoParametro.equals(other.funcaoParametro))
			return false;
		if (idParametroSistema == null) {
			if (other.idParametroSistema != null)
				return false;
		} else if (!idParametroSistema.equals(other.idParametroSistema))
			return false;
		return true;
	}



	
}
