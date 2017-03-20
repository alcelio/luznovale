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

import br.com.luznovale.model.Logradouro;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class LogradouroBeanDao
 */
@Stateless
@LocalBean
@Remote
public class LogradouroDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public LogradouroDao() {
	}

	public void create(Logradouro entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Logradouro entidade) throws Exception {
		try{
		em.merge(entidade);
		}catch ( Exception e){
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Logradouro entidade) throws Exception {
		try{
		em.remove(em.getReference(Logradouro.class, entidade.getIdLogradouro()));
		}catch ( Exception e){
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Logradouro> listarLogradouros() throws Exception{
		return em.createNamedQuery("Logradouro.findAll", Logradouro.class).getResultList();
	}
		
	public Logradouro buscaLogradouroPorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Logradouro Logradouro = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Logradouro.class, session);
			crit.add(Restrictions.eq("idLogradouro", id));
			Logradouro = (Logradouro) crit.uniqueResult();
			return Logradouro;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (FindById) na base de dados", e);
		}
		
    }
	

}
