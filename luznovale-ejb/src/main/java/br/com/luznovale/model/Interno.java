package br.com.luznovale.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Classe que implementa a entidade Interno;
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 28/02/2017
 */
@Entity
@DiscriminatorValue("Interno")
@NamedQuery(name = "Interno.findAll", query = "SELECT o FROM Interno o")
public class Interno extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private boolean esteveInternado;
	
	private String tempoInternado;
	
	private String moraCom;

	private boolean relacaoFamiliaMal;
	
	private boolean relacaoFamiliaBoa;
	
	private boolean relacaoFamiliaRegular;
	
	private boolean relacaoFamiliaOtima;
	
	private boolean trabalhaSim;
	
	private boolean trabalhaNao;
	
	private String trabalhaOnde;
	
	private String tempoTrabalho;
	
	private String tempoSemTrabalhar;
	
	private boolean problemaTrabalhista;
	
	private boolean problemaJustica;
	
	private boolean problemaSaude;
	
	private String ostrosProblemas;
	
	private boolean docEntradaRG;
	
	private boolean docEntradaCPF;
	
	private boolean docEntradaCPT;
	
	private boolean docEntradaCarteiraVacina;
	
	private boolean docEntradaCertNascimento;
	
	private boolean docEntradaTercerira;
	
	private boolean docEntradaCartaoSUS;
	
	private boolean docEntradaPassaporte;
	
	private boolean docEntradaLaudoMedico;
	
	private boolean docEntradaSemDocumentos;
	
	
	@OneToMany
	private Set<Instituicao> instituição;
	
	@ManyToOne
	@JoinColumn(name = "idReligiao")
	private Religiao religiao;
	
	@ManyToOne
	@JoinColumn(name = "idProfissao")
	private Profissao profissao;
	
	@ManyToOne
	@JoinColumn(name = "idEscolaridade")
	private Escolaridade escolaridade;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Droga> drogas;
	
	@OneToMany
	private List<Instituicao> interncaoesInternado;
	
	/**
	 * Construtor da classe
	 */
	public Interno() {
		setEndereco(new Endereco());
		setSexo(new Sexo());
		setReligiao(new Religiao());
		setProfissao(new Profissao());
		setEscolaridade(new Escolaridade());
		setDrogas(new ArrayList<Droga>());
		
	}

	/**
	 * @return the esteveInternado
	 */
	public boolean isEsteveInternado() {
		return esteveInternado;
	}

	/**
	 * @param esteveInternado the esteveInternado to set
	 */
	public void setEsteveInternado(boolean esteveInternado) {
		this.esteveInternado = esteveInternado;
	}

	/**
	 * @return the tempoInternado
	 */
	public String getTempoInternado() {
		return tempoInternado;
	}

	/**
	 * @param tempoInternado the tempoInternado to set
	 */
	public void setTempoInternado(String tempoInternado) {
		this.tempoInternado = tempoInternado;
	}

	/**
	 * @return the moraCom
	 */
	public String getMoraCom() {
		return moraCom;
	}

	/**
	 * @param moraCom the moraCom to set
	 */
	public void setMoraCom(String moraCom) {
		this.moraCom = moraCom;
	}

	/**
	 * @return the relacaoFamiliaMal
	 */
	public boolean isRelacaoFamiliaMal() {
		return relacaoFamiliaMal;
	}

	/**
	 * @param relacaoFamiliaMal the relacaoFamiliaMal to set
	 */
	public void setRelacaoFamiliaMal(boolean relacaoFamiliaMal) {
		this.relacaoFamiliaMal = relacaoFamiliaMal;
	}

	/**
	 * @return the relacaoFamiliaBoa
	 */
	public boolean isRelacaoFamiliaBoa() {
		return relacaoFamiliaBoa;
	}

	/**
	 * @param relacaoFamiliaBoa the relacaoFamiliaBoa to set
	 */
	public void setRelacaoFamiliaBoa(boolean relacaoFamiliaBoa) {
		this.relacaoFamiliaBoa = relacaoFamiliaBoa;
	}

	/**
	 * @return the relacaoFamiliaRegular
	 */
	public boolean isRelacaoFamiliaRegular() {
		return relacaoFamiliaRegular;
	}

	/**
	 * @param relacaoFamiliaRegular the relacaoFamiliaRegular to set
	 */
	public void setRelacaoFamiliaRegular(boolean relacaoFamiliaRegular) {
		this.relacaoFamiliaRegular = relacaoFamiliaRegular;
	}

	/**
	 * @return the relacaoFamiliaOtima
	 */
	public boolean isRelacaoFamiliaOtima() {
		return relacaoFamiliaOtima;
	}

	/**
	 * @param relacaoFamiliaOtima the relacaoFamiliaOtima to set
	 */
	public void setRelacaoFamiliaOtima(boolean relacaoFamiliaOtima) {
		this.relacaoFamiliaOtima = relacaoFamiliaOtima;
	}

	/**
	 * @return the trabalhaSim
	 */
	public boolean isTrabalhaSim() {
		return trabalhaSim;
	}

	/**
	 * @param trabalhaSim the trabalhaSim to set
	 */
	public void setTrabalhaSim(boolean trabalhaSim) {
		this.trabalhaSim = trabalhaSim;
	}

	/**
	 * @return the trabalhaNao
	 */
	public boolean isTrabalhaNao() {
		return trabalhaNao;
	}

	/**
	 * @param trabalhaNao the trabalhaNao to set
	 */
	public void setTrabalhaNao(boolean trabalhaNao) {
		this.trabalhaNao = trabalhaNao;
	}

	/**
	 * @return the trabalhaOnde
	 */
	public String getTrabalhaOnde() {
		return trabalhaOnde;
	}

	/**
	 * @param trabalhaOnde the trabalhaOnde to set
	 */
	public void setTrabalhaOnde(String trabalhaOnde) {
		this.trabalhaOnde = trabalhaOnde;
	}

	/**
	 * @return the tempoTrabalho
	 */
	public String getTempoTrabalho() {
		return tempoTrabalho;
	}

	/**
	 * @param tempoTrabalho the tempoTrabalho to set
	 */
	public void setTempoTrabalho(String tempoTrabalho) {
		this.tempoTrabalho = tempoTrabalho;
	}

	/**
	 * @return the tempoSemTrabalhar
	 */
	public String getTempoSemTrabalhar() {
		return tempoSemTrabalhar;
	}

	/**
	 * @param tempoSemTrabalhar the tempoSemTrabalhar to set
	 */
	public void setTempoSemTrabalhar(String tempoSemTrabalhar) {
		this.tempoSemTrabalhar = tempoSemTrabalhar;
	}

	/**
	 * @return the problemaTrabalhista
	 */
	public boolean isProblemaTrabalhista() {
		return problemaTrabalhista;
	}

	/**
	 * @param problemaTrabalhista the problemaTrabalhista to set
	 */
	public void setProblemaTrabalhista(boolean problemaTrabalhista) {
		this.problemaTrabalhista = problemaTrabalhista;
	}

	/**
	 * @return the problemaJustica
	 */
	public boolean isProblemaJustica() {
		return problemaJustica;
	}

	/**
	 * @param problemaJustica the problemaJustica to set
	 */
	public void setProblemaJustica(boolean problemaJustica) {
		this.problemaJustica = problemaJustica;
	}

	/**
	 * @return the problemaSaude
	 */
	public boolean isProblemaSaude() {
		return problemaSaude;
	}

	/**
	 * @param problemaSaude the problemaSaude to set
	 */
	public void setProblemaSaude(boolean problemaSaude) {
		this.problemaSaude = problemaSaude;
	}

	/**
	 * @return the ostrosProblemas
	 */
	public String getOstrosProblemas() {
		return ostrosProblemas;
	}

	/**
	 * @param ostrosProblemas the ostrosProblemas to set
	 */
	public void setOstrosProblemas(String ostrosProblemas) {
		this.ostrosProblemas = ostrosProblemas;
	}

	/**
	 * @return the docEntradaRG
	 */
	public boolean isDocEntradaRG() {
		return docEntradaRG;
	}

	/**
	 * @param docEntradaRG the docEntradaRG to set
	 */
	public void setDocEntradaRG(boolean docEntradaRG) {
		this.docEntradaRG = docEntradaRG;
	}

	/**
	 * @return the docEntradaCPF
	 */
	public boolean isDocEntradaCPF() {
		return docEntradaCPF;
	}

	/**
	 * @param docEntradaCPF the docEntradaCPF to set
	 */
	public void setDocEntradaCPF(boolean docEntradaCPF) {
		this.docEntradaCPF = docEntradaCPF;
	}

	/**
	 * @return the docEntradaCPT
	 */
	public boolean isDocEntradaCPT() {
		return docEntradaCPT;
	}

	/**
	 * @param docEntradaCPT the docEntradaCPT to set
	 */
	public void setDocEntradaCPT(boolean docEntradaCPT) {
		this.docEntradaCPT = docEntradaCPT;
	}

	/**
	 * @return the docEntradaCarteiraVacina
	 */
	public boolean isDocEntradaCarteiraVacina() {
		return docEntradaCarteiraVacina;
	}

	/**
	 * @param docEntradaCarteiraVacina the docEntradaCarteiraVacina to set
	 */
	public void setDocEntradaCarteiraVacina(boolean docEntradaCarteiraVacina) {
		this.docEntradaCarteiraVacina = docEntradaCarteiraVacina;
	}

	/**
	 * @return the docEntradaCertNascimento
	 */
	public boolean isDocEntradaCertNascimento() {
		return docEntradaCertNascimento;
	}

	/**
	 * @param docEntradaCertNascimento the docEntradaCertNascimento to set
	 */
	public void setDocEntradaCertNascimento(boolean docEntradaCertNascimento) {
		this.docEntradaCertNascimento = docEntradaCertNascimento;
	}

	/**
	 * @return the docEntradaTercerira
	 */
	public boolean isDocEntradaTercerira() {
		return docEntradaTercerira;
	}

	/**
	 * @param docEntradaTercerira the docEntradaTercerira to set
	 */
	public void setDocEntradaTercerira(boolean docEntradaTercerira) {
		this.docEntradaTercerira = docEntradaTercerira;
	}

	/**
	 * @return the docEntradaCartaoSUS
	 */
	public boolean isDocEntradaCartaoSUS() {
		return docEntradaCartaoSUS;
	}

	/**
	 * @param docEntradaCartaoSUS the docEntradaCartaoSUS to set
	 */
	public void setDocEntradaCartaoSUS(boolean docEntradaCartaoSUS) {
		this.docEntradaCartaoSUS = docEntradaCartaoSUS;
	}

	/**
	 * @return the docEntradaPassaporte
	 */
	public boolean isDocEntradaPassaporte() {
		return docEntradaPassaporte;
	}

	/**
	 * @param docEntradaPassaporte the docEntradaPassaporte to set
	 */
	public void setDocEntradaPassaporte(boolean docEntradaPassaporte) {
		this.docEntradaPassaporte = docEntradaPassaporte;
	}

	/**
	 * @return the docEntradaLaudoMedico
	 */
	public boolean isDocEntradaLaudoMedico() {
		return docEntradaLaudoMedico;
	}

	/**
	 * @param docEntradaLaudoMedico the docEntradaLaudoMedico to set
	 */
	public void setDocEntradaLaudoMedico(boolean docEntradaLaudoMedico) {
		this.docEntradaLaudoMedico = docEntradaLaudoMedico;
	}

	/**
	 * @return the docEntradaSemDocumentos
	 */
	public boolean isDocEntradaSemDocumentos() {
		return docEntradaSemDocumentos;
	}

	/**
	 * @param docEntradaSemDocumentos the docEntradaSemDocumentos to set
	 */
	public void setDocEntradaSemDocumentos(boolean docEntradaSemDocumentos) {
		this.docEntradaSemDocumentos = docEntradaSemDocumentos;
	}

	/**
	 * @return the instituição
	 */
	public Set<Instituicao> getInstituição() {
		return instituição;
	}

	/**
	 * @param instituição the instituição to set
	 */
	public void setInstituição(Set<Instituicao> instituição) {
		this.instituição = instituição;
	}

	/**
	 * @return the religiao
	 */
	public Religiao getReligiao() {
		return religiao;
	}

	/**
	 * @param religiao the religiao to set
	 */
	public void setReligiao(Religiao religiao) {
		this.religiao = religiao;
	}

	/**
	 * @return the profissao
	 */
	public Profissao getProfissao() {
		return profissao;
	}

	/**
	 * @param profissao the profissao to set
	 */
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	/**
	 * @return the escolaridade
	 */
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	/**
	 * @param escolaridade the escolaridade to set
	 */
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	/**
	 * @return the drogas
	 */
	public List<Droga> getDrogas() {
		return drogas;
	}

	/**
	 * @param drogas the drogas to set
	 */
	public void setDrogas(List<Droga> drogas) {
		this.drogas = drogas;
	}

	/**
	 * @return the interncaoesInternado
	 */
	public List<Instituicao> getInterncaoesInternado() {
		return interncaoesInternado;
	}

	/**
	 * @param interncaoesInternado the interncaoesInternado to set
	 */
	public void setInterncaoesInternado(List<Instituicao> interncaoesInternado) {
		this.interncaoesInternado = interncaoesInternado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (docEntradaCPF ? 1231 : 1237);
		result = prime * result + (docEntradaCPT ? 1231 : 1237);
		result = prime * result + (docEntradaCartaoSUS ? 1231 : 1237);
		result = prime * result + (docEntradaCarteiraVacina ? 1231 : 1237);
		result = prime * result + (docEntradaCertNascimento ? 1231 : 1237);
		result = prime * result + (docEntradaLaudoMedico ? 1231 : 1237);
		result = prime * result + (docEntradaPassaporte ? 1231 : 1237);
		result = prime * result + (docEntradaRG ? 1231 : 1237);
		result = prime * result + (docEntradaSemDocumentos ? 1231 : 1237);
		result = prime * result + (docEntradaTercerira ? 1231 : 1237);
		result = prime * result + ((drogas == null) ? 0 : drogas.hashCode());
		result = prime * result + ((escolaridade == null) ? 0 : escolaridade.hashCode());
		result = prime * result + (esteveInternado ? 1231 : 1237);
		result = prime * result + ((instituição == null) ? 0 : instituição.hashCode());
		result = prime * result + ((interncaoesInternado == null) ? 0 : interncaoesInternado.hashCode());
		result = prime * result + ((moraCom == null) ? 0 : moraCom.hashCode());
		result = prime * result + ((ostrosProblemas == null) ? 0 : ostrosProblemas.hashCode());
		result = prime * result + (problemaJustica ? 1231 : 1237);
		result = prime * result + (problemaSaude ? 1231 : 1237);
		result = prime * result + (problemaTrabalhista ? 1231 : 1237);
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + (relacaoFamiliaBoa ? 1231 : 1237);
		result = prime * result + (relacaoFamiliaMal ? 1231 : 1237);
		result = prime * result + (relacaoFamiliaOtima ? 1231 : 1237);
		result = prime * result + (relacaoFamiliaRegular ? 1231 : 1237);
		result = prime * result + ((religiao == null) ? 0 : religiao.hashCode());
		result = prime * result + ((tempoInternado == null) ? 0 : tempoInternado.hashCode());
		result = prime * result + ((tempoSemTrabalhar == null) ? 0 : tempoSemTrabalhar.hashCode());
		result = prime * result + ((tempoTrabalho == null) ? 0 : tempoTrabalho.hashCode());
		result = prime * result + (trabalhaNao ? 1231 : 1237);
		result = prime * result + ((trabalhaOnde == null) ? 0 : trabalhaOnde.hashCode());
		result = prime * result + (trabalhaSim ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interno other = (Interno) obj;
		if (docEntradaCPF != other.docEntradaCPF)
			return false;
		if (docEntradaCPT != other.docEntradaCPT)
			return false;
		if (docEntradaCartaoSUS != other.docEntradaCartaoSUS)
			return false;
		if (docEntradaCarteiraVacina != other.docEntradaCarteiraVacina)
			return false;
		if (docEntradaCertNascimento != other.docEntradaCertNascimento)
			return false;
		if (docEntradaLaudoMedico != other.docEntradaLaudoMedico)
			return false;
		if (docEntradaPassaporte != other.docEntradaPassaporte)
			return false;
		if (docEntradaRG != other.docEntradaRG)
			return false;
		if (docEntradaSemDocumentos != other.docEntradaSemDocumentos)
			return false;
		if (docEntradaTercerira != other.docEntradaTercerira)
			return false;
		if (drogas == null) {
			if (other.drogas != null)
				return false;
		} else if (!drogas.equals(other.drogas))
			return false;
		if (escolaridade == null) {
			if (other.escolaridade != null)
				return false;
		} else if (!escolaridade.equals(other.escolaridade))
			return false;
		if (esteveInternado != other.esteveInternado)
			return false;
		if (instituição == null) {
			if (other.instituição != null)
				return false;
		} else if (!instituição.equals(other.instituição))
			return false;
		if (interncaoesInternado == null) {
			if (other.interncaoesInternado != null)
				return false;
		} else if (!interncaoesInternado.equals(other.interncaoesInternado))
			return false;
		if (moraCom == null) {
			if (other.moraCom != null)
				return false;
		} else if (!moraCom.equals(other.moraCom))
			return false;
		if (ostrosProblemas == null) {
			if (other.ostrosProblemas != null)
				return false;
		} else if (!ostrosProblemas.equals(other.ostrosProblemas))
			return false;
		if (problemaJustica != other.problemaJustica)
			return false;
		if (problemaSaude != other.problemaSaude)
			return false;
		if (problemaTrabalhista != other.problemaTrabalhista)
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (relacaoFamiliaBoa != other.relacaoFamiliaBoa)
			return false;
		if (relacaoFamiliaMal != other.relacaoFamiliaMal)
			return false;
		if (relacaoFamiliaOtima != other.relacaoFamiliaOtima)
			return false;
		if (relacaoFamiliaRegular != other.relacaoFamiliaRegular)
			return false;
		if (religiao == null) {
			if (other.religiao != null)
				return false;
		} else if (!religiao.equals(other.religiao))
			return false;
		if (tempoInternado == null) {
			if (other.tempoInternado != null)
				return false;
		} else if (!tempoInternado.equals(other.tempoInternado))
			return false;
		if (tempoSemTrabalhar == null) {
			if (other.tempoSemTrabalhar != null)
				return false;
		} else if (!tempoSemTrabalhar.equals(other.tempoSemTrabalhar))
			return false;
		if (tempoTrabalho == null) {
			if (other.tempoTrabalho != null)
				return false;
		} else if (!tempoTrabalho.equals(other.tempoTrabalho))
			return false;
		if (trabalhaNao != other.trabalhaNao)
			return false;
		if (trabalhaOnde == null) {
			if (other.trabalhaOnde != null)
				return false;
		} else if (!trabalhaOnde.equals(other.trabalhaOnde))
			return false;
		if (trabalhaSim != other.trabalhaSim)
			return false;
		return true;
	}


}
