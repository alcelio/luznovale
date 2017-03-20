package br.com.luznovale.controller;

import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * Classe para controlar os eventos da entidade Cidade
 * @author Alcélio Gomes
 *
 */
import javax.faces.context.FacesContext;

import br.com.luznovale.data.InternoDao;
import br.com.luznovale.model.Interno;
import br.com.luznovale.service.InternoService;

@ManagedBean
@SessionScoped
public class MbInternoController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	InternoDao dao;

	private InternoService intenroService;
	private Interno interno;
	private String caminhoOrigem;
	private List<Interno> filtroInternos;
	private List<Interno> internos;

	public InternoService getInternoService() {
		if (intenroService == null) {
			intenroService = new InternoService();
		}
		return intenroService;
	}

	/**
	 * Método resposável por retornar a página que deve ser exibida ao
	 * selecionar valtar.
	 * 
	 * @return
	 */
	public String goBack() {
		if (isBlank(getCaminhoOrigem())) {
			return PAGINA_HOME;
		} else {
			return getCaminhoOrigem();
		}
	}

	public String getCaminhoOrigem() {
		return caminhoOrigem;
	}
	
	public void setaCaminhoOrigem(String origem) {
		this.caminhoOrigem = origem;
	}

	

	public Interno getInterno() {
		return interno;
	}

	public void setInterno(Interno interno) {
		this.interno = interno;
	}

	public void setCaminhoOrigem(String caminhoOrigem) {
		this.caminhoOrigem = caminhoOrigem;
	}

	public void addCidade() {
		try {
			getInternoService().salvarInterno(getInterno());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Não foi possivel realizar a operação.", e.getMessage()));
		}
	}

	public void removeInterno() {
		try {
			getInternoService().excluirInterno(getInterno());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Não foi possivel realizar a operação.", e.getMessage()));
		}
	}

	public List<Interno> getFiltroInternos() {
		return filtroInternos;
	}

	public void setFiltroInternos(List<Interno> filtroInternos) {
		this.filtroInternos = filtroInternos;
	}

	public List<Interno> getInternos() {
		try {
			internos = dao.listarInternos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return internos;
	}

	public void setInternos(List<Interno> internos) {
		this.internos = internos;
	}
	
	
	

}
