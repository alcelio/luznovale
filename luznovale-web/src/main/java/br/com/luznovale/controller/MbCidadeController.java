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
import br.com.luznovale.data.CidadeDao;
import br.com.luznovale.model.Cidade;

/**
 * Classe para controlar os eventos da entidade Cidade
 * @author Alcélio Gomes
 *
 */

@ManagedBean
@SessionScoped
public class MbCidadeController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private CidadeDao dao;
	private Cidade cidade;
	private String caminhoOrigem;

	public List<Cidade> listaDeCidades() throws Exception {
		return dao.listarCidades();
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

	
	public Cidade getCidade() {
		if(cidade == null){
			cidade = new Cidade();
		}
		return cidade;
	}
	/**
	 * Seta a cidade informada por parâmetro na variável cidade {@link Cidade} da classe
	 * @param cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * Faz as verificaçõe e envia comando de deleção da cidade selecionada.
	 */
	public void removeCidade() {
		try {
			dao.remove(getCidade());
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
			if (getCidade().getIdCidade() == null || getCidade().getIdCidade() == 0) {
				dao.create(getCidade());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			} else {
				dao.update(getCidade());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			}
			setCidade(new Cidade());
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

}
