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

import br.com.luznovale.model.Visita;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class VisitaBeanDao
 */
@Stateless
@LocalBean
@Remote
public class VisitaDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public VisitaDao() {
	}

	public void create(Visita entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Visita entidade) throws Exception {
		try{
		em.merge(entidade);
		}catch ( Exception e){
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Visita entidade) throws Exception {
		try{
		em.remove(em.getReference(Visita.class, entidade.getId()));
		}catch ( Exception e){
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Visita> listarVisitas() throws Exception{
		return em.createNamedQuery("Visita.findAll", Visita.class).getResultList();
	}
		
	public Visita buscaVisitaPorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Visita Visita = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Visita.class, session);
			crit.add(Restrictions.eq("idVisita", id));
			Visita = (Visita) crit.uniqueResult();
			return Visita;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (FindById) na base de dados", e);
		}
		
    }
	

}
