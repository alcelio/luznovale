package br.com.luznovale.controller;

import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.luznovale.data.FuncaoDao;
import br.com.luznovale.model.Funcao;

/**
 * Classe para controlar os eventos da entidade Funcao
 * @author Alcélio Gomes
 *
 */
@SessionScoped
@ManagedBean
public class MbFuncaoController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB	
	private FuncaoDao dao;
	
	private Funcao funcao;
	/*
	 * Par guardar o endereço da pagina que solicitou a visualizaçao da pagina de Função.
	 */
	private String caminhoOrigem;
	
	public List<Funcao> listaDeFuncoes() {
		List<Funcao> funcoes = new ArrayList<Funcao>();
		try {
			funcoes = dao.listarFuncoes();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao obter lista de funções.", ""));
			e.printStackTrace();
		}
		return funcoes;

	}

	public Funcao getFuncao() {
		if (funcao == null) {
			funcao = new Funcao();
		}
		return funcao;
	}
	/**
	 * Remove a função selecionada
	 */
	public void removeFuncao() {
		try {
			dao.remove(getFuncao());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(SEVERITY_INFO, "Operação realizada com sucesso", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(SEVERITY_ERROR, "Operação não realizada, tente novamente.", e.getLocalizedMessage()));
		}
	}

	public void salvar() {
		try {
			dao.salvarFuncao(getFuncao());
			setFuncao(new Funcao());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", "teste acerto"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", "teste erro"));
			e.printStackTrace();
		}
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

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	

}
