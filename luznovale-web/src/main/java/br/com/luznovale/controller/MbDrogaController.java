package br.com.luznovale.controller;

import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.luznovale.data.DrogaDao;
import br.com.luznovale.model.Droga;

/**
 * Classe para controlar os eventos da entidade Droga
 * @author Alcélio Gomes
 *
 */

@ManagedBean
@SessionScoped
public class MbDrogaController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private DrogaDao dao;
	private Droga droga;
	private String caminhoOrigem;

	public List<Droga> listaDeDrogas() throws Exception {
		return dao.listarDrogas();
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


	public Droga getDroga() {
		if (droga == null) {
			droga = new Droga();
		}
		return droga;
	}

	public void setDroga(Droga droga) {
		this.droga = droga;
	}

	public void removeDroga() {
		try {
			dao.remove(getDroga());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			dao.salvarDrogra(getDroga());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));

			setDroga(new Droga());

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

}
