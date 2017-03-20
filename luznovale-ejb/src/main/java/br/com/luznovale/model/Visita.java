package br.com.luznovale.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Visita
 *
 */
@Entity

public class Visita implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private Integer Id;
	private String desNomeVisitante;
	private String desQuiosque;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaVista;

	public Visita() {
		super();
	}   
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getDesNomeVisitante() {
		return this.desNomeVisitante;
	}

	public void setDesNomeVisitante(String desNomeVisitante) {
		this.desNomeVisitante = desNomeVisitante;
	}   
	public String getDesQuiosque() {
		return this.desQuiosque;
	}

	public void setDesQuiosque(String desQuiosque) {
		this.desQuiosque = desQuiosque;
	}   
	public Date getDtaVista() {
		return this.dtaVista;
	}

	public void setDtaVista(Date dtaVista) {
		this.dtaVista = dtaVista;
	}
   
}
