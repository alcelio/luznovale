package br.com.luznovale.suport;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.luznovale.data.CidadeDao;
import br.com.luznovale.exception.ScreenException;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.Cidade;
/**
 * ManagedBean que fornece apoio para a entidade cidade.
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 12/03/2017
 */
@ManagedBean(name = "bbCidade")
@RequestScoped
public class BbCidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static ALogger log = ALogger.getLogger(BbCidade.class);

	@EJB 
	CidadeDao dao;
	/**
	 * Retorna uma lista de logradouros cadastrados
	 * @return
	 * @throws Exception
	 */
	public List<Cidade> getCidades() throws ScreenException {
		List<Cidade> listaLogradouros = null;
		log.debug("Incianco busca por cidades");
		try {
			listaLogradouros =  dao.listarCidades();
			log.debug("Lista de cidades obtida com sucesso.");
			return listaLogradouros;
		} catch (Exception e) {
			log.error("Erro na busca de cidades...", e);
			throw new ScreenException("Erro ao gerar lista de cidades");
		}
	}

}
