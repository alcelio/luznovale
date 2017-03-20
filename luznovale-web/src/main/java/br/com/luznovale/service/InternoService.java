package br.com.luznovale.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import br.com.luznovale.data.InternoDao;
import br.com.luznovale.model.Interno;

public class InternoService {
	@EJB
	InternoDao dao;

	public void salvarInterno(Interno entidade) throws Exception {
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

	public void excluirInterno(Interno entidade) throws Exception {
		if (entidade == null) {
			throw new Exception("Operação nõa permitida, entidare recebida é nula");
		}
		dao.remove(entidade);
	}

	public List<Interno> listarInternos() throws Exception {
		return dao.listarInternos();
	}

	public Interno buscaInternoPorId(Integer id) throws Exception {
		return dao.buscaInternoPorId(id);
	}
	


}
