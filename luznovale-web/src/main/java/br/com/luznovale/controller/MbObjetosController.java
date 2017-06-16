package br.com.luznovale.controller;

import static br.com.luznovale.util.WebGlobals.PAGINA_HOME;
import static br.com.luznovale.util.WebGlobals.PAGINA_REGISTRAR_INTERNACAO;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.agsolutio.exceptions.DatabaseException;
import br.com.agsolutio.exceptions.ScreenException;
import br.com.luznovale.data.ObjetosDao;
import br.com.luznovale.model.Objeto;

/**
 * Classe para controlar os eventos da entidade Droga
 * @author Alcélio Gomes
 *
 */

@ManagedBean
@SessionScoped
public class MbObjetosController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ObjetosDao dao; 
	
	private Objeto objeto;
	
	private String caminhoOrigem;
	
	private List<Objeto> objetosFiltrados;
	
	private Integer qtdObjetos;

	public List<Objeto> listaDeObjetos() throws ScreenException {
		try {
			
			List<Objeto> listaDeObjetos = dao.listarObjetos();
			//Ordena a lista por descrição
			Collections.sort(listaDeObjetos, new Comparator<Objeto>() {
				@Override
				public int compare(Objeto o1, Objeto o2) {
					return o1.getDesObjeto().compareTo(o2.getDesObjeto());
				}
			});
			
			return listaDeObjetos;
		} catch (DatabaseException e) {
			throw new ScreenException("Erro ao receber lista de objetos", e);
		}
	}

	/**
	 * Método resposável por retornar a página que deve ser exibida ao
	 * selecionar valtar.
	 * 
	 * @return
	 */
	public String goBack() {
		String temp = getCaminhoOrigem();
		if (isBlank(temp)) {
			return PAGINA_HOME;
		} else {
			setaCaminhoOrigem("");
			return temp;
		}
	}
	
	
	public boolean isAdicionandoObejtos(){
		if( getCaminhoOrigem() != null && getCaminhoOrigem().equals(PAGINA_REGISTRAR_INTERNACAO)){
			return true;
		}else{ 
			return false;
		}
	}

	public String getCaminhoOrigem() {
		return caminhoOrigem;
	}
	
	public void setaCaminhoOrigem(String origem) {
		this.caminhoOrigem = origem;
	}


	public Objeto getObjeto() {
		if (objeto == null) {
			objeto = new Objeto();
		}
		return objeto;
	}

	
	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public void removeobjeto() {
		try {
			dao.remove(getObjeto());
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
			dao.salvarObjeto(getObjeto());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));

			setObjeto(new Objeto());

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

	public List<Objeto> getObjetosFiltrados() {
		return objetosFiltrados;
	}

	public void setObjetosFiltrados(List<Objeto> objetosFiltrados) {
		this.objetosFiltrados = objetosFiltrados;
	}

	/**
	 * @return the qtdObjetos
	 */
	public Integer getQtdObjetos() {
		return qtdObjetos;
	}

	/**
	 * @param qtdObjetos the qtdObjetos to set
	 */
	public void setQtdObjetos(Integer qtdObjetos) {
		this.qtdObjetos = qtdObjetos;
	}
	
	

}
