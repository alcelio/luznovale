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

import br.com.luznovale.model.Sexo;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class SexoBeanDao
 */
@Stateless
@LocalBean
@Remote
public class SexoDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public SexoDao() {
	}

	public void create(Sexo entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Sexo entidade) throws Exception {
		try{
		em.merge(entidade);
		}catch ( Exception e){
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Sexo entidade) throws Exception {
		try{
		em.remove(em.getReference(Sexo.class, entidade.getIdSexo()));
		}catch ( Exception e){
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Sexo> listarSexos() throws Exception{
		return em.createNamedQuery("Sexo.findAll", Sexo.class).getResultList();
	}
		
	public Sexo buscaSexoPorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Sexo Sexo = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Sexo.class, session);
			crit.add(Restrictions.eq("idSexo", id));
			Sexo = (Sexo) crit.uniqueResult();
			return Sexo;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (FindById) na base de dados", e);
		}
		
    }
	

}
