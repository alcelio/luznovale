package br.com.luznovale.data;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.agsolutio.exceptions.DatabaseException;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.ParametrosSistema;
import br.com.luznovale.util.CriaCriteria;

@Stateless
@LocalBean
@Remote
public class ParametrosSistemaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private static ALogger log = ALogger.getLogger(ParametrosSistemaDao.class);

	@PersistenceContext
	private EntityManager em;

	public ParametrosSistemaDao() {
	}

	/**
	 * Busca parâmetro do sistema pelo id
	 * 
	 * @throws DatabaseException
	 * 
	 */
	public ParametrosSistema buscarPorChave(Integer idParametro) throws DatabaseException {

		final Session session = em.unwrap(Session.class);
		Criteria crit;
		try {
			crit = CriaCriteria.createCriteria(ParametrosSistema.class, session);
			crit.add(Restrictions.eq("idParametroSistema", idParametro));
			return (ParametrosSistema) crit.uniqueResult();
		} catch (Exception e) {
			log.error("Erro ao obter valor no banco de dados", e);
			throw new DatabaseException("Erro ao obter valor no banco de dados");
		}

	}

	public void saveOrUpdate(ParametrosSistema parametro) throws DatabaseException {
		try{
			log.debug("Salvando parametro de sistema na base de dados.");
			em.merge(parametro);
			log.debug("Operação realizado com sucesso");
		}catch (Exception e) {
			log.error("Erro ao salvar parametros de sistema", e);
			throw new DatabaseException("Não foi possivel efetuara a gravação no banco de dados.", e);		
			}
	}
	
	public void remove(ParametrosSistema entidade) throws DatabaseException {
		log.debug("Excluindo Parametro de Sistema [" + entidade.getDescricaoParametro()+"]...");
		try{
		em.remove(em.getReference(ParametrosSistema.class, entidade.getIdParametroSistema()));
		log.debug("Parâmetro ["+entidade.getDescricaoParametro()+"] excluído com sucesso.");
		}catch ( Exception e){
			log.error("Erro de operação (remove) na base de dados");
			throw new DatabaseException(e.getMessage(),e);
		}
	}
	
	public List<ParametrosSistema> listarParametros() throws DatabaseException{
		log.debug("Listando parametros...");
		
		try{
			List<ParametrosSistema> listaDeObjetos = em.createNamedQuery("ParametrosSistema.findAll", ParametrosSistema.class).getResultList(); 
			log.debug("Lista ParametrosSistema gerada com sucesso.");
			return listaDeObjetos;
		}catch (Exception e){
			log.error("Erro de operação (ListarDrogas) na base de dados",e);
			throw new DatabaseException(e.getMessage());
		}
	}

}

