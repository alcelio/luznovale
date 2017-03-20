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

import br.com.luznovale.model.Permissao;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class PermissaoBeanDao
 */
@Stateless
@LocalBean
@Remote
public class PermissaoDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public PermissaoDao() {
	}

	public void create(Permissao entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Permissao entidade) throws Exception {
		try{
		em.merge(entidade);
		}catch ( Exception e){
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Permissao entidade) throws Exception {
		try{
		em.remove(em.getReference(Permissao.class, entidade.getIdPermissao()));
		}catch ( Exception e){
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Permissao> listarPermissaos() throws Exception{
		return em.createNamedQuery("Permissao.findAll", Permissao.class).getResultList();
	}
		
	public Permissao buscaPermissaoPorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Permissao Permissao = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Permissao.class, session);
			crit.add(Restrictions.eq("idPermissao", id));
			Permissao = (Permissao) crit.uniqueResult();
			return Permissao;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (FindById) na base de dados", e);
		}
		
    }
	

}
