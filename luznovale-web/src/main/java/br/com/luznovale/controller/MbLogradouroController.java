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

import br.com.luznovale.data.LogradouroDao;
import br.com.luznovale.model.Logradouro;

@ManagedBean
@SessionScoped
public class MbLogradouroController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private LogradouroDao dao;
	private Logradouro logradouro;
	private String caminhoOrigem;

	public List<Logradouro> listaDeLogradouros() throws Exception {
		return dao.listarLogradouros();
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

	
	public Logradouro getLogradouro() {
		if(logradouro == null){
			logradouro = new Logradouro();
		}
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}


	public void removeLogradouro() {
		try {
			dao.remove(getLogradouro());
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
			if (getLogradouro().getIdLogradouro() == null || getLogradouro().getIdLogradouro() == 0) {
				dao.create(getLogradouro());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			} else {
				dao.update(getLogradouro());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			}
			setLogradouro(new Logradouro());
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

}
