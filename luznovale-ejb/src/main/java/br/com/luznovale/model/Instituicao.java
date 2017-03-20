package br.com.luznovale.model;

import br.com.luznovale.model.Endereco;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Intituicao
 *
 */
@Entity
@NamedQuery(name = "Instituicao.findAll", query = "SELECT d FROM Instituicao d")
public class Instituicao implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private Integer idInstituicao;
	private String desNomeInstituicao;
	private String desFone1;
	private String desFOne2;
	private String desEmail;
	private String desNomeContato;
	private String desObs;

	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;

	public Instituicao() {
		endereco = new Endereco();
	}   
	public Integer getIdInstituicao() {
		return this.idInstituicao;
	}

	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}   
	public String getDesNomeInstituicao() {
		return this.desNomeInstituicao;
	}

	public void setDesNomeInstituicao(String desNomeInstituicao) {
		this.desNomeInstituicao = desNomeInstituicao;
	}   
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getDesFone1() {
		return desFone1;
	}
	public void setDesFone1(String desFone1) {
		this.desFone1 = desFone1;
	}
	public String getDesFOne2() {
		return desFOne2;
	}
	public void setDesFOne2(String desFOne2) {
		this.desFOne2 = desFOne2;
	}
	public String getDesEmail() {
		return desEmail;
	}
	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}
	public String getDesNomeContato() {
		return desNomeContato;
	}
	public void setDesNomeContato(String desNomeContato) {
		this.desNomeContato = desNomeContato;
	}
	public String getDesObs() {
		return desObs;
	}
	public void setDesObs(String desObs) {
		this.desObs = desObs;
	}
   }
