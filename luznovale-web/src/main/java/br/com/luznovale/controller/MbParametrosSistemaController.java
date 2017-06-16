package br.com.luznovale.controller;

import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.agsolutio.exceptions.DatabaseException;
import br.com.luznovale.data.ParametrosSistemaDao;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.ParametrosSistema;

/**
 * Classe para controlar os eventos da entidade Estado
 *
 * @author Alcélio Gomes
 */

@ManagedBean
@SessionScoped
public class MbParametrosSistemaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static ALogger log = ALogger.getLogger(MbParametrosSistemaController.class);

	@EJB
	private ParametrosSistemaDao dao;

	private ParametrosSistema parametroSistema;

	private String caminhoOrigem;

	private List<ParametrosSistema> listaParaemtrosSistema;

	@PostConstruct
	public void init() {
		setParametroSistema(new ParametrosSistema());
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

	public void removeParametro() {
		try {
			dao.remove(getParametroSistema());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			setParametroSistema(new ParametrosSistema());
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			dao.saveOrUpdate(getParametroSistema());
			setParametroSistema(new ParametrosSistema());

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao realizar operação.", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @return the parametroSistema
	 */
	public ParametrosSistema getParametroSistema() {
		return parametroSistema;
	}

	/**
	 * @param parametroSistema
	 *            the parametroSistema to set
	 */
	public void setParametroSistema(ParametrosSistema parametroSistema) {
		this.parametroSistema = parametroSistema;
	}

	/**
	 * @return the listaParaemtrosSistema
	 */
	public List<ParametrosSistema> getListaParaemtrosSistema() {
		try {
			setListaParaemtrosSistema(dao.listarParametros());
		} catch (DatabaseException e) {
			log.error("Erro ao solicitar lista de parametros do sistema...");
		}
		return listaParaemtrosSistema;
	}

	/**
	 * @param listaParaemtrosSistema
	 *            the listaParaemtrosSistema to set
	 */
	public void setListaParaemtrosSistema(List<ParametrosSistema> listaParaemtrosSistema) {
		this.listaParaemtrosSistema = listaParaemtrosSistema;
	}

}
