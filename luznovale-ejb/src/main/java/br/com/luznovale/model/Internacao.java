package br.com.luznovale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Classe de implementação para a entidade Internacao
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 */
@Entity
public class Internacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idInternacao;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "idInterno")
//	@JoinColumn(name = "idInterno", insertable = false, updatable = false)
	private Interno interno;

	// bi-directional many-to-one association to Instituicao
	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "idIntituicao", insertable = false, updatable = false)
	@JoinColumn(name = "idIntituicao")
	private Instituicao instituicao;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idInterandor")
	private Internador internador;
	
	@ManyToOne
	@JoinColumn(name = "idUsuarioInterandor")
	private Usuario usuarioInternador;
	
	@OneToMany(fetch = FetchType.EAGER)
	List<ObjetosInterno> objetos;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaEntrada;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaSaida;
	
	private BigDecimal vlrFundoPassagem;
	
	private String desObesevacao;
	
	private BigDecimal taxaInscricao;
	
	public Internacao() {
		setObjetos(new ArrayList<ObjetosInterno>());
		setInterno(new Interno());
		setInternador(new Internador());
	}

	/**
	 * @return the idInternacao
	 */
	public Integer getIdInternacao() {
		return idInternacao;
	}

	/**
	 * @param idInternacao the idInternacao to set
	 */
	public void setIdInternacao(Integer idInternacao) {
		this.idInternacao = idInternacao;
	}

	/**
	 * @return the interno
	 */
	public Interno getInterno() {
		return interno;
	}

	/**
	 * @param interno the interno to set
	 */
	public void setInterno(Interno interno) {
		this.interno = interno;
	}

	/**
	 * @return the instituicao
	 */
	public Instituicao getInstituicao() {
		return instituicao;
	}

	/**
	 * @param instituicao the instituicao to set
	 */
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	/**
	 * @return the internador
	 */
	public Internador getInternador() {
		return internador;
	}

	/**
	 * @param internador the internador to set
	 */
	public void setInternador(Internador internador) {
		this.internador = internador;
	}

	/**
	 * @return the usuarioInternador
	 */
	public Usuario getUsuarioInternador() {
		return usuarioInternador;
	}

	/**
	 * @param usuarioInternador the usuarioInternador to set
	 */
	public void setUsuarioInternador(Usuario usuarioInternador) {
		this.usuarioInternador = usuarioInternador;
	}

	/**
	 * @return the objetos
	 */
	public List<ObjetosInterno> getObjetos() {
		return objetos;
	}

	/**
	 * @param objetos the objetos to set
	 */
	public void setObjetos(List<ObjetosInterno> objetos) {
		this.objetos = objetos;
	}

	/**
	 * @return the dtaEntrada
	 */
	public Date getDtaEntrada() {
		return dtaEntrada;
	}

	/**
	 * @param dtaEntrada the dtaEntrada to set
	 */
	public void setDtaEntrada(Date dtaEntrada) {
		this.dtaEntrada = dtaEntrada;
	}

	/**
	 * @return the dtaSaida
	 */
	public Date getDtaSaida() {
		return dtaSaida;
	}

	/**
	 * @param dtaSaida the dtaSaida to set
	 */
	public void setDtaSaida(Date dtaSaida) {
		this.dtaSaida = dtaSaida;
	}

	/**
	 * @return the vlrFundoPassagem
	 */
	public BigDecimal getVlrFundoPassagem() {
		return vlrFundoPassagem;
	}

	/**
	 * @param vlrFundoPassagem the vlrFundoPassagem to set
	 */
	public void setVlrFundoPassagem(BigDecimal vlrFundoPassagem) {
		this.vlrFundoPassagem = vlrFundoPassagem;
	}

	/**
	 * @return the desObesevacao
	 */
	public String getDesObesevacao() {
		return desObesevacao;
	}

	/**
	 * @param desObesevacao the desObesevacao to set
	 */
	public void setDesObesevacao(String desObesevacao) {
		this.desObesevacao = desObesevacao;
	}

	/**
	 * @return the taxaInscricao
	 */
	public BigDecimal getTaxaInscricao() {
		return taxaInscricao;
	}

	/**
	 * @param taxaInscricao the taxaInscricao to set
	 */
	public void setTaxaInscricao(BigDecimal taxaInscricao) {
		this.taxaInscricao = taxaInscricao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desObesevacao == null) ? 0 : desObesevacao.hashCode());
		result = prime * result + ((dtaEntrada == null) ? 0 : dtaEntrada.hashCode());
		result = prime * result + ((dtaSaida == null) ? 0 : dtaSaida.hashCode());
		result = prime * result + ((idInternacao == null) ? 0 : idInternacao.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((internador == null) ? 0 : internador.hashCode());
		result = prime * result + ((interno == null) ? 0 : interno.hashCode());
		result = prime * result + ((objetos == null) ? 0 : objetos.hashCode());
		result = prime * result + ((taxaInscricao == null) ? 0 : taxaInscricao.hashCode());
		result = prime * result + ((usuarioInternador == null) ? 0 : usuarioInternador.hashCode());
		result = prime * result + ((vlrFundoPassagem == null) ? 0 : vlrFundoPassagem.hashCode());
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
		Internacao other = (Internacao) obj;
		if (desObesevacao == null) {
			if (other.desObesevacao != null)
				return false;
		} else if (!desObesevacao.equals(other.desObesevacao))
			return false;
		if (dtaEntrada == null) {
			if (other.dtaEntrada != null)
				return false;
		} else if (!dtaEntrada.equals(other.dtaEntrada))
			return false;
		if (dtaSaida == null) {
			if (other.dtaSaida != null)
				return false;
		} else if (!dtaSaida.equals(other.dtaSaida))
			return false;
		if (idInternacao == null) {
			if (other.idInternacao != null)
				return false;
		} else if (!idInternacao.equals(other.idInternacao))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (internador == null) {
			if (other.internador != null)
				return false;
		} else if (!internador.equals(other.internador))
			return false;
		if (interno == null) {
			if (other.interno != null)
				return false;
		} else if (!interno.equals(other.interno))
			return false;
		if (objetos == null) {
			if (other.objetos != null)
				return false;
		} else if (!objetos.equals(other.objetos))
			return false;
		if (taxaInscricao == null) {
			if (other.taxaInscricao != null)
				return false;
		} else if (!taxaInscricao.equals(other.taxaInscricao))
			return false;
		if (usuarioInternador == null) {
			if (other.usuarioInternador != null)
				return false;
		} else if (!usuarioInternador.equals(other.usuarioInternador))
			return false;
		if (vlrFundoPassagem == null) {
			if (other.vlrFundoPassagem != null)
				return false;
		} else if (!vlrFundoPassagem.equals(other.vlrFundoPassagem))
			return false;
		return true;
	}
	


	
}
