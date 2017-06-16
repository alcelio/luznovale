package br.com.luznovale.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "Pessoa.findAll", query = "SELECT o FROM Pessoa o")
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private Integer idPessoa;
	private String desNomePessoa;
	@Temporal(TemporalType.DATE)
	private Date dtaNascimento;
	@Temporal(TemporalType.DATE)
	private Date dtaCadastro;
	private String desRG;
	private String desCPF;
	private String desCNH;
	private String desCPT;
	private String outrosDocs;
	private String desFone1;
	private String desFone2;
	private String desFone3;
	@Email
	private String desEmail;
	private String desNomePai;
	private String desNomeMae;
	
	@ManyToOne
	@JoinColumn(name="idFuncao")
	private Funcao funcao;
	
	@ManyToOne
	@JoinColumn(name = "idSexo")
	private Sexo sexo;
	
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Pessoa() {
		setSexo(new Sexo());
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getDesNomePessoa() {
		return desNomePessoa;
	}

	public void setDesNomePessoa(String desNomePessoa) {
		this.desNomePessoa = desNomePessoa;
	}

	public Date getDtaNascimento() {
		return dtaNascimento;
	}

	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	public Date getDtaCadastro() {
		return dtaCadastro;
	}

	public void setDtaCadastro(Date dtaCadastro) {
		this.dtaCadastro = dtaCadastro;
	}

	public String getDesRG() {
		return desRG;
	}

	public void setDesRG(String desRG) {
		this.desRG = desRG;
	}

	public String getDesCPF() {
		return desCPF;
	}

	public void setDesCPF(String desCPF) {
		this.desCPF = desCPF;
	}

	public String getDesCNH() {
		return desCNH;
	}

	public void setDesCNH(String desCNH) {
		this.desCNH = desCNH;
	}

	public String getDesCPT() {
		return desCPT;
	}

	public void setDesCPT(String desCPT) {
		this.desCPT = desCPT;
	}

	public String getOutrosDocs() {
		return outrosDocs;
	}

	public void setOutrosDocs(String outrosDocs) {
		this.outrosDocs = outrosDocs;
	}

	public String getDesFone1() {
		return desFone1;
	}

	public void setDesFone1(String desFone1) {
		this.desFone1 = desFone1;
	}

	public String getDesFone2() {
		return desFone2;
	}

	public void setDesFone2(String desFone2) {
		this.desFone2 = desFone2;
	}

	public String getDesFone3() {
		return desFone3;
	}

	public void setDesFone3(String desFone3) {
		this.desFone3 = desFone3;
	}

	public String getDesEmail() {
		return desEmail;
	}

	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}

	public String getDesNomePai() {
		return desNomePai;
	}

	public void setDesNomePai(String desNomePai) {
		this.desNomePai = desNomePai;
	}

	public String getDesNomeMae() {
		return desNomeMae;
	}

	public void setDesNomeMae(String desNomeMae) {
		this.desNomeMae = desNomeMae;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desCNH == null) ? 0 : desCNH.hashCode());
		result = prime * result + ((desCPF == null) ? 0 : desCPF.hashCode());
		result = prime * result + ((desCPT == null) ? 0 : desCPT.hashCode());
		result = prime * result + ((desEmail == null) ? 0 : desEmail.hashCode());
		result = prime * result + ((desFone1 == null) ? 0 : desFone1.hashCode());
		result = prime * result + ((desFone2 == null) ? 0 : desFone2.hashCode());
		result = prime * result + ((desFone3 == null) ? 0 : desFone3.hashCode());
		result = prime * result + ((desNomeMae == null) ? 0 : desNomeMae.hashCode());
		result = prime * result + ((desNomePai == null) ? 0 : desNomePai.hashCode());
		result = prime * result + ((desNomePessoa == null) ? 0 : desNomePessoa.hashCode());
		result = prime * result + ((desRG == null) ? 0 : desRG.hashCode());
		result = prime * result + ((dtaCadastro == null) ? 0 : dtaCadastro.hashCode());
		result = prime * result + ((dtaNascimento == null) ? 0 : dtaNascimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((outrosDocs == null) ? 0 : outrosDocs.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (desCNH == null) {
			if (other.desCNH != null)
				return false;
		} else if (!desCNH.equals(other.desCNH))
			return false;
		if (desCPF == null) {
			if (other.desCPF != null)
				return false;
		} else if (!desCPF.equals(other.desCPF))
			return false;
		if (desCPT == null) {
			if (other.desCPT != null)
				return false;
		} else if (!desCPT.equals(other.desCPT))
			return false;
		if (desEmail == null) {
			if (other.desEmail != null)
				return false;
		} else if (!desEmail.equals(other.desEmail))
			return false;
		if (desFone1 == null) {
			if (other.desFone1 != null)
				return false;
		} else if (!desFone1.equals(other.desFone1))
			return false;
		if (desFone2 == null) {
			if (other.desFone2 != null)
				return false;
		} else if (!desFone2.equals(other.desFone2))
			return false;
		if (desFone3 == null) {
			if (other.desFone3 != null)
				return false;
		} else if (!desFone3.equals(other.desFone3))
			return false;
		if (desNomeMae == null) {
			if (other.desNomeMae != null)
				return false;
		} else if (!desNomeMae.equals(other.desNomeMae))
			return false;
		if (desNomePai == null) {
			if (other.desNomePai != null)
				return false;
		} else if (!desNomePai.equals(other.desNomePai))
			return false;
		if (desNomePessoa == null) {
			if (other.desNomePessoa != null)
				return false;
		} else if (!desNomePessoa.equals(other.desNomePessoa))
			return false;
		if (desRG == null) {
			if (other.desRG != null)
				return false;
		} else if (!desRG.equals(other.desRG))
			return false;
		if (dtaCadastro == null) {
			if (other.dtaCadastro != null)
				return false;
		} else if (!dtaCadastro.equals(other.dtaCadastro))
			return false;
		if (dtaNascimento == null) {
			if (other.dtaNascimento != null)
				return false;
		} else if (!dtaNascimento.equals(other.dtaNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		if (outrosDocs == null) {
			if (other.outrosDocs != null)
				return false;
		} else if (!outrosDocs.equals(other.outrosDocs))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}   
	
	
}
