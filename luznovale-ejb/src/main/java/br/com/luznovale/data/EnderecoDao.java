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

import br.com.luznovale.model.Endereco;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class EnderecoBeanDao
 */
@Stateless
@LocalBean
@Remote
public class EnderecoDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public EnderecoDao() {
	}

	public void create(Endereco entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Endereco entidade) throws Exception {
		try{
		em.merge(entidade);
		}catch ( Exception e){
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Endereco entidade) throws Exception {
		try{
		em.remove(em.getReference(Endereco.class, entidade.getIdEndereco()));
		}catch ( Exception e){
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Endereco> listarEnderecos() throws Exception{
		return em.createNamedQuery("Endereco.findAll", Endereco.class).getResultList();
	}
		
	public Endereco buscaEnderecoPorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Endereco Endereco = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Endereco.class, session);
			crit.add(Restrictions.eq("idEndereco", id));
			Endereco = (Endereco) crit.uniqueResult();
			return Endereco;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (FindById) na base de dados", e);
		}
		
    }
}
