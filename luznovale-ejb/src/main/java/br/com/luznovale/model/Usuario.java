package br.com.luznovale.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@DiscriminatorValue("Usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT p FROM Usuario p")
public class Usuario extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	private Boolean primeiroAcesso;
	private Boolean isAtivo;
	private Boolean isAdminUser;
	private Boolean isSuperUser;
	private Boolean isUser;
	
	@ManyToMany(fetch  =FetchType.EAGER)
	@JoinTable(name = "permissao_usuario", joinColumns = { @JoinColumn(name = "idPessoa") }, inverseJoinColumns = {
			@JoinColumn(name = "idPermissao") })
	private Set<Permissao> permissoes = new HashSet<Permissao>();

	public Usuario() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(Boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Boolean getIsAdminUser() {
		return isAdminUser;
	}

	public void setIsAdminUser(Boolean isAdminUser) {
		this.isAdminUser = isAdminUser;
	}

	public Boolean getIsSuperUser() {
		return isSuperUser;
	}

	public void setIsSuperUser(Boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}

	public Boolean getIsUser() {
		return isUser;
	}

	public void setIsUser(Boolean isUser) {
		this.isUser = isUser;
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((isAdminUser == null) ? 0 : isAdminUser.hashCode());
		result = prime * result + ((isAtivo == null) ? 0 : isAtivo.hashCode());
		result = prime * result + ((isSuperUser == null) ? 0 : isSuperUser.hashCode());
		result = prime * result + ((isUser == null) ? 0 : isUser.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((permissoes == null) ? 0 : permissoes.hashCode());
		result = prime * result + ((primeiroAcesso == null) ? 0 : primeiroAcesso.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (isAdminUser == null) {
			if (other.isAdminUser != null)
				return false;
		} else if (!isAdminUser.equals(other.isAdminUser))
			return false;
		if (isAtivo == null) {
			if (other.isAtivo != null)
				return false;
		} else if (!isAtivo.equals(other.isAtivo))
			return false;
		if (isSuperUser == null) {
			if (other.isSuperUser != null)
				return false;
		} else if (!isSuperUser.equals(other.isSuperUser))
			return false;
		if (isUser == null) {
			if (other.isUser != null)
				return false;
		} else if (!isUser.equals(other.isUser))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (permissoes == null) {
			if (other.permissoes != null)
				return false;
		} else if (!permissoes.equals(other.permissoes))
			return false;
		if (primeiroAcesso == null) {
			if (other.primeiroAcesso != null)
				return false;
		} else if (!primeiroAcesso.equals(other.primeiroAcesso))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	
}
