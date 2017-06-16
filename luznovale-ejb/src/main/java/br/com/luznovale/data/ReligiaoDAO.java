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
import br.com.luznovale.model.Religiao;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class ReligiaoBeanDao
 */
@Stateless
@LocalBean
@Remote
public class ReligiaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	private static ALogger log = ALogger.getLogger(ReligiaoDAO.class);

	public ReligiaoDAO() {
	}

	public void create(Religiao entidade) throws DatabaseException {
		log.debug("Gravando religião...");
		try{
			em.persist(entidade);
			log.debug("Gravação realizada com sucesso!");
		}catch( Exception e) {
			log.error("Erro durante a gravação da religião na base de dados.", e);
			throw new DatabaseException("Erro durante a gravação na base de dados.",e);
		}
		
	}

	public void update(Religiao entidade) throws DatabaseException {
		log.debug("Atualizando religião...");
		try{
		em.merge(entidade);
		log.debug("Atualização realizada com sucesso!");
		}catch ( Exception e){
			log.error("Erro durante a atualização da religião na base de dados.", e);
			throw new DatabaseException("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Religiao entidade) throws Exception {
		log.debug("Excluido religião...");
		try{
		em.remove(em.getReference(Religiao.class, entidade.getIdReligiao()));
		log.debug("Religião excluída com sucesso!");
		}catch ( Exception e){
			log.error("Erro durante a esclusão da religião na base de dados.", e);
			throw new Exception("Erro durante a esclusão da religião na base de dados", e);
		}
	}

	public List<Religiao> listarReligioes() throws DatabaseException{
		log.debug("Gerando lista de religuos no banco de dados...");
		List<Religiao> listaReligiao = null;
		try {
			listaReligiao = em.createNamedQuery("Religiao.findAll", Religiao.class).getResultList();
			log.debug("Lista de religiões gerada com sucesso!");
			return listaReligiao;
		} catch (Exception e) {
			log.debug("Erro ao gerar lista de religioes na base de dados",e);
			throw new DatabaseException("Erro ao gerar lista de religioes na base de dados.",e);
		}
	}
		
	public Religiao buscaReligiaoPorId(Integer id) throws Exception{

		final Session session = em.unwrap(Session.class);
		log.debug("Buscando religião por id...");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Religiao.class, session);
			crit.add(Restrictions.eq("idReligiao", id));
			Religiao Religiao = (Religiao) crit.uniqueResult();
			log.debug("Religiao encontrada...");
			return Religiao;
		} catch (final Exception e) {
			log.error("Erro ao buscar religiao por id",e);
			throw new Exception("Erro ao bsucar religiao por ID...", e);
		}
		
    }
	

}
