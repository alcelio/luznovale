package br.com.luznovale.controller;

import static br.com.luznovale.util.GeraPermissoes.getPermissaoAdmin;
import static br.com.luznovale.util.GeraPermissoes.getPermissaoSuper;
import static br.com.luznovale.util.GeraPermissoes.getPermissaoUsuario;
import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static br.com.luznovale.util.LuzNovaleGlobal.SENHA_PADRAO;
import static br.com.luznovale.util.LuzNovaleGlobal.USUARIO_PRIMEIRO_ACESSO;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * Classe para controlar os eventos da entidade Usuario
 * @author Alcélio Gomes
 *
 */
import javax.faces.context.FacesContext;

import br.com.luznovale.conversores.ConverterSHA1;
import br.com.luznovale.data.UsuarioDao;
import br.com.luznovale.model.Funcao;
import br.com.luznovale.model.Usuario;

@ManagedBean
@SessionScoped
public class MbUsuarioController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private UsuarioDao dao;
	private Usuario usuario;
	private String caminhoOrigem;
	private String confirmaSenha;

	@PostConstruct
	public void init(){
		//Verefica se tem unusario setado como primeiro acesso na sessão
		Usuario usr = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USUARIO_PRIMEIRO_ACESSO); 
		if(usr != null){
			setUsuario(usr);
		}
	}
	
	public List<Usuario> listaDeUsuarios() throws Exception {
		return dao.listarUsuarios();
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


	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		if (usuario.getFuncao() == null){
			usuario.setFuncao(new Funcao());
		}
		return usuario;
	}

	public void removeUsuario() {
		try {
			dao.remove(getUsuario());
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
			criaPermissoesUsusario();
			getUsuario().setIsAtivo(TRUE);
			getUsuario().setPrimeiroAcesso(TRUE);
			getUsuario().setDtaCadastro(new Date());
			
			if (getUsuario().getIdPessoa() == null || getUsuario().getIdPessoa() == 0) {
				validaLogin();
				getUsuario().setSenha(SENHA_PADRAO);
				dao.create(getUsuario());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			} else {
				dao.update(getUsuario());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
			}
			novoUsuario();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada. "+e.getMessage(), ""));
			e.printStackTrace();
		}
	}
	
	private void novoUsuario() {
		setUsuario(new Usuario());
		getUsuario().setFuncao(new Funcao());
	}
	
	private void validaLogin() throws Exception{
		if ( dao.isExisteLogin(getUsuario().getLogin())){
			throw new Exception("Atenção! Este login já esta sendo usado no sistema, selecione outro para prosseguir.");
		}
	}
	
	private void criaPermissoesUsusario() throws Exception{
		if(getUsuario() == null){
			throw new Exception("Atenção! Ainda não é permitido efetuar esta atribuição.");
		}
		if(getUsuario().getIsAdminUser() && ( getUsuario().getIsUser() || getUsuario().getIsSuperUser()) ){
			throw new Exception("Atenção! Selecione apenas um tipo de usuário para prosseguir.");
		}
		if(getUsuario().getIsSuperUser() && ( getUsuario().getIsUser() || getUsuario().getIsAdminUser()) ){
			throw new Exception("Atenção! Selecione apenas um tipo de usuário para prosseguir.");
		}
		if(getUsuario().getIsUser() && ( getUsuario().getIsSuperUser() || getUsuario().getIsAdminUser()) ){
			throw new Exception("Atenção! Selecione apenas um tipo de usuário para prosseguir.");
		}
		if(!getUsuario().getIsUser() && !getUsuario().getIsAdminUser() && !getUsuario().getIsSuperUser()){
			throw new Exception("Atenção! É necessário informar o tipo de usuário para prosseguir.");
		}
		
		if(getUsuario().getIsUser()){
			getUsuario().setPermissoes(getPermissaoUsuario());
		}
		
		if(getUsuario().getIsAdminUser()){
			getUsuario().setPermissoes(getPermissaoAdmin());
		}
		
		if(getUsuario().getIsSuperUser()){
			getUsuario().setPermissoes(getPermissaoSuper());
		}
	}
	public String ativar(){
		if(getUsuario().getIsAtivo()){
			getUsuario().setIsAtivo(FALSE);
			getUsuario().setSenha(ConverterSHA1.cipher(getUsuario().getSenha()));
		}else{
			getUsuario().setIsAtivo(TRUE);
			getUsuario().setSenha(SENHA_PADRAO);
			getUsuario().setPrimeiroAcesso(TRUE);
		}
		try {
			dao.update(getUsuario());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro inespedo ao realizar a operação.", ""));

		}
		return null;
	}
	
	public String atualizaSenha() {
		if (getUsuario().getSenha() == null ? confirmaSenha == null : getUsuario().getSenha().equals(confirmaSenha)) {
			try {
				getUsuario().setPrimeiroAcesso(FALSE);
				dao.update(getUsuario());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,"Operação realizada com sucesso.", ""));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(USUARIO_PRIMEIRO_ACESSO);

				return goBack();

			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de gravação no banco de dados, tente novamente", ""));
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "As senhas não conferem.", ""));
			return "";
		}
		return goBack();
	}

	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
}
