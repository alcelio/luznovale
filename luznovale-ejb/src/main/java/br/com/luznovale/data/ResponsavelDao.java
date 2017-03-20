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

import br.com.luznovale.model.Responsavel;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class ResponsavelBeanDao
 */
@Stateless
@LocalBean
@Remote
public class ResponsavelDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public ResponsavelDao() {
	}

	public void create(Responsavel entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Responsavel entidade) throws Exception{
		try {
			em.merge(entidade);
		} catch (Exception e) {
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Responsavel entidade) throws Exception {
		try {
			em.remove(em.getReference(Responsavel.class, entidade.getIdPessoa()));
		} catch (Exception e) {
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Responsavel> listarResponsavels() throws Exception {
		try{
		return em.createNamedQuery("Responsavel.findAll", Responsavel.class).getResultList();
		}catch( Exception e) {
			throw new Exception("Erro de operação (listAll) na base de dados",e);
		}
	}
	
	public Responsavel buscaResponsavelPorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Responsavel Responsavel = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Responsavel.class, session);
			crit.add(Restrictions.eq("idPessoa", id));
			Responsavel = (Responsavel) crit.uniqueResult();
			return Responsavel;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (buscaResponsavelPorId) na base de dados",e);
		}
    }
}
