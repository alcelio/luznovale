package br.com.luznovale.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Endereco
 *
 */
@Entity
@NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
public class Endereco implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer idEndereco;
	private String desEndereco;
	private Integer vlrNumero;
	private String desComplemento;
	private String desCEP;
	private String desBairro;

	@ManyToOne
	@JoinColumn(name="idCidade")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name="idLogradouro")
	private Logradouro logradouro;
	
	@ManyToOne
	@JoinColumn(name="idEstado")
	private Estado estado;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "idIntituicao")
	private Instituicao instituicao;

	
	public Endereco() {
		cidade = new Cidade();
		logradouro = new Logradouro();
		estado = new Estado();
	}
	
	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getDesEndereco() {
		return desEndereco;
	}

	public void setDesEndereco(String desEndereco) {
		this.desEndereco = desEndereco;
	}

	public Integer getNumNumero() {
		return vlrNumero;
	}

	public void setNumNumero(Integer numNumero) {
		this.vlrNumero = numNumero;
	}

	public String getDesComplemento() {
		return desComplemento;
	}

	public void setDesComplemento(String desComplemento) {
		this.desComplemento = desComplemento;
	}

	public String getDesCEP() {
		return desCEP;
	}

	public void setDesCEP(String desCEP) {
		this.desCEP = desCEP;
	}

	public String getDesBairro() {
		return desBairro;
	}

	public void setDesBairro(String desBairro) {
		this.desBairro = desBairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((desBairro == null) ? 0 : desBairro.hashCode());
		result = prime * result + ((desCEP == null) ? 0 : desCEP.hashCode());
		result = prime * result + ((desComplemento == null) ? 0 : desComplemento.hashCode());
		result = prime * result + ((desEndereco == null) ? 0 : desEndereco.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((vlrNumero == null) ? 0 : vlrNumero.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (desBairro == null) {
			if (other.desBairro != null)
				return false;
		} else if (!desBairro.equals(other.desBairro))
			return false;
		if (desCEP == null) {
			if (other.desCEP != null)
				return false;
		} else if (!desCEP.equals(other.desCEP))
			return false;
		if (desComplemento == null) {
			if (other.desComplemento != null)
				return false;
		} else if (!desComplemento.equals(other.desComplemento))
			return false;
		if (desEndereco == null) {
			if (other.desEndereco != null)
				return false;
		} else if (!desEndereco.equals(other.desEndereco))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (vlrNumero == null) {
			if (other.vlrNumero != null)
				return false;
		} else if (!vlrNumero.equals(other.vlrNumero))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}
	
   
}
