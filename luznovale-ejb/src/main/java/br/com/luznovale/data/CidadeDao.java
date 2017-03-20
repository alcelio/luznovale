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

import br.com.luznovale.model.Cidade;
import br.com.luznovale.util.CriaCriteria;


/**
 * * Session Bean implementation class CidadeBeanDao
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 */
@Stateless
@LocalBean
@Remote
public class CidadeDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public CidadeDao() {
	}
/**
 *  Grava a entidade passada no parametro no banco de dados
 *  
 * @param {@link {@link Cidade}}
 * @throws Exception
 */
	public void create(Cidade entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}
/**
 * Atualiza as infomações da entidade passada no parametro no banco de dados
 * 
 * @param Cidade
 * @throws Exception
 */
	public void update(Cidade entidade) throws Exception {
		try{
		em.merge(entidade);
		}catch ( Exception e){
			throw new Exception("Erro de operação (update) na base de dados", e);
		
		}
	}
	

	/**
	 * Remove do banco de dados a entidade passada no parâmetro
	 * 
	 * @param  entidade: 
	 * 			Cidade
	 * @throws Exception
	 */
	public void remove(Cidade entidade) throws Exception {
		try{
		em.remove(em.getReference(Cidade.class, entidade.getIdCidade()));
		}catch ( Exception e){
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	/**
	 * Gera a lista de cidade e retorna um {@link List}
	 * @return {@link List}
	 * @throws Exception
	 */
	public List<Cidade> listarCidades() throws Exception{
		return em.createNamedQuery("Cidade.findAll", Cidade.class).getResultList();
	}
	/**
	 * Busca uma cidade no banco de dados procurando pelo id passdo no parâmetro id	
	 * @param id
	 * @return {@link Cidade}
	 * @throws Exception
	 */
	public Cidade buscaCidadePorId(Integer id) throws Exception{
		final Session session = em.unwrap(Session.class);
		Cidade Cidade = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Cidade.class, session);
			crit.add(Restrictions.eq("idCidade", id));
			Cidade = (Cidade) crit.uniqueResult();
			return Cidade;
		} catch (final Exception e) {
			throw new Exception("Erro de operação (FindById) na base de dados", e);
		}
		
    }
	

}
