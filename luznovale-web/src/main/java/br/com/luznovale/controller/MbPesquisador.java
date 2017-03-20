package br.com.luznovale.controller;

import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import br.com.luznovale.data.InternoDao;
import br.com.luznovale.model.Interno;

@ManagedBean(name = "dtFilterInterno")
@SessionScoped
public class MbPesquisador {
	@EJB
	InternoDao dao;

	private List<Interno> internos;
	private List<Interno> internosFiltrados;
	private String caminhoOrigem;

	@PostConstruct
	public void init() {
		try {
			internos = dao.listarInternos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setaCaminhoOrigem(String origem) {
		this.caminhoOrigem = origem;
	}

	public String goBack() {
		if (StringUtils.isBlank(this.caminhoOrigem)) {
			return PAGINA_HOME;
		}
		return this.caminhoOrigem;
	}

	public List<Interno> getInternosFiltrados() {
		return internosFiltrados;
	}

	public void setInternosFiltrados(List<Interno> internosFiltrados) {
		this.internosFiltrados = internosFiltrados;
	}

	public List<Interno> getInternos() {
		// ORdena por descrição de nome
		Collections.sort(internos, new Comparator<Interno>() {
			@Override
			public int compare(Interno o1, Interno o2) {
				// TODO Auto-generated method stub
				return o1.getDesNomePessoa().compareTo(o2.getDesNomePessoa());
			}
		});

		return internos;
	}

	public void setInternos(List<Interno> internos) {
		this.internos = internos;
	}
	


}