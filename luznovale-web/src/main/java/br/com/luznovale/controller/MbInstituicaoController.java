package br.com.luznovale.controller;

import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * Classe para controlar os eventos da entidade Instituicao
 * @author Alcélio Gomes
 *
 */
import javax.faces.context.FacesContext;

import br.com.luznovale.data.InstituicaoDao;
import br.com.luznovale.exceptions.ScrenException;
import br.com.luznovale.model.Instituicao;

@ManagedBean
@SessionScoped
public class MbInstituicaoController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private InstituicaoDao dao; 
	private Instituicao instituicao;
	private String caminhoOrigem = "";
	
	public List<Instituicao> listaDeInstituicao(){
		List<Instituicao> listaInstituicoes = new ArrayList<Instituicao>();
		try {
			listaInstituicoes = dao.listarInstituicoes();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao obter lista de Instituições.", ""));
			e.printStackTrace();
		}
		return listaInstituicoes;
		
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

	public Instituicao getInstituicao() {
		if(instituicao == null){
			instituicao = new Instituicao();
		}
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public void removeInstituicao() {
		try {
			dao.remove(getInstituicao());
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
			validaObjetosComBox();
			dao.salvarInstituicao(getInstituicao());
			setInstituicao(new Instituicao());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}catch (ScrenException e1) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro na operação, " + e1.getMessage(),""));
			e1.printStackTrace();
		}
	}

	private void validaObjetosComBox() throws ScrenException {
//		
//		if(StringUtils.isBlank(getInstituicao().getEndereco().getEstado().getDesEstado()) ){
//				throw new ScrenException("para prosseguir selecione um Estado.");
//		}
//		if(StringUtils.isBlank(getInstituicao().getEndereco().getCidade().getDesNomeCidade()) ){
//			throw new ScrenException("para prosseguir selecione uma cidade.");
//		}
//		if(StringUtils.isBlank(getInstituicao().getEndereco().getLogradouro().getDesLogradouro())){
//			throw new ScrenException("para prosseguir selecione um Logradouro.");
//		}
	}

}
