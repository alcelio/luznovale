package br.com.luznovale.service;

import java.util.List;

import javax.ejb.EJB;

import br.com.luznovale.data.EstadoDao;
import br.com.luznovale.model.Estado;

public class EstadoService {

	@EJB
	EstadoDao dao;

	public void salvarEstado(Estado estado) throws Exception {
		if (estado == null) {
			throw new Exception("Operação nõa permitida, entidare recebida é nula");
		}
		try {
			if (estado.getIdEstado() == null || estado.getIdEstado() == 0) {
				dao.create(estado);
			} else {
				dao.update(estado);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirEstado(Estado estado) throws Exception {
		if (estado == null) {
			throw new Exception("Operação nõa permitida, entidare recebida é nula");
		}
		try {
			dao.remove(estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Estado> listarEstados() throws Exception{
		return dao.listarEstados();
	}

}
