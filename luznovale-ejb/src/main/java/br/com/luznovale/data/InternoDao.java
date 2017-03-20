package br.com.luznovale.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.luznovale.exception.DatabaseException;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.Interno;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class InternoBeanDao
 */
@Stateless
@LocalBean
@Remote
public class InternoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static ALogger log = ALogger.getLogger(InternoDao.class);

	@PersistenceContext
	private EntityManager em;

	public InternoDao() {
	}

	public void create(Interno entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public Interno update(Interno entidade) throws DatabaseException{
		log.debug("Atualizando Interno no banco de dados...");
		try {
			Interno interno;
			interno = em.merge(entidade);
			log.debug("Dados do interno ["+entidade.getIdPessoa()+"] atualizados com sucesso.");
			return interno;
		} catch (Exception e) {
			log.debug("Erro ao atualizar registro do interno ["+entidade.getIdPessoa()+"]...",e);
			throw new DatabaseException("Impossivel atuaizar registro do interno no banco de dados...["+entidade.getIdPessoa()+"]...", e);
		}
	}

	public void remove(Interno entidade) throws Exception {
		try {
			em.remove(em.getReference(Interno.class, entidade.getIdPessoa()));
		} catch (Exception e) {
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Interno> listarInternos() throws DatabaseException {
		log.debug("Gerando lista de internos...");
		List<Interno> listaInternos = new ArrayList<Interno>();
		try{
			listaInternos = em.createNamedQuery("Interno.findAll", Interno.class).getResultList();
			log.debug("Lsita gerada com sucesso. Retorno ["+listaInternos.size()+"] internos" );
		return listaInternos;
		}catch( Exception e) {
			log.error(e.getMessage(), e );
			throw new DatabaseException("Erro ao gerar lista de internos",e);
		}
	}
	
	
	public Interno buscaInternoPorId(Integer id) throws DatabaseException{
		final Session session = em.unwrap(Session.class);
		Interno Interno = null;
		log.debug("Buscando interno por id ");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Interno.class, session);
			crit.add(Restrictions.eq("idPessoa", id));
			Interno = (Interno) crit.uniqueResult();
			log.debug("Registro localizado = ["+Interno.getIdPessoa()+"] com sucesso.");
			return Interno;
		} catch (final Exception e) {
			log.error("Erro ao buscar interno por id", e);
			throw new DatabaseException("Erro de operação (buscaInternoPorId) na base de dados",e);
		}
    }
}
