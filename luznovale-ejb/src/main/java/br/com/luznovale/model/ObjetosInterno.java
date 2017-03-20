package br.com.luznovale.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.luznovale.model.PK.ObjetosInternoPK;

/**
 * Entity implementation class for Entity: ObjetosInterno
 *
 */
@Entity
@NamedQuery(name = "ObjetosInterno.findAll", query = "SELECT o FROM ObjetosInterno o")
public class ObjetosInterno implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@EmbeddedId
	ObjetosInternoPK id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaRecebimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaDevolucao;
	
	private Integer quantidade;
	/**
	 * Se o objeto ja tiver sido devolvido pelo Interno deverá estar marcado como true = 1;
	 */
	private boolean devolvida;

	//bi-directional many-to-one association to Objeto
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idObjeto", insertable=false, updatable=false  )
	private Objeto objeto;

	//bi-directional many-to-one association to Interno
	@ManyToOne//(fetch = FetchType.EAGER)
	@JoinColumn(name="idInterno", insertable=false, updatable=false)
	private Interno interno;

	public ObjetosInterno() {
	}

	public ObjetosInternoPK getId() {
		return id;
	}

	public void setId(ObjetosInternoPK id) {
		this.id = id;
	}

	public Date getDtaRecebimento() {
		return dtaRecebimento;
	}

	public void setDtaRecebimento(Date dtaRecebimento) {
		this.dtaRecebimento = dtaRecebimento;
	}

	public Date getDtaDevolucao() {
		return dtaDevolucao;
	}

	public void setDtaDevolucao(Date dtaDevolucao) {
		this.dtaDevolucao = dtaDevolucao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isDevolvida() {
		return devolvida;
	}

	public void setDevolvida(boolean devolvida) {
		this.devolvida = devolvida;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public Interno getInterno() {
		return interno;
	}

	public void setInterno(Interno interno) {
		this.interno = interno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (devolvida ? 1231 : 1237);
		result = prime * result + ((dtaDevolucao == null) ? 0 : dtaDevolucao.hashCode());
		result = prime * result + ((dtaRecebimento == null) ? 0 : dtaRecebimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((interno == null) ? 0 : interno.hashCode());
		result = prime * result + ((objeto == null) ? 0 : objeto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
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
		ObjetosInterno other = (ObjetosInterno) obj;
		if (devolvida != other.devolvida)
			return false;
		if (dtaDevolucao == null) {
			if (other.dtaDevolucao != null)
				return false;
		} else if (!dtaDevolucao.equals(other.dtaDevolucao))
			return false;
		if (dtaRecebimento == null) {
			if (other.dtaRecebimento != null)
				return false;
		} else if (!dtaRecebimento.equals(other.dtaRecebimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (interno == null) {
			if (other.interno != null)
				return false;
		} else if (!interno.equals(other.interno))
			return false;
		if (objeto == null) {
			if (other.objeto != null)
				return false;
		} else if (!objeto.equals(other.objeto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		return true;
	} 
	
	
   
}
