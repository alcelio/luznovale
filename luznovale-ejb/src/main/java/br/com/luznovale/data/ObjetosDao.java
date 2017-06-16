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
import org.jboss.logging.Logger;

import br.com.agsolutio.exceptions.DatabaseException;
import br.com.luznovale.model.Objeto;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class DrogaBeanDao
 */
@Stateless
@LocalBean
@Remote
public class ObjetosDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	Logger log = Logger.getLogger(Objeto.class);
	
	public ObjetosDao() {
	}
	
	public void salvarObjeto(Objeto entidade) throws Exception {
		if (entidade == null) {
			log.error("Operação não permitida, entidare recebida é nula");
			throw new Exception("Operação não permitida, entidare recebida é nula");
		}
		try {
			if (entidade.getIdObjeto() == null || entidade.getIdObjeto() == 0) {
				em.persist(entidade);
			} else {
				em.merge(entidade);
			}
		} catch (Exception e) {
			log.error("Erro ao persistir a droga [" + entidade.getDesObjeto()+"]");
			throw new Exception("Erro na operação (remove) na base de dados");
		}
	}
	
	public void remove(Objeto entidade) throws Exception {
		log.debug("Excluindo função [" + entidade.getDesObjeto()+"]...");
		try{
		em.remove(em.getReference(Objeto.class, entidade.getIdObjeto()));
		}catch ( Exception e){
			log.error("Erro de operação (remove) na base de dados");
			throw new Exception("Erro de operação (remove) na base de dados");
		}
		log.debug("Droga ["+entidade.getDesObjeto()+"] excluída com sucesso.");
	}

	public List<Objeto> listarObjetos() throws DatabaseException{
		log.debug("Listando funções...");
		
		try{
			List<Objeto> listaDeObjetos = em.createNamedQuery("Objeto.findAll", Objeto.class).getResultList(); 
			log.debug("Lista de obejtos gerada com sucesso.");
			return listaDeObjetos;
		}catch (Exception e){
			log.error("Erro de operação (ListarDrogas) na base de dados");
			throw new DatabaseException("Erro de operação (ListarDrogas) na base de dados");
		}
	}
		
	public Objeto buscaObjetoPorId(Integer id) throws Exception{
		log.debug("Buscando droga por id: ["+id+"]...");
		final Session session = em.unwrap(Session.class);
		Objeto objeto = null;
		try {
			final Criteria crit = CriaCriteria.createCriteria(Objeto.class, session);
			crit.add(Restrictions.eq("idDrogra", id));
			objeto = (Objeto) crit.uniqueResult();
			return objeto;
		} catch (final Exception e) {
			log.error("Erro de operação (buscaDrogaPorId) na base de dados");
			throw new Exception("Erro de operação (buscaDrogaPorId) na base de dados");
		}
    }
	
	

}
