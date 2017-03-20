package br.com.luznovale.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import br.com.luznovale.data.UsuarioDao;
import br.com.luznovale.model.Pessoa;
import br.com.luznovale.model.Usuario;
public class UsuarioService {
	@EJB
	UsuarioDao dao;

	public void salvarUsuario(Usuario entidade) throws Exception {
		if (entidade == null) {
			throw new Exception("Operação nõa permitida, entidade recebida é nula");
		}
		entidade.setDtaCadastro(new Date());
		if (entidade.getIdPessoa() == null || entidade.getIdPessoa() == 0) {
			dao.create(entidade);
		} else {
			dao.update(entidade);
		}
	}

	public void excluirPessoa(Usuario entidade) throws Exception {
		if (entidade == null) {
			throw new Exception("Operação nõa permitida, entidare recebida é nula");
		}
		dao.remove(entidade);
	}

	public List<Usuario> listarUsuarios() throws Exception {
		return dao.listarUsuarios();
	}

	public Pessoa buscaUsuarioPorLogin(String login) throws Exception {
		return dao.buscaUsuarioPorLogin(login);
	}

	public Usuario buscaUsuarioPorId(Integer id) throws Exception {
		return dao.buscaUsuarioPorId(id);
	}

	public boolean isExisteLogin(String login) throws Exception {
		return dao.isExisteLogin(login);
	}

}
