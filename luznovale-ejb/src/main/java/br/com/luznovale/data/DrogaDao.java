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

import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.Droga;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class DrogaBeanDao
 */
@Stateless
@LocalBean
@Remote
public class DrogaDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	ALogger log = ALogger.getLogger(FuncaoDao.class);
	
	public DrogaDao() {
	}
	
	public void salvarDrogra(Droga entidade) throws Exception {
		if (entidade == null) {
			log.error("Operação não permitida, entidare recebida é nula");
			throw new Exception("Operação não permitida, entidare recebida é nula");
		}
		try {
			if (entidade.getIdDroga() == null || entidade.getIdDroga() == 0) {
				em.persist(entidade);
			} else {
				em.merge(entidade);
			}
		} catch (Exception e) {
			log.error("Erro ao persistir a droga [" + entidade.getDesDroga()+"]");
			throw new Exception("Erro na operação (remove) na base de dados");
		}
	}
	
	public void remove(Droga entidade) throws Exception {
		log.debug("Excluindo função [" + entidade.getDesDroga()+"]...");
		try{
		em.remove(em.getReference(Droga.class, entidade.getIdDroga()));
		}catch ( Exception e){
			log.error("Erro de operação (remove) na base de dados");
			throw new Exception("Erro de operação (remove) na base de dados");
		}
		log.debug("Droga ["+entidade.getDesDroga()+"] excluída com sucesso.");
	}

	public List<Droga> listarDrogas() throws Exception{
		log.debug("Listando funções...");
		try{
			return em.createNamedQuery("Droga.findAll", Droga.class).getResultList(); 
		}catch (Exception e){
			log.error("Erro de operação (ListarDrogas) na base de dados");
			throw new Exception("Erro de operação (ListarDrogas) na base de dados");
		}
	}
		
	public Droga buscaFuncoesPorId(Integer id) throws Exception{
		log.debug("Buscando droga por id: ["+id+"]...");
		final Session session = em.unwrap(Session.class);
		Droga droga = null;
		try {
			final Criteria crit = CriaCriteria.createCriteria(Droga.class, session);
			crit.add(Restrictions.eq("idDrogra", id));
			droga = (Droga) crit.uniqueResult();
			return droga;
		} catch (final Exception e) {
			log.error("Erro de operação (buscaDrogaPorId) na base de dados");
			throw new Exception("Erro de operação (buscaDrogaPorId) na base de dados");
		}
    }

}
