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
import br.com.luznovale.data.EstadoDao;
import br.com.luznovale.model.Estado;

/**
 * Classe para controlar os eventos da entidade Estado
 *
 * @author Alcélio Gomes
 */

@ManagedBean
@SessionScoped
public class MbEstadoController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private EstadoDao dao;
	private Estado estado;
	private String caminhoOrigem;

	public List<Estado> listaDeEstados() throws Exception {
		return dao.listarEstados();
	}

	public Estado getEstado() {
		if(estado == null){
			estado = new Estado();
		}
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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


	public void removeEstado() {
		try {
			dao.remove(getEstado());
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
			if (getEstado().getIdEstado() == null || getEstado().getIdEstado() == 0) {
				dao.create(getEstado());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			} else {
				dao.update(getEstado());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			}
			setEstado(new Estado());
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

}
