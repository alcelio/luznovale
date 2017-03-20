package br.com.luznovale.controller;

import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static br.com.luznovale.util.LuzNovaleGlobal.USUARIO_PRIMEIRO_ACESSO;
import static br.com.luznovale.util.WebGlobals.PATH_APLICACAO;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.luznovale.data.UsuarioDao;
import br.com.luznovale.model.Usuario;

@ManagedBean
@SessionScoped
public class MbLoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Usuario usuarioLogado;
	
	private boolean usuario;
	
	private boolean admin;
	
	
	@EJB
	private UsuarioDao dao;
	
	public Usuario procuraUsuario(String login) {
		usuarioLogado = new Usuario();
		try {
			usuarioLogado =  dao.buscaUsuarioPorLogin(login);

			if(usuarioLogado != null &&  usuarioLogado.getPrimeiroAcesso() != null && usuarioLogado.getPrimeiroAcesso().equals(Boolean.TRUE)){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(USUARIO_PRIMEIRO_ACESSO , usuarioLogado); 
			}
			
			verificaTiposDeAutoridade();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return usuarioLogado;
	}
	
	public void efetuarLogout(){ 
		FacesContext fc = FacesContext.getCurrentInstance(); 
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false); 
		session.invalidate(); 
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(PATH_APLICACAO + PAGINA_HOME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	/**
	 * sete os tipos de usuario para o usuario logado
	 */
	
	private void verificaTiposDeAutoridade() {
		if (getUsuarioLogado().getIsUser()) {
			setUsuario(true);
			setAdmin(false);
		}
		if (getUsuarioLogado().getIsAdminUser()) {
			setUsuario(true);
			setAdmin(true);
		}

	}
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isUsuario() {
		return usuario;
	}

	public void setUsuario(boolean usuario) {
		this.usuario = usuario;
	}
	
	
	


}
