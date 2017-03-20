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

import br.com.luznovale.model.Estado;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class EstadoBeanDao
 */
@Stateless
@LocalBean
@Remote
public class EstadoDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public EstadoDao() {
	}

	public void create(Estado entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Estado entidade) throws Exception {
		try{
		em.merge(entidade);
		}catch ( Exception e){
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Estado entidade) throws Exception {
		try{
		em.remove(em.getReference(Estado.class, entidade.getIdEstado()));
		}catch ( Exception e){
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Estado> listarEstados() throws Exception{
		return em.createNamedQuery("Estado.findAll", Estado.class).getResultList();
	}
		
	public Estado buscaEstadoPorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Estado Estado = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Estado.class, session);
			crit.add(Restrictions.eq("idEstado", id));
			Estado = (Estado) crit.uniqueResult();
			return Estado;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (FindById) na base de dados", e);
		}
		
    }
	

}
