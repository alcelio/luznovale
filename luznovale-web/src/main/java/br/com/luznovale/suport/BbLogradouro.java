package br.com.luznovale.suport;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.agsolutio.exceptions.ScreenException;
import br.com.luznovale.data.LogradouroDao;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.Logradouro;
/**
 * ManagedBean que fornece apoio para a entidade logradouro.
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 12/03/2017
 */
@ManagedBean(name = "bbLogradouro")
@RequestScoped
public class BbLogradouro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static ALogger log = ALogger.getLogger(BbLogradouro.class);

	@EJB 
	LogradouroDao dao;
	/**
	 * Retorna uma lista de logradouros cadastrados
	 * @return
	 * @throws Exception
	 */
	public List<Logradouro> getLogradouros() throws ScreenException {
		List<Logradouro> listaLogradouros = null;
		log.debug("Incianco busca por logradouros");
		try {
			listaLogradouros =  dao.listarLogradouros();
			log.debug("Lista de logradouros obtida com sucesso.");
			return listaLogradouros;
		} catch (Exception e) {
			log.error("Erro na busca de logradouros...", e);
			throw new ScreenException("Erro ao gerar lista de logradouros");
		}
	}

}
